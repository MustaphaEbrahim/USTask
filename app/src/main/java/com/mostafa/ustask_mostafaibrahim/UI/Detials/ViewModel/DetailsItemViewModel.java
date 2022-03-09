package com.mostafa.ustask_mostafaibrahim.UI.Detials.ViewModel;

import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.deliveryNo;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.BILL_NO_SRl;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnDataProviderResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.BillsItems.BillsItemValue;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.BillsDetailsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.DeliveryDetailsBills;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseViewModel;
import com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class DetailsItemViewModel extends BaseViewModel {
    private MutableLiveData<Boolean> isBillsDetailsReady = new MutableLiveData<>();
    public MutableLiveData<Boolean> getIsBillsReady() {
        return isBillsDetailsReady;
    }

    private List<DeliveryDetailsBills> deliveryDetailsBills = new ArrayList<>();
    public List<DeliveryDetailsBills> getBillsDetailsDelivery() {
        return deliveryDetailsBills;
    }
    public DetailsItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void DetailsBills(){
        BillsItemValue billsValue = new BillsItemValue();

        billsValue.setP_DLVRY_NO(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), deliveryNo,""));
        billsValue.setP_LANG_NO(getLanguageId());

        billsValue.setP_BILL_SRL(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), BILL_NO_SRl, ""));

        PostObject postObject = new PostObject(billsValue);

        getUserRepository().billsDetails(postObject, new OnDataProviderResponseListener<BillsDetailsResponse>() {
            @Override
            public void onSuccess(BillsDetailsResponse response) {
                deliveryDetailsBills.clear();
                deliveryDetailsBills.addAll(response.getBillsDetailsData().getDeliveryDetailsBills());
                isBillsDetailsReady.setValue(true);
            }

            @Override
            public void onError(Result result) {

            }
        });

    }

}

package com.mostafa.ustask_mostafaibrahim.UI.Other.ViewModel;

import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.deliveryNo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnRepoResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.BillsItems.BillsItemValue;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.BillsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.DeliveryBills;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseViewModel;
import com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class OtherViewModel extends BaseViewModel {

    private MutableLiveData<Boolean> isBillsReady = new MutableLiveData<>();
    public MutableLiveData<Boolean> getIsBillsReady() {
        return isBillsReady;
    }

    private List<DeliveryBills> deliveryBills = new ArrayList<>();

    public OtherViewModel(@NonNull Application application) {
        super(application);
    }

    public void bills(){

        BillsItemValue billsValue = new BillsItemValue();

        billsValue.setP_DLVRY_NO(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), deliveryNo,""));
        billsValue.setP_LANG_NO(getLanguageId());
        billsValue.setP_PRCSSD_FLG("1");

        PostObject postObject = new PostObject(billsValue);

        getUserRepository().bills(postObject, new OnRepoResponseListener<BillsResponse>() {
            @Override
            public void onSuccess(BillsResponse response) {
                deliveryBills.clear();
                deliveryBills.addAll(response.getBillsData().getDeliveryBills());
                isBillsReady.setValue(true);
            }

            @Override
            public void onError(Result result) {

            }
        });
    }



    public List<DeliveryBills> getBillsDelivery() {
        return deliveryBills;
    }
}

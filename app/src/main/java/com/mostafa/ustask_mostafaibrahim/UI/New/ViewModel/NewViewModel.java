package com.mostafa.ustask_mostafaibrahim.UI.New.ViewModel;

import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.deliveryNo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnDataProviderResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.BillsItems.BillsItemValue;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.BillsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.DeliveryBills;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseViewModel;
import com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class NewViewModel extends BaseViewModel {

    //private MutableLiveData<Boolean> billsMLD = new MutableLiveData<>();
    //public MutableLiveData<Boolean> getBillsMLD() {return billsMLD; }

    private MutableLiveData<Boolean> isBilsReady = new MutableLiveData<>();
    public MutableLiveData<Boolean> getIsBilsReady() {
        return isBilsReady;
    }



    private List<DeliveryBills> deliveryBillsList = new ArrayList<>();

    public NewViewModel(@NonNull Application application) {
        super(application);
    }

    public void bills(){

        BillsItemValue billsValue = new BillsItemValue();

        billsValue.setP_DLVRY_NO(SharedPreferenceHelper.getSharedPreferenceString(getApplication(),deliveryNo,""));
        billsValue.setP_LANG_NO(getLanguageId());
        billsValue.setP_PRCSSD_FLG("0");

        PostObject postObject = new PostObject(billsValue);

        getUserRepository().bills(postObject, new OnDataProviderResponseListener<BillsResponse>() {
            @Override
            public void onSuccess(BillsResponse response) {
                deliveryBillsList.clear();
                deliveryBillsList.addAll(response.getBillsData().getDeliveryBills());
                isBilsReady.setValue(true);
            }

            @Override
            public void onError(Result result) {

            }
        });
    }

    /*private String getDeliveryNO() {

        String sharedPreferenceHelper = SharedPreferenceHelper.getSharedPreferenceString(getApplication(), DELIVERY_KEY, "" );

        return sharedPreferenceHelper;
    }*/


    public List<DeliveryBills> getBillsDelivery() {
        return deliveryBillsList;
    }
}

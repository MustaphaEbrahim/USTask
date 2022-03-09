package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse;

import com.google.gson.annotations.SerializedName;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.ResponseObject;

public class BillsDetailsResponse extends ResponseObject {


    @SerializedName("Data")
    private BillsDetailsData billsDetailsData;

    public BillsDetailsData getBillsDetailsData() {
        return billsDetailsData;
    }
}

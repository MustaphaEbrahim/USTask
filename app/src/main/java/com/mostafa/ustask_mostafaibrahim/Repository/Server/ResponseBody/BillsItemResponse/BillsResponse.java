package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse;

import com.google.gson.annotations.SerializedName;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.ResponseObject;

public class BillsResponse extends ResponseObject {


    @SerializedName("Data")
    private BillsData billsData;

    public BillsData getBillsData() {
        return billsData;
    }
}

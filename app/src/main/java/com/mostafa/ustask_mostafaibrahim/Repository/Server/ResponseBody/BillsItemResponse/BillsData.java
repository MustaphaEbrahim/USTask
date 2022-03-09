package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BillsData {

    @SerializedName("DeliveryBills")
    private List<DeliveryBills> DeliveryBills;

    public List<DeliveryBills> getDeliveryBills() {
        return DeliveryBills;
    }
}

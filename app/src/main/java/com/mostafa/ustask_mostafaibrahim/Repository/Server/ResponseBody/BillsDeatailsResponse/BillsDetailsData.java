package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BillsDetailsData {

    @SerializedName("DeliveryBillItems")
    private List<DeliveryDetailsBills> deliveryDetailsBills;

    public List<DeliveryDetailsBills> getDeliveryDetailsBills() {
        return deliveryDetailsBills;
    }
}

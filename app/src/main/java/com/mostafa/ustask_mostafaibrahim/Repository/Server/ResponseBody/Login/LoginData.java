package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("DeliveryName")
    private String DeliveryName;

    public String getDeliveryName() {
        return DeliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        DeliveryName = deliveryName;
    }

}

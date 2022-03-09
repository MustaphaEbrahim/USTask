package com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.BillsItems;

import com.google.gson.annotations.SerializedName;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.Value;

public class BillsItemValue extends Value {

    @SerializedName("P_DLVRY_NO")
    private String P_DLVRY_NO;

    @SerializedName("P_PRCSSD_FLG")
    private String P_PRCSSD_FLG;
    @SerializedName("P_BILL_SRL")
    private String P_BILL_SRL;

    public String getP_DLVRY_NO() {
        return P_DLVRY_NO;
    }

    public void setP_DLVRY_NO(String p_DLVRY_NO) {
        P_DLVRY_NO = p_DLVRY_NO;
    }

    public String getP_PRCSSD_FLG() {
        return P_PRCSSD_FLG;
    }

    public void setP_PRCSSD_FLG(String p_PRCSSD_FLG) {
        P_PRCSSD_FLG = p_PRCSSD_FLG;
    }

    public String getP_BILL_SRL() {
        return P_BILL_SRL;
    }

    public void setP_BILL_SRL(String p_BILL_SRL) {
        P_BILL_SRL = p_BILL_SRL;
    }
}

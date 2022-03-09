package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse;

import com.google.gson.annotations.SerializedName;

public class DeliveryDetailsBills {

    @SerializedName("BILL_NO")
    private String BILL_NO;

    @SerializedName("BILL_SRL")
    private String BILL_SRL;

    @SerializedName("ITM_UNT")
    private String ITM_UNT;

    @SerializedName("I_CODE")
    private String I_CODE;

    @SerializedName("I_NM")
    private String I_NM;

    @SerializedName("I_PRICE")
    private String I_PRICE;

    @SerializedName("I_PRICE_VAT")
    private String I_PRICE_VAT;

    @SerializedName("I_QTY")
    private String I_QTY;

    @SerializedName("MOBILE_NO")
    private String MOBILE_NO;

    @SerializedName("P_SIZE")
    private String P_SIZE;

    @SerializedName("VAT_AMT")
    private String VAT_AMT;

    @SerializedName("VAT_PRCNT")
    private String VAT_PRCNT;

    public String getBILL_NO() {
        return BILL_NO;
    }

    public void setBILL_NO(String BILL_NO) {
        this.BILL_NO = BILL_NO;
    }

    public String getBILL_SRL() {
        return BILL_SRL;
    }

    public void setBILL_SRL(String BILL_SRL) {
        this.BILL_SRL = BILL_SRL;
    }

    public String getITM_UNT() {
        return ITM_UNT;
    }

    public void setITM_UNT(String ITM_UNT) {
        this.ITM_UNT = ITM_UNT;
    }

    public String getI_CODE() {
        return I_CODE;
    }

    public void setI_CODE(String i_CODE) {
        I_CODE = i_CODE;
    }

    public String getI_NM() {
        return I_NM;
    }

    public void setI_NM(String i_NM) {
        I_NM = i_NM;
    }

    public String getI_PRICE() {
        return I_PRICE;
    }

    public void setI_PRICE(String i_PRICE) {
        I_PRICE = i_PRICE;
    }

    public String getI_PRICE_VAT() {
        return I_PRICE_VAT;
    }

    public void setI_PRICE_VAT(String i_PRICE_VAT) {
        I_PRICE_VAT = i_PRICE_VAT;
    }

    public String getI_QTY() {
        return I_QTY;
    }

    public void setI_QTY(String i_QTY) {
        I_QTY = i_QTY;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getP_SIZE() {
        return P_SIZE;
    }

    public void setP_SIZE(String p_SIZE) {
        P_SIZE = p_SIZE;
    }

    public String getVAT_AMT() {
        return VAT_AMT;
    }

    public void setVAT_AMT(String VAT_AMT) {
        this.VAT_AMT = VAT_AMT;
    }

    public String getVAT_PRCNT() {
        return VAT_PRCNT;
    }

    public void setVAT_PRCNT(String VAT_PRCNT) {
        this.VAT_PRCNT = VAT_PRCNT;
    }
}

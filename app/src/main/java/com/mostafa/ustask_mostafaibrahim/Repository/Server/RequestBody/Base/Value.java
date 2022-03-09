package com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base;

import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("P_LANG_NO")
    private String P_LANG_NO;

    public String getP_LANG_NO() {
        return P_LANG_NO;
    }

    public void setP_LANG_NO(String p_LANG_NO) {
        P_LANG_NO = p_LANG_NO;
    }
}

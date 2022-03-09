package com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.login;

import com.google.gson.annotations.SerializedName;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.Value;

public class LoginValue extends Value {



    @SerializedName("P_DLVRY_NO")
    private String P_DLVRY_NO;


    @SerializedName("P_PSSWRD")
    private String P_PSSWRD;


    public String getP_DLVRY_NO() {
        return P_DLVRY_NO;
    }

    public void setP_DLVRY_NO(String p_DLVRY_NO) {
        P_DLVRY_NO = p_DLVRY_NO;
    }

    public String getP_PSSWRD() {
        return P_PSSWRD;
    }

    public void setP_PSSWRD(String p_PSSWRD) {
        P_PSSWRD = p_PSSWRD;
    }
}

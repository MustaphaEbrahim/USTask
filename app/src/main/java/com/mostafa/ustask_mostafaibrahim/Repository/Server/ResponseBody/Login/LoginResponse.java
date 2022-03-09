package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login;

import com.google.gson.annotations.SerializedName;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.ResponseObject;

public class LoginResponse extends ResponseObject {

   @SerializedName("Data")
    LoginData loginData;

    public LoginData getLoginData() {
        return loginData;
    }
}

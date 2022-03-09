package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("ErrMsg")
    String ErrorMessage="";

    @SerializedName("ErrNo")
    int ErrorNumber=-1;

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public void setErrorNumber(int errorNumber) {
        ErrorNumber = errorNumber;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }


    public int getErrorNumber() {
        return ErrorNumber;
    }



 }

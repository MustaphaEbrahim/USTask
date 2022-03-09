package com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base;

import com.google.gson.annotations.SerializedName;

public class ResponseObject {


    @SerializedName("Result")
    Result result;

    public Result getResult() {
        return result;
    }
}

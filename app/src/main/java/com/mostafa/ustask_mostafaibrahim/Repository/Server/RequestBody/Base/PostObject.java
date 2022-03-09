package com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base;

import com.google.gson.annotations.SerializedName;

public class PostObject {


    public PostObject(Value value) {
        this.Value = value;
    }

    @SerializedName("Value")
    Value Value;




}

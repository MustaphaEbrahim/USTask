package com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base;


import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;

public interface OnRepoResponseListener<T> {

    void onSuccess(T response);

    void onError(Result result);
}

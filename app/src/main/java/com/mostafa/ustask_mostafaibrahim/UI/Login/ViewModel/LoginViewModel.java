package com.mostafa.ustask_mostafaibrahim.UI.Login.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnDataProviderResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.login.LoginValue;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login.LoginResponse;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    private MutableLiveData<String> loginMLD = new MutableLiveData<>();

    public MutableLiveData<String> getLoginMLD() {
        return loginMLD;
    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    public void login(String P_LANG_NO, String P_DLVRY_NO, String P_PSSWRD) {

        LoginValue loginValue = new LoginValue();

        loginValue.setP_LANG_NO(P_LANG_NO);
        loginValue.setP_DLVRY_NO(P_DLVRY_NO);
        loginValue.setP_PSSWRD(P_PSSWRD);

        PostObject postObject = new PostObject(loginValue);


        getUserRepository().login(postObject, new OnDataProviderResponseListener<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {

                loginMLD.postValue(response.getLoginData().getDeliveryName());
            }

            @Override
            public void onError(Result result) {

            }
        });
    }

}


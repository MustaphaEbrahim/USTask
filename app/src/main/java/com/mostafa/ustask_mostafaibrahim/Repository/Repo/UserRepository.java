package com.mostafa.ustask_mostafaibrahim.Repository.Repo;


import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.BaseDataProvider;
import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnDataProviderResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.User.User;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.User.UserDao;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.BillsDetailsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.BillsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login.LoginResponse;

public class UserRepository extends BaseDataProvider<UserDao> {
    public static UserRepository sharedInstance = new UserRepository();


    @Override
    public UserDao getDao() {
        return this.mDb.userDao();
    }

    public void login(PostObject postObject, OnDataProviderResponseListener<LoginResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().Login(postObject),
                new OnDataProviderResponseListener<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {

                responseListener.onSuccess(response);
            }

            @Override
            public void onError(Result result) {

                responseListener.onError(result);
            }
        });
    }

    public void bills(PostObject postObject, OnDataProviderResponseListener<BillsResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().Bills(postObject), new OnDataProviderResponseListener<BillsResponse>() {
            @Override
            public void onSuccess(BillsResponse response) {
                responseListener.onSuccess(response);
            }

            @Override
            public void onError(Result result) {
                responseListener.onError(result);
            }
        });
    }

    public void billsDetails(PostObject postObject, OnDataProviderResponseListener<BillsDetailsResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().BillsDetails(postObject), new OnDataProviderResponseListener<BillsDetailsResponse>() {
            @Override
            public void onSuccess(BillsDetailsResponse response) {
                responseListener.onSuccess(response);
            }

            @Override
            public void onError(Result result) {
                responseListener.onError(result);
            }
        });
    }

    public void getUser(OnDataProviderResponseListener<User> responseListener) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                responseListener.onSuccess(getDao().getUser());
            }
        });
    }


}


package com.mostafa.ustask_mostafaibrahim.Repository.Repo;


import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.BaseRepo;
import com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base.OnRepoResponseListener;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.User.User;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.User.UserDao;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Base.Result;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.BillsDetailsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.BillsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login.LoginResponse;

public class UserRepository extends BaseRepo<UserDao> {
    public static UserRepository sharedInstance = new UserRepository();


    @Override
    public UserDao getDao() {
        return this.mDb.userDao();
    }

    public void login(PostObject postObject, OnRepoResponseListener<LoginResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().Login(postObject),
                new OnRepoResponseListener<LoginResponse>() {
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

    public void bills(PostObject postObject, OnRepoResponseListener<BillsResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().Bills(postObject), new OnRepoResponseListener<BillsResponse>() {
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

    public void billsDetails(PostObject postObject, OnRepoResponseListener<BillsDetailsResponse> responseListener){
        webServiceConsumer.callService(webServiceConsumer.getApi().BillsDetails(postObject), new OnRepoResponseListener<BillsDetailsResponse>() {
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

    public void getUser(OnRepoResponseListener<User> responseListener) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                responseListener.onSuccess(getDao().getUser());
            }
        });
    }


}


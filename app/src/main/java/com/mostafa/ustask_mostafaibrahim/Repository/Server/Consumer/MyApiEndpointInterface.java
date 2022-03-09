package com.mostafa.ustask_mostafaibrahim.Repository.Server.Consumer;

import com.mostafa.ustask_mostafaibrahim.Repository.Server.RequestBody.Base.PostObject;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.BillsDetailsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.BillsResponse;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.Login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;



public interface MyApiEndpointInterface {

//        Call<ResponseObject> call = apiService.LoginActivity(type, year, fnYear, String.valueOf(LangId), branchNo, userNo, password);
/*
    @GET("CheckLogIn?")
    Call<LoginResponse> Login(@Query("type") String type,
                              @Query("year") int year,
                              @Query("activityNumber") int fnYear,
                              @Query("languageID") int languageID,
                              @Query("branchNumber") int BranchNo,
                              @Query("userID") int userID,
                              @Query("userPassword") String Password);*/


    @POST("CheckDeliveryLogin")
    Call<LoginResponse> Login(@Body PostObject postObject);

    @POST("GetDeliveryBillsItems")
    Call<BillsResponse> Bills(@Body PostObject postObject);

    @POST("GetDeliveryBillsItems")
    Call<BillsDetailsResponse> BillsDetails(@Body PostObject postObject);



}


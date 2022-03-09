package com.mostafa.ustask_mostafaibrahim.UI.Base;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mostafa.ustask_mostafaibrahim.Repository.Repo.UserRepository;
import com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper;

import java.util.Locale;

public abstract class BaseViewModel extends AndroidViewModel {

    private UserRepository userRepository = UserRepository.sharedInstance;

    public MutableLiveData<Boolean> isConnectToInternetMutableLiveData = new MutableLiveData<>();
    Context context;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


    public void setContext(Context context) {
        this.context = context;
    }





    public MutableLiveData<Boolean> getIsConnectToInternetMutableLiveData() {
        return isConnectToInternetMutableLiveData;
    }

    public void setIsConnectToInternet(boolean status) {
        this.isConnectToInternetMutableLiveData.setValue(status);
    }




    public String getLanguageId() {
        String Language = SharedPreferenceHelper.getSharedPreferenceString(getApplication(), SharedPreferenceHelper.LANGUAGE_KEY, Locale.getDefault().getLanguage());
        if (Language.equalsIgnoreCase("ar")) {
            return "1";
        }
        if (Language.equalsIgnoreCase("en")) {
            return "2";
        }
        return "2";
    }

    public UserRepository getUserRepository(){
        return userRepository;
    }
}

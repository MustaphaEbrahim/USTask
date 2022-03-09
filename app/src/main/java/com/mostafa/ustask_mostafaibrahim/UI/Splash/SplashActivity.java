package com.mostafa.ustask_mostafaibrahim.UI.Splash;

import android.content.Intent;
import android.os.Bundle;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Login.View.LoginActivity;
import com.mostafa.ustask_mostafaibrahim.databinding.ActivitySplashBinding;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        timer();


    }

    public void timer(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }, 5000);
    }

    @Override
    public void initViewModel() {

    }

    @Override
    public void initObservers() {

    }

    @Override
    public void initErrorObservers() {

    }

    @Override
    public void initLoadingObservers() {

    }
}
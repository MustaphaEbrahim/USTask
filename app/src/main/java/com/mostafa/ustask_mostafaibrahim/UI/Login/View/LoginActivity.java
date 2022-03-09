package com.mostafa.ustask_mostafaibrahim.UI.Login.View;

import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.deliveryNo;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.nameDelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mostafa.ustask_mostafaibrahim.databinding.ActivityLoginBinding;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Login.ViewModel.LoginViewModel;
import com.mostafa.ustask_mostafaibrahim.UI.Main.View.MainActivity;
import com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper;

public class LoginActivity extends BaseActivity {


    public static final String DELIVERY_KEY = "delivery_number" ;
    public String x;
    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initListener();
    }

    private void initListener() {
        binding.Buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkFiles()){
                    viewModel.login(getLanguageId() ,binding.userId.getText().toString(), binding.passwordLogin.getText().toString());
                    /*String deliveryNO = binding.userId.getText().toString();

                    String sharedPreferenceHelper = SharedPreferenceHelper.getSharedPreferenceString(context,DELIVERY_KEY,deliveryNO);*/

                }
            }
        });


        binding.LanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeLanguage();
            }
        });
    }



    private boolean checkFiles() {
        if (binding.userId.getText().toString().isEmpty()){
            binding.userId.setError("enter User ID");
            binding.userId.requestFocus();
            return false;
        }
        if(binding.passwordLogin.getText().toString().isEmpty()){
            binding.passwordLogin.setError("Please enter Your password !");
            binding.passwordLogin.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void initViewModel() {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        setViewModel(viewModel);
    }

    @Override
    public void initObservers() {

        viewModel.getLoginMLD().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String deliveryName) {
                Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                SharedPreferenceHelper.setSharedPreferenceString(context,nameDelivery,deliveryName);
                SharedPreferenceHelper.setSharedPreferenceString(context,deliveryNo,binding.userId.getText().toString());
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initErrorObservers() {

    }

    @Override
    public void initLoadingObservers() {

    }
}
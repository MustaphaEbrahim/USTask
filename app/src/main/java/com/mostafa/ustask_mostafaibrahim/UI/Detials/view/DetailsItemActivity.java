package com.mostafa.ustask_mostafaibrahim.UI.Detials.view;

import androidx.lifecycle.Observer;

import static com.mostafa.ustask_mostafaibrahim.Util.CommonMethods.round;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.CUSTOMER_NAME;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.DATE_ORDER;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.DELIVERY;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.ORDER_NUMBER;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.SUBTOTAL;
import static com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper.TAXES;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.mostafa.ustask_mostafaibrahim.Adapters.AdapterOrderDetails;
import com.mostafa.ustask_mostafaibrahim.R;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Detials.ViewModel.DetailsItemViewModel;
import com.mostafa.ustask_mostafaibrahim.Util.SharedPreferenceHelper;
import com.mostafa.ustask_mostafaibrahim.databinding.ActivityDetailsItemBinding;

public class DetailsItemActivity extends BaseActivity {

    private ActivityDetailsItemBinding binding;
    private DetailsItemViewModel viewModel;
    private AdapterOrderDetails adapterOrderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
        initView();
        initListener();

        viewModel.DetailsBills();
    }

    private void initRecyclerView() {
        binding.DetailsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapterOrderDetails = new AdapterOrderDetails(viewModel.getBillsDetailsDelivery());
        binding.DetailsRecyclerView.setAdapter(adapterOrderDetails);
    }

    public void initListener(){
        binding.CustomerDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.CustomerName.getVisibility() == View.VISIBLE){
                    viewGone();
                }else {
                    viewVisible();
                }
            }
        });

        binding.OrderDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.total.getVisibility() == View.VISIBLE){
                    viewOrderDetailsGone();
                }else {
                    viewOrderDetailsVisible();
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void initView(){
        binding.CustomerName.setText(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), CUSTOMER_NAME, ""));
        binding.orderDate.setText(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), DATE_ORDER, ""));
        binding.orderNumber.setText(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), ORDER_NUMBER,""));

        binding.subtotalLE.setText(round(SharedPreferenceHelper.getSharedPreferenceString(getApplication(),SUBTOTAL, ""),2));
        binding.taxesLE.setText(round(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), TAXES, ""),2));
        binding.deliveryLE.setText(round(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), DELIVERY, ""),2));

        Double sum = Double.parseDouble(SharedPreferenceHelper.getSharedPreferenceString(getApplication(),SUBTOTAL, ""))+
                Double.parseDouble(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), TAXES, "")) +
                        Double.parseDouble(SharedPreferenceHelper.getSharedPreferenceString(getApplication(), DELIVERY, ""));
        binding.TotalPriceLE.setText(round(String.valueOf(sum),2));

    }
    @Override
    public void initViewModel() {
        viewModel = new ViewModelProvider(this).get(DetailsItemViewModel.class);
        setViewModel(viewModel);
    }

    @Override
    public void initObservers() {
        viewModel.getIsBillsReady().observe(this, new Observer<Boolean>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(Boolean aBoolean) {
                adapterOrderDetails.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initErrorObservers() {

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void viewGone(){
        binding.CustomerName.setVisibility(View.GONE);
        binding.orderDate.setVisibility(View.GONE);
        binding.orderNumber.setVisibility(View.GONE);
        binding.textView1.setVisibility(View.GONE);
        binding.textView6.setVisibility(View.GONE);
        binding.textView5.setVisibility(View.GONE);
        binding.PaymentOption.setVisibility(View.GONE);
        binding.textView7.setVisibility(View.GONE);
        binding.CustomerDetailsButton.setBackground(getResources().getDrawable(R.drawable.ic_baseline_arrow_drop_up_24));

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void viewVisible(){
        binding.CustomerName.setVisibility(View.VISIBLE);
        binding.orderDate.setVisibility(View.VISIBLE);
        binding.orderNumber.setVisibility(View.VISIBLE);
        binding.textView1.setVisibility(View.VISIBLE);
        binding.textView6.setVisibility(View.VISIBLE);
        binding.textView5.setVisibility(View.VISIBLE);
        binding.PaymentOption.setVisibility(View.VISIBLE);
        binding.textView7.setVisibility(View.VISIBLE);
        binding.CustomerDetailsButton.setBackground(getResources().getDrawable(R.drawable.ic_baseline_arrow_drop_down_24));
    }

    public void viewOrderDetailsGone(){
        binding.tabDetails.setVisibility(View.GONE);
        binding.DetailsRecyclerView.setVisibility(View.GONE);
        binding.llSumPrice.setVisibility(View.GONE);
        binding.viewTotalPrice.setVisibility(View.GONE);
        binding.viewOrder.setVisibility(View.GONE);
        binding.total.setVisibility(View.GONE);
        binding.TotalPriceLE.setVisibility(View.GONE);
    }
    public void viewOrderDetailsVisible(){
        binding.tabDetails.setVisibility(View.VISIBLE);
        binding.DetailsRecyclerView.setVisibility(View.VISIBLE);
        binding.llSumPrice.setVisibility(View.VISIBLE);
        binding.viewTotalPrice.setVisibility(View.VISIBLE);
        binding.viewOrder.setVisibility(View.VISIBLE);
        binding.total.setVisibility(View.VISIBLE);
        binding.TotalPriceLE.setVisibility(View.VISIBLE);
    }

    @Override
    public void initLoadingObservers() {

    }
}
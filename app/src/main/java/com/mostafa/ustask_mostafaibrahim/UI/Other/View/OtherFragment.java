package com.mostafa.ustask_mostafaibrahim.UI.Other.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.DeliveryBills;
import com.mostafa.ustask_mostafaibrahim.UI.Detials.view.DetailsItemActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Login.View.LoginActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Main.View.RecyclerViewClickInterface;
import com.mostafa.ustask_mostafaibrahim.databinding.FragmentOtherBinding;
import com.mostafa.ustask_mostafaibrahim.Adapters.AdapterNewBills;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseFragment;
import com.mostafa.ustask_mostafaibrahim.UI.Other.ViewModel.OtherViewModel;


public class OtherFragment extends BaseFragment implements RecyclerViewClickInterface {

    private FragmentOtherBinding binding;
    private OtherViewModel viewModel;
    private AdapterNewBills adapterNewBills;

    public OtherFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentOtherBinding.inflate(inflater, container, false);

        viewModel.bills();
        initRecyclerView();

        return binding.getRoot();
    }

    private void initRecyclerView() {
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapterNewBills = new AdapterNewBills(viewModel.getBillsDelivery(),this);
        binding.RecyclerView.setAdapter(adapterNewBills);
    }

    @Override
    public void initViewModel() {
        viewModel = new ViewModelProvider(this).get(OtherViewModel.class);
        setViewModel(viewModel);
    }

    @Override
    public void initObservers() {
        viewModel.getIsBillsReady().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                adapterNewBills.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initLoading() {

    }

    @Override
    public void initOnErrorObserver() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(DeliveryBills position) {
        Intent intent = new Intent(getContext(), DetailsItemActivity.class);
        startActivity(intent);
    }
}
package com.mostafa.ustask_mostafaibrahim.UI.New.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mostafa.ustask_mostafaibrahim.Adapters.AdapterNewBills;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.DeliveryBills;
import com.mostafa.ustask_mostafaibrahim.UI.Login.View.LoginActivity;
import com.mostafa.ustask_mostafaibrahim.UI.Main.View.RecyclerViewClickInterface;
import com.mostafa.ustask_mostafaibrahim.UI.New.ViewModel.NewViewModel;
import com.mostafa.ustask_mostafaibrahim.databinding.FragmentNewBinding;
import com.mostafa.ustask_mostafaibrahim.UI.Base.BaseFragment;


import org.jetbrains.annotations.NotNull;


public class NewFragment extends BaseFragment implements RecyclerViewClickInterface {

    private FragmentNewBinding binding;
    private NewViewModel viewModel;
    private AdapterNewBills adapterNewBills;


    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentNewBinding.inflate(inflater, container, false);

        viewModel.bills();
        initRecyclerView();

        return binding.getRoot();
    }

    private void initRecyclerView() {
        binding.newRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapterNewBills = new AdapterNewBills(viewModel.getBillsDelivery(),this);
        binding.newRecyclerView.setAdapter(adapterNewBills);
    }


    @Override
    public void initViewModel() {
        viewModel = new ViewModelProvider(this).get(NewViewModel.class);
        setViewModel(viewModel);
    }

    @Override
    public void initObservers() {
        viewModel.getIsBilsReady().observe(this, new Observer<Boolean>() {
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
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }
}
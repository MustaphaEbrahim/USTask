package com.mostafa.ustask_mostafaibrahim.Adapters;

import static com.mostafa.ustask_mostafaibrahim.Util.CommonMethods.round;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsDeatailsResponse.DeliveryDetailsBills;
import com.mostafa.ustask_mostafaibrahim.Util.RecyclerViewHolders;
import com.mostafa.ustask_mostafaibrahim.databinding.OrderDetailsItemRowBinding;

import java.util.List;

public class AdapterOrderDetails extends RecyclerView.Adapter<RecyclerViewHolders.OrderDetailsViewHolder> {

    private List<DeliveryDetailsBills> billsDataList;

    public AdapterOrderDetails(List<DeliveryDetailsBills> billsDataList){
        this.billsDataList = billsDataList;
    }

    @NonNull
    @Override
    public RecyclerViewHolders.OrderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolders.OrderDetailsViewHolder(OrderDetailsItemRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders.OrderDetailsViewHolder holder, int position) {

        DeliveryDetailsBills deliveryBills = billsDataList.get(position);

        holder.items.setText(deliveryBills.getI_NM());
        holder.price.setText(round(deliveryBills.getI_PRICE(),2));
        holder.quantity.setText("x" + deliveryBills.getI_QTY());
    }


    @Override
    public int getItemCount() {
        return billsDataList.size();
    }
}

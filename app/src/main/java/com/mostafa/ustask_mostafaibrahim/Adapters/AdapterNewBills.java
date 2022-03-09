package com.mostafa.ustask_mostafaibrahim.Adapters;

import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.BILL_NO_SRl;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.CUSTOMER_NAME;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.DATE_ORDER;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.DELIVERY;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.ORDER_NUMBER;

import static com.mostafa.ustask_mostafaibrahim.Utilities.CommonMethods.round;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.SUBTOTAL;
import static com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper.TAXES;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafa.ustask_mostafaibrahim.R;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.ResponseBody.BillsItemResponse.DeliveryBills;
import com.mostafa.ustask_mostafaibrahim.UI.Main.View.RecyclerViewClickInterface;
import com.mostafa.ustask_mostafaibrahim.Utilities.RecyclerViewHolders;
import com.mostafa.ustask_mostafaibrahim.Utilities.SharedPreferenceHelper;
import com.mostafa.ustask_mostafaibrahim.databinding.BillsRowBinding;

import java.util.List;

public class AdapterNewBills extends RecyclerView.Adapter<RecyclerViewHolders.NewViewHolder> {
    private List<DeliveryBills> billsDataList;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public AdapterNewBills(List<DeliveryBills> billsDataList, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.billsDataList = billsDataList;
        this.recyclerViewClickInterface= recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public RecyclerViewHolders.NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new RecyclerViewHolders.NewViewHolder(BillsRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders.NewViewHolder holder, int position) {

        DeliveryBills deliveryBills = billsDataList.get(position);

        Double Sum = Double.parseDouble(deliveryBills.getBILL_AMT()) + Double.parseDouble(deliveryBills.getDLVRY_AMT()) + Double.parseDouble(deliveryBills.getTAX_AMT());

        holder.billshash.setText("#" + deliveryBills.getBILL_NO());
        holder.tottalPrice.setText(round(String.valueOf(Sum),2));
        holder.date.setText(deliveryBills.getBILL_DATE());


        if (deliveryBills.getDLVRY_STATUS_FLG().equals("1")){
            holder.NewStatus.setText("Delivered");
            holder.billOrderColor.setBackgroundResource(R.color.tabColorSelect);
            holder.NewStatus.setTextColor(Color.parseColor("#004F62"));
        }else if (deliveryBills.getDLVRY_STATUS_FLG().equals("2")){
            holder.NewStatus.setText("Partial");
            holder.billOrderColor.setBackgroundResource(R.color.partial_color);
            holder.NewStatus.setTextColor(Color.parseColor("#707070"));
        }else if(deliveryBills.getDLVRY_STATUS_FLG().equals("0")){
            holder.NewStatus.setText("New");
            holder.billOrderColor.setBackgroundResource(R.color.billsrow);
            holder.NewStatus.setTextColor(Color.parseColor("#29D40F"));
        }else {
            holder.NewStatus.setText("Full Return");
            holder.billOrderColor.setBackgroundResource(R.color.colorPrimaryDark);
            holder.NewStatus.setTextColor(Color.parseColor("#D42A0F"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewClickInterface.onItemClick(deliveryBills);
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(), BILL_NO_SRl,deliveryBills.getBILL_SRL());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(),CUSTOMER_NAME, deliveryBills.getCSTMR_NM());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(),ORDER_NUMBER, deliveryBills.getBILL_NO());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(),DATE_ORDER, deliveryBills.getBILL_DATE());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(),SUBTOTAL, deliveryBills.getBILL_AMT());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(),TAXES, deliveryBills.getTAX_AMT());
                SharedPreferenceHelper.setSharedPreferenceString(view.getContext(), DELIVERY, deliveryBills.getDLVRY_AMT());
            }
        });

    }

    @Override
    public int getItemCount() {
        return billsDataList.size();
    }
}

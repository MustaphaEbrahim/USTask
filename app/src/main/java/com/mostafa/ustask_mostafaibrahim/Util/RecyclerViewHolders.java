package com.mostafa.ustask_mostafaibrahim.Util;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mostafa.ustask_mostafaibrahim.databinding.BillsRowBinding;
import com.mostafa.ustask_mostafaibrahim.databinding.OrderDetailsItemRowBinding;


public class RecyclerViewHolders {

    public static class NewViewHolder extends RecyclerView.ViewHolder{

        public TextView
                billshash,
                tottalPrice,
                date,
                NewStatus,
                billOrderColor;


        public NewViewHolder(BillsRowBinding rowBinding) {
            super(rowBinding.getRoot());

            billshash = rowBinding.billshash;
            tottalPrice = rowBinding.totalPrice;
            date = rowBinding.date;
            NewStatus = rowBinding.NewStatus;
            billOrderColor = rowBinding.billOrderColor;
        }
    }

    public static class OrderDetailsViewHolder extends RecyclerView.ViewHolder{

        public TextView
                items,
                quantity,
                price;
        public OrderDetailsViewHolder(OrderDetailsItemRowBinding rowBinding){
            super(rowBinding.getRoot());

            items = rowBinding.items;
            quantity = rowBinding.quantity;
            price = rowBinding.price;

        }
    }


}

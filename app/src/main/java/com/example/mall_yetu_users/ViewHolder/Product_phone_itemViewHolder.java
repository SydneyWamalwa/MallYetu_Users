package com.example.mall_yetu_users.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mall_yetu_users.Interface.ItemClickListner;
import com.example.mall_yetu_users.R;

public class Product_phone_itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView img;
    public TextView shpname;

    public TextView shprice;

    public ItemClickListner listner;
    public Product_phone_itemViewHolder(@NonNull View itemView) {
        super(itemView);


        img=(ImageView) itemView.findViewById(R.id.imageView2);
        shpname=(TextView) itemView.findViewById(R.id.textView9);

        shprice=(TextView) itemView.findViewById(R.id.textView11);
    }
    public void setItemClickListener(ItemClickListner listner){
        this.listner=listner;
    }
    @Override
    public void onClick(View view) {
        listner.onclick(view,getAdapterPosition(),false);

    }
}

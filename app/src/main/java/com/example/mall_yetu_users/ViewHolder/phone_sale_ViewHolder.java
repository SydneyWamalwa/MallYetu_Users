package com.example.mall_yetu_users.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mall_yetu_users.Interface.ItemClickListner;
import com.example.mall_yetu_users.R;

public class phone_sale_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView img;

    public TextView shdesc;
    public TextView shprice;

    public ItemClickListner listner;
    public phone_sale_ViewHolder(@NonNull View itemView) {
        super(itemView);
        img=(ImageView) itemView.findViewById(R.id.imageView11);
        shdesc=(TextView) itemView.findViewById(R.id.textView6);
        shprice=(TextView) itemView.findViewById(R.id.textView7);
    }
    public void setItemClickListener(ItemClickListner listner){
        this.listner=listner;
    }
    @Override
    public void onClick(View view) {
        listner.onclick(view,getAdapterPosition(),false);

    }
}

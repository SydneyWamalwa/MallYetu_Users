package com.example.mall_yetu_users.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mall_yetu_users.Interface.ItemClickListner;
import com.example.mall_yetu_users.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public ImageView img;
    public TextView shname;


    public ItemClickListner listner;
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);


        img=(ImageView) itemView.findViewById(R.id.imageView14);
        shname=(TextView) itemView.findViewById(R.id.textView5);


    }


public void setItemClickListener(ItemClickListner listner){
        this.listner=listner;
}
    @Override
    public void onClick(View view) {
listner.onclick(view,getAdapterPosition(),false);

    }
}

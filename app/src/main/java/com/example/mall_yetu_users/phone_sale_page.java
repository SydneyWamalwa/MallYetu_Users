package com.example.mall_yetu_users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mall_yetu_users.Model.phone_item_sales;
import com.example.mall_yetu_users.Model.phone_items_details;
import com.example.mall_yetu_users.ViewHolder.Product_phone_itemViewHolder;
import com.example.mall_yetu_users.ViewHolder.phone_sale_ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class phone_sale_page extends AppCompatActivity {
    RecyclerView view;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_sale_page);

            view=findViewById(R.id.recyclerView2);
            reference= FirebaseDatabase.getInstance().getReference("https://duka-3085d-default-rtdb.firebaseio.com/").child("Products_Phones");

        }

        @Override
        protected void onStart() {
            super.onStart();
            FirebaseRecyclerOptions<phone_item_sales> options=new FirebaseRecyclerOptions.Builder<phone_item_sales>().
                    setQuery(reference,phone_item_sales.class).build();


            FirebaseRecyclerAdapter<phone_item_sales, phone_sale_ViewHolder> adapter =new FirebaseRecyclerAdapter<phone_item_sales, phone_sale_ViewHolder>(options) {
                @Override
                protected void onBindViewHolder(@NonNull phone_sale_ViewHolder holder, int position, @NonNull phone_item_sales model) {
                    holder.shdesc.setText(model.getShdesc());
                    holder.shprice.setText("Price="+model.getShpr()+"Ksh.");
                    Picasso.get().load(model.getImg()).into(holder.img);
                }





                @NonNull
                @Override
                public phone_sale_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_phone_shops,parent,false);
                    phone_sale_ViewHolder holder=new phone_sale_ViewHolder(view);
                    return holder;
                }
            };
            view.setAdapter(adapter);
            adapter.startListening();


        }

    }

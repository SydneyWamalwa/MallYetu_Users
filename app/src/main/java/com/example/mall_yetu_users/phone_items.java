package com.example.mall_yetu_users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mall_yetu_users.Interface.ItemClickListner;
import com.example.mall_yetu_users.Model.Products;
import com.example.mall_yetu_users.Model.phone_items_details;
import com.example.mall_yetu_users.ViewHolder.ProductViewHolder;
import com.example.mall_yetu_users.ViewHolder.Product_phone_itemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class phone_items extends AppCompatActivity {
RecyclerView view;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_items);
        view=findViewById(R.id.recyclerView2);
        reference= FirebaseDatabase.getInstance().getReference("https://duka-3085d-default-rtdb.firebaseio.com/").child("products");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<phone_items_details> options=new FirebaseRecyclerOptions.Builder<phone_items_details>().
                setQuery(reference,phone_items_details.class).build();


        FirebaseRecyclerAdapter<phone_items_details,Product_phone_itemViewHolder> adapter =new FirebaseRecyclerAdapter<phone_items_details, Product_phone_itemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Product_phone_itemViewHolder holder, int position, @NonNull phone_items_details model) {
                holder.shpname.setText(model.getPname());
                holder.shprice.setText("Price="+model.getDescription()+"Ksh.");
                Picasso.get().load(model.getImg()).into(holder.img);

                holder.setItemClickListener(new ItemClickListner() {
                    @Override
                    public void onclick(View view, int position, boolean isLongClick) {
                        Intent intent=new Intent(phone_items.this,phone_sale_page.class);
                        intent.putExtra("pid",model.getPid());
                        startActivity(intent);
                    }
                });
            }



            @NonNull
            @Override
            public Product_phone_itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_phone_shops,parent,false);
                Product_phone_itemViewHolder holder=new Product_phone_itemViewHolder(view);
                return holder;
            }
        };
        view.setAdapter(adapter);
        adapter.startListening();


    }

    }

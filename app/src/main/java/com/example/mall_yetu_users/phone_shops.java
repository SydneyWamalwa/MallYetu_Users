package com.example.mall_yetu_users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mall_yetu_users.Interface.ItemClickListner;
import com.example.mall_yetu_users.Model.Products;
import com.example.mall_yetu_users.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


public class phone_shops extends AppCompatActivity {
    RecyclerView view;
    DatabaseReference reference;
    FirebaseStorage storage;
    StorageReference sreference;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_shops);

        view=findViewById(R.id.recyclerView12);
        sreference= storage.getReference();
        reference=FirebaseDatabase.getInstance().getReference("https://duka-3085d-default-rtdb").child("phone shops");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Products> options=new FirebaseRecyclerOptions.Builder<Products>().
                setQuery(reference,Products.class).build();

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Products model) {

                holder.shname.setText(model.getShname());
                Picasso.get().load(model.getImg()).resizeDimen(R.dimen.image_s,R.dimen.image_s).into(holder.img);
                holder.setItemClickListener(new ItemClickListner() {
                    @Override
                    public void onclick(View view, int position, boolean isLongClick) {

                        Intent intent=new Intent(phone_shops.this,phone_items.class);
                        intent.putExtra("uid",model.getUid());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_shops_layout,parent,false);
                ProductViewHolder holder=new ProductViewHolder(view);
                return holder;
            }
        };
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
        view.setLayoutManager(layoutManager);
        adapter.startListening();


    }
}
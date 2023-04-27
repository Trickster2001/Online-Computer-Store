package com.example.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapterdeskclient extends FirebaseRecyclerAdapter<model,myadapterdeskclient.myviewholderdeskclient>
{
    private OnlistItemClick onlistItemClick;
    public myadapterdeskclient(@NonNull FirebaseRecyclerOptions<model> options, OnlistItemClick onlistItemClick)
    {
        super(options);
        this.onlistItemClick=onlistItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholderdeskclient holder, int position, @NonNull model model)
    {
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholderdeskclient onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowclient,parent,false);
        return new myviewholderdeskclient(view);
    }

    class myviewholderdeskclient extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;
        TextView name,price;

        public myviewholderdeskclient(@NonNull View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.img1);
            name=(TextView) itemView.findViewById(R.id.nametext);
            price=(TextView) itemView.findViewById(R.id.pricetext);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onlistItemClick.onItemClick();
        }
    }
    public interface OnlistItemClick{
        void onItemClick();
    }

}

package com.example.materialrecycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private  ModleSheet[] modleSheet;

    public MyAdapter(ModleSheet[] modleSheet) {
        this.modleSheet = modleSheet;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.recycle_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        final ModleSheet mData = modleSheet[position];
        holder.image.setImageResource(modleSheet[position].getImage());
        holder.titleText.setText(modleSheet[position].getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You are clicked : "+mData.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return modleSheet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleText;
        private ImageView image;
        private MaterialCardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img_view);
            titleText = itemView.findViewById(R.id.text_view);
            cardView = itemView.findViewById(R.id.layout);

        }
    }
}

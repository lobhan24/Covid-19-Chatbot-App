package com.example.covid_19_bvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter2 extends RecyclerView.Adapter<HorizontalAdapter2.HorizontalViewHolder>{
    private String[] items;

    public HorizontalAdapter2(String[] items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_precautions, parent, false);
        return new HorizontalViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.txt.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txtPrecaution);
        }
    }
}

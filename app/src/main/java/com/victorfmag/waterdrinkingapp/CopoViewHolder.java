package com.victorfmag.waterdrinkingapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CopoViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageViewCopo;
    public TextView textViewVolumeCopo;

    public CopoViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewCopo = itemView.findViewById(R.id.imageViewCopo);
        textViewVolumeCopo = itemView.findViewById(R.id.textViewVolumeCopo);
    }
}
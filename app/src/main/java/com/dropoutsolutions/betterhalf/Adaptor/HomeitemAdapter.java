package com.dropoutsolutions.betterhalf.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dropoutsolutions.betterhalf.R;
import com.makeramen.roundedimageview.RoundedImageView;


public class HomeitemAdapter extends RecyclerView.Adapter<HomeitemAdapter.ItemViewHolder>{
    private Context context ;
    private int [] images ;
    private String [] names ;

    public HomeitemAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public HomeitemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mainhomerecylerview, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeitemAdapter.ItemViewHolder holder, int position) {

        holder.roundedImageView.setImageResource(images[position]);
        holder.name.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return images.length ;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView roundedImageView ;
        TextView name ;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
        }
    }
}

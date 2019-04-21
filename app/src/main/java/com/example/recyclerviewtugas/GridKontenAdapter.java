package com.example.recyclerviewtugas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridKontenAdapter extends RecyclerView.Adapter<GridKontenAdapter.GridViewHolder> {
    public GridKontenAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Konten> getListKonten() {
        return listKonten;
    }

    public void setListKonten(ArrayList<Konten> listKonten) {
        this.listKonten = listKonten;
    }

    private ArrayList<Konten> listKonten;


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_konten, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Glide.with(context)
                .load(getListKonten().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("name",getListKonten().get(position).getName());
                intent.putExtra("remarks",getListKonten().get(position).getRemarks());
                intent.putExtra("foto",getListKonten().get(position).getPhoto());
                intent.putExtra("desk",getListKonten().get(position).getDeskripsi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListKonten().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

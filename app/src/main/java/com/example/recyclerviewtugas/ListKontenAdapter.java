package com.example.recyclerviewtugas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListKontenAdapter extends RecyclerView.Adapter<ListKontenAdapter.CategoryViewHolder> {
    public ListKontenAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_konten, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tvName.setText(getListKonten().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListKonten().get(position).getRemarks());

        Glide.with(context)
                .load(getListKonten().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
        categoryViewHolder.rl.setOnClickListener(new View.OnClickListener() {
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout rl;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            rl = itemView.findViewById(R.id.listLayout);
        }
    }
}

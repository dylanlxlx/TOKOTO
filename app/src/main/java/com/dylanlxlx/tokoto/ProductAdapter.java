package com.dylanlxlx.tokoto;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


    private final List<ProductItem> pItemList;
    public boolean isLike = false;

    public ProductAdapter(List<ProductItem> pItemList) {
        this.pItemList = pItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem item = pItemList.get(position);
        holder.pImg.setImageResource(item.getProductImgId());
        holder.pName.setText(item.getProductName());
        holder.pPrice.setText(item.getProductPrice());

        holder.pLike.setImageResource(R.drawable.heart_icon_grey);
        holder.pLike.setBackgroundResource(R.drawable.round_heart_grey);

        holder.pLike.setOnClickListener(v -> {
            if (!isLike) {
                holder.pLike.setImageResource(R.drawable.heart_icon_red);
                holder.pLike.setBackgroundResource(R.drawable.round_heart_red);
                isLike = true;
            } else {
                holder.pLike.setImageResource(R.drawable.heart_icon_grey);
                holder.pLike.setBackgroundResource(R.drawable.round_heart_grey);
                isLike = false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return pItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View iView;
        ImageView pImg;
        TextView pName;
        TextView pPrice;
        ImageButton pLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iView = itemView;
            pImg = itemView.findViewById(R.id.product_img);
            pName = itemView.findViewById(R.id.product_name);
            pPrice = itemView.findViewById(R.id.product_price);
            pLike = itemView.findViewById(R.id.like);
        }
    }
}

package com.dylanlxlx.tokoto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Fragment {

    private final List<ProductItem> productItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        initProductItem();
        RecyclerView pRv = view.findViewById(R.id.rv_product);
        pRv.setLayoutManager(layoutManager);
        ProductAdapter pAdapter = new ProductAdapter(productItems);
        pRv.setAdapter(pAdapter);

        return view;
    }


    private void initProductItem() {
        int[] pImgId = {
                R.drawable.image_popular_product_1,
                R.drawable.image_popular_product_2,
                R.drawable.glap,
                R.drawable.wireless_headset
        };
        String[] pName = {
                "Wireless Controller for PS4™",
                "Nike Sport White - Man Pant",
                "Gloves XC Omega - Polygon",
                "Logitech Head - For game"
        };
        String[] pPrice = {"＄64.99", "＄50.5", "＄36.55", "＄20.2"};

        for (int i = 0; i < 4; i++) {
            ProductItem item = new ProductItem(pImgId[i], pName[i], pPrice[i], R.id.like);
            productItems.add(item);
        }

    }

}
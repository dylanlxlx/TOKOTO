package com.dylanlxlx.tokoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class NavigationFragment extends Fragment implements View.OnClickListener {

    private ImageButton btn_shop, btn_my;
    private Fragment page_shop, page_my;
    private FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        btn_shop = view.findViewById(R.id.shop);
        btn_my = view.findViewById(R.id.my);
        btn_shop.setOnClickListener(this);
        btn_my.setOnClickListener(this);
        fragmentManager = getFragmentManager();
    }

    @Override
    public void onClick(View v) {
        setBtnSelection(v.getId());
    }

    private void setBtnSelection(int id) {
        btn_shop.setImageResource(R.drawable.shop_grey);
        btn_my.setImageResource(R.drawable.user_grey);

        FragmentTransaction transaction = fragmentManager.beginTransaction();


        if (page_shop != null) transaction.hide(page_shop);
        if (page_my != null) transaction.hide(page_my);

        if (id == R.id.shop) {
            btn_shop.setImageResource(R.drawable.shop_color);
            if (page_shop == null) {
                page_shop = new Shop();
                transaction.add(R.id.content, page_shop);
            } else {
                transaction.show(page_shop);
            }
        } else if (id == R.id.my) {
            btn_my.setImageResource(R.drawable.user_color);
            if (page_my == null) {
                page_my = new My();
                transaction.add(R.id.content, page_my);
            } else {
                transaction.show(page_my);
            }
        }
        transaction.commit();
    }
}
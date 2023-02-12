package com.dylanlxlx.tokoto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class My extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        initContent(v);
        return v;
    }

    @SuppressLint("SetTextI18n")
    private void initContent(View view) {
        SharedPreferences pref = getActivity().getSharedPreferences("users", Context.MODE_PRIVATE);
        Button btn_logout = view.findViewById(R.id.log_out);
        btn_logout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SigninActivity.class);
            startActivity(intent);
        });
        TextView hello_name = view.findViewById(R.id.hello_name);
        hello_name.setText("Hello, " + pref.getString("name", "") + "!");
    }
}
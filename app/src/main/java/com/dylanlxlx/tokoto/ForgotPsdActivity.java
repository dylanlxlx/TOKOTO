package com.dylanlxlx.tokoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForgotPsdActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private EditText emailEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_psd);

        initBtn();

    }

    private void initBtn() {
        ImageButton btn_return = findViewById(R.id.forgot_psd_return);
        Button btn_continue = findViewById(R.id.forgot_psd_continue);
        Button btn_toSignup = findViewById(R.id.f_to_sign_up);

        btn_return.setOnClickListener(this);
        btn_toSignup.setOnClickListener(this);
        btn_continue.setOnClickListener(v -> {
            pref = getSharedPreferences("users", Context.MODE_PRIVATE);
            editor = pref.edit();
            emailEdit = findViewById(R.id.f_email_text);
            String email = emailEdit.getText().toString();
            if (!email.equals(pref.getString("account", ""))) {
                Intent intent = new Intent(ForgotPsdActivity.this, SignupActivity.class);
                startActivity(intent);
            } else {
                editor.putString("password", "123456");
                editor.apply();
                Intent intent = new Intent(ForgotPsdActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.forgot_psd_return) {
            Intent intent = new Intent(ForgotPsdActivity.this, SigninActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.f_to_sign_up) {
            Intent intent = new Intent(ForgotPsdActivity.this, SignupActivity.class);
            startActivity(intent);
        }
    }
}
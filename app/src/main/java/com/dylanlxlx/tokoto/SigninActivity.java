package com.dylanlxlx.tokoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private EditText emailEdit;
    private EditText passwordEdit;
    private CheckBox rememberPsd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        pref = getSharedPreferences("users", Context.MODE_PRIVATE);
        rememberPsd = findViewById(R.id.remember_me);
        emailEdit = findViewById(R.id.email_text);
        passwordEdit = findViewById(R.id.password_text);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            emailEdit.setText(account);
            passwordEdit.setText(password);
        }
        initBtn();

    }

    private void initBtn() {
        ImageButton btn_return = findViewById(R.id.sign_return);
        Button btn_forget = findViewById(R.id.forget_psd);
        Button btn_continue = findViewById(R.id.signin_continue);
        Button btn_toSignup = findViewById(R.id.to_sign_up);

        btn_return.setOnClickListener(this);
        btn_forget.setOnClickListener(this);
        btn_toSignup.setOnClickListener(this);
        btn_continue.setOnClickListener(this::signin);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_return) {
            Intent intent = new Intent(SigninActivity.this, SplashActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.forget_psd) {
            Intent intent = new Intent(SigninActivity.this, ForgotPsdActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.to_sign_up) {
            Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
            startActivity(intent);
        }
    }

    public void signin(View view) {

        String account = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        if ("".equals(account)) {
            //email为空
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password)) {
            //password为空
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (account.equals(pref.getString("account", "")) &&
                password.equals(pref.getString("password", ""))) {

            SharedPreferences.Editor editor = pref.edit();
            if (rememberPsd.isChecked()) {
                editor.putBoolean("remember_password", true);
                editor.putString("account", account);
                editor.putString("password", password);
            } else {
                editor.putBoolean("remember_password", false);
            }
            editor.apply();
            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            //不匹配
            Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show();
        }

    }
}
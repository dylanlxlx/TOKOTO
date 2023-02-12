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

public class SignupActivity extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        pref = getSharedPreferences("users", Context.MODE_PRIVATE);
        initBtn();
    }

    private void initBtn() {
        Button btn_continue = findViewById(R.id.signup_continue);
        ImageButton btn_return = findViewById(R.id.signup_return);

        btn_continue.setOnClickListener(this::register);

        btn_return.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
            startActivity(intent);
        });

    }

    public void register(View view) {
        EditText emailEdit = findViewById(R.id.register_email_text);
        EditText passwordEdit = findViewById(R.id.register_password_text);
        EditText re_passwordEdit = findViewById(R.id.register_re_password_text);
        EditText nameEdit = findViewById(R.id.register_name);
        EditText phoneEdit = findViewById(R.id.register_phone);

        String account = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        String re_password = re_passwordEdit.getText().toString();
        String name = nameEdit.getText().toString();
        String phone = phoneEdit.getText().toString();


        if ("".equals(account)) {
            //email为空
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password)) {
            //密码为空
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(re_password)) {
            //密码不一致
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(name)) {
            //名字为空
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(phone)) {
            //电话号码为空
            Toast.makeText(this, "Please enter your phone", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("account", account);
        editor.putString("password", password);
        editor.putString("name", name);
        editor.apply();

        Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
        startActivity(intent);
    }

}
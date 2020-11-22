package com.bstu.fit.yarmolik.cinema;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.bstu.fit.yarmolik.cinema.Model.UserData;
import com.bstu.fit.yarmolik.cinema.Remote.IMyApi;
import com.bstu.fit.yarmolik.cinema.Remote.RetrofitClient;
import com.google.android.material.textfield.TextInputLayout;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;

import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class Registration extends AppCompatActivity {
    private EditText password, email, login;
    private boolean checkLogin,checkEmail,checkPassword;
    public static String response="";
    private IMyApi iMyApi;
    private Button register;
    private CompositeDisposable compositeDisposable;
    private Intent intent;
    private String loginValue, emailValue, passwordValue;
    private AlertDialog alertDialog;
    private Switch showPasswordSwitch;
    private  UserData user;
    private Executor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registration);
        init();
        //check
        showPasswordSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                    password.setTransformationMethod(new PasswordTransformationMethod());
                else
                    password.setTransformationMethod(null);
                password.setSelection(password.length());
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginValue = login.getText().toString();
                emailValue = email.getText().toString();
                passwordValue = password.getText().toString();
                checkLogin = loginValue.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
                checkEmail = emailValue.matches("^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
                checkPassword = passwordValue.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$");
                if (checkPassword && checkEmail && checkLogin) {
                    alertDialog = new SpotsDialog.Builder().setContext(Registration.this).build();
                    alertDialog.show();
                    try {
                        user = new UserData(loginValue, emailValue, md5(passwordValue), 1);
                        compositeDisposable.add(iMyApi.registerUser(user)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(s -> {
                                if(s.equals("User exists")){
                                    alertDialog.dismiss();
                                    Toast.makeText(Registration.this, "Пользователь уже существует", Toast.LENGTH_SHORT).show();
                                }
                                else if(s.equals("Email exists")){
                                    alertDialog.dismiss();
                                    Toast.makeText(Registration.this, "Пользователь с таким email уже существует", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    alertDialog.dismiss();
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                }
                            }, throwable -> {
                                alertDialog.dismiss();
                                Toast.makeText(Registration.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            })
                    );
                    }
                    catch (Exception ex){
                        Toast.makeText(Registration.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registration.this, "Некорректные данные", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void init() {
        login = findViewById(R.id.editTextLoginRegistrationActivity);

        email = findViewById(R.id.editTextEmailRegistrationActivity);
        password = findViewById(R.id.editTextPasswordRegistrationActivity);
        register = findViewById(R.id.registerButton);
        showPasswordSwitch=findViewById(R.id.switchShowPasswordRegistrationActivity);
        compositeDisposable = new CompositeDisposable();
        iMyApi = RetrofitClient.getInstance().create(IMyApi.class);
        intent = new Intent(Registration.this, Login.class);
        executor = ContextCompat.getMainExecutor(this);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

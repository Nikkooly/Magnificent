package com.bstu.fit.yarmolik.cinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.bstu.fit.yarmolik.cinema.LocalDataBase.DbHelper;
import com.bstu.fit.yarmolik.cinema.Model.UserData;
import com.bstu.fit.yarmolik.cinema.Remote.IMyApi;
import com.bstu.fit.yarmolik.cinema.Remote.RetrofitClient;
import com.bstu.fit.yarmolik.cinema.SOAP.CallSoap;
import com.google.android.material.textfield.TextInputLayout;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;

import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    private EditText password, email, login;
    private boolean checkLogin,checkEmail,checkPassword;
    public static String response="";
    private IMyApi iMyApi;
    private Button register;
    private CompositeDisposable compositeDisposable;
    private DbHelper dbHelper;
    private Intent intent;
    private String loginValue, emailValue, passwordValue;
    private AlertDialog alertDialog;
    private Switch showPasswordSwitch;
    private  UserData user;
    private Executor executor;
   // private CheckBox fingerCheck;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

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
                if (checkPassword == true && checkEmail == true && checkLogin == true) {
                    alertDialog = new SpotsDialog.Builder().setContext(Registration.this).build();
                    alertDialog.show();
                    try {
                        user = new UserData(login.getText().toString(), email.getText().toString(), md5(password.getText().toString()), 1);
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
                                    dbHelper.insertUserData(s,login.getText().toString(),email.getText().toString(),md5(password.getText().toString()));
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
    /*public void onCheckboxClicked(View view) {

        if(fingerCheck.isChecked()){
            promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Magnificent Touch")
                    .setDescription("Коснитесь сканера отпечатка пальца и дождитесь потверждения")
                    .setNegativeButtonText("Exit")
                    .build();
            biometricPrompt.authenticate(promptInfo);
        }
    }*/
    public void init() {
        login = findViewById(R.id.editTextLoginRegistrationActivity);
        email = findViewById(R.id.editTextEmailRegistrationActivity);
        password = findViewById(R.id.editTextPasswordRegistrationActivity);
        register = findViewById(R.id.registerButton);
        showPasswordSwitch=findViewById(R.id.switchShowPasswordRegistrationActivity);
        //fingerCheck = findViewById(R.id.checkBox2);
        compositeDisposable = new CompositeDisposable();
        dbHelper = new DbHelper(this, "project.db", null, 1);
        dbHelper.getWritableDatabase();
        iMyApi = RetrofitClient.getInstance().create(IMyApi.class);
        intent = new Intent(Registration.this, Login.class);
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(Registration.this,errString,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(Registration.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(Registration.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
        if(CheckFingerPrintCompatibility.checkFingerprintCompatibility(this)){

        }
        else{

        }
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
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

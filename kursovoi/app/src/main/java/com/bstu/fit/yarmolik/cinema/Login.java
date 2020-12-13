package com.bstu.fit.yarmolik.cinema;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.bstu.fit.yarmolik.cinema.Fragments.MainActivity;
import com.bstu.fit.yarmolik.cinema.Manager.ManagerActivity;
import com.bstu.fit.yarmolik.cinema.Model.LoginUser;
import com.bstu.fit.yarmolik.cinema.Remote.IMyApi;
import com.bstu.fit.yarmolik.cinema.Remote.RetrofitClient;
import com.bstu.fit.yarmolik.cinema.Responces.GuestResponse;
import com.bstu.fit.yarmolik.cinema.Responces.UserResponce;

import java.util.List;
import java.util.Objects;

import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Login extends AppCompatActivity {

    private ImageView bookIconImageView;
    private TextView bookITextView,noAccount;
    private EditText login,password;
    private Button btn_login;
    public boolean stateInternet;
    private ConstraintLayout rootView, afterAnimationView;
    private IMyApi iMyApi;
    private SharedPreferences sharedPreferences;
    public static Integer userRoleId,guestRoleId;
    private CheckBox checkBox;
    private String checkBoxChoose="";
    private Cursor c;
    public static String userId="",guestId,userEmail="",guestEmail,userLogin="",guestLogin;
    private Intent intent;
    private CompositeDisposable compositeDisposable;
    private  final String APP_PREFERENCES = "user";
    private final String APP_PREFERENCES_LOGIN="login";
    private final String APP_PREFERENCES_PASSWORD="password";
    private Switch showPasswordSwitch;
    private String loginValue,passwordValue;
    private CheckInternetConnection checkInternetConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable=new CompositeDisposable();
        iMyApi= RetrofitClient.getInstance().create(IMyApi.class);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        init();
        checkInternetConnection.installListener(Login.this);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(Login.this, Registration.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
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


        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                bookITextView.setVisibility(VISIBLE);
                rootView.setBackgroundColor(ContextCompat.getColor(Login.this, R.color.colorBackground));
                bookIconImageView.setImageResource(R.drawable.app_icon);
            }

            @Override
            public void onFinish() {
                bookITextView.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(Login.this, R.color.btnColor));
                startAnimation();

                    if(sharedPreferences.contains(APP_PREFERENCES_LOGIN)) {
                        loadWithSharedPreferences(sharedPreferences.getString(APP_PREFERENCES_LOGIN,""),sharedPreferences.getString(APP_PREFERENCES_PASSWORD,""));
                    }
            }
        }.start();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    loginValue = login.getText().toString();
                    passwordValue = password.getText().toString();
                    boolean checkLogin = loginValue.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
                    boolean checkPassword = passwordValue.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$");
                    if (checkPassword && checkLogin) {

                        AlertDialog alertDialog = new SpotsDialog.Builder()
                                .setContext(Login.this)
                                .build();
                        alertDialog.show();
                        LoginUser user = new LoginUser(Encryption.encryptString(loginValue), Encryption.encryptString(passwordValue));
                        Call<List<UserResponce>> call = iMyApi.checkLogin(user);
                        call.enqueue(new Callback<List<UserResponce>>() {
                            @Override
                            public void onResponse(Call<List<UserResponce>> call, Response<List<UserResponce>> response) {
                                for (UserResponce userResponce : response.body()) {
                                    userId = userResponce.getId();
                                    userRoleId = userResponce.getRoleId();
                                    userEmail = userResponce.getEmail();
                                    userLogin = userResponce.getLogin();
                                    if (userRoleId == 1) {
                                        alertDialog.dismiss();
                                        intent = new Intent(Login.this, MainActivity.class);
                                        intent.putExtra("stateInternetConnection", stateInternet);
                                        if (checkBox.isChecked())
                                            checkBoxChoose = "OK";
                                        else
                                            checkBoxChoose = "No";
                                        if (checkBoxChoose.equals("OK")) {
                                            try {
                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                editor.putString(APP_PREFERENCES_LOGIN, Encryption.encryptString(loginValue));
                                                editor.putString(APP_PREFERENCES_PASSWORD, Encryption.encryptString(passwordValue));
                                                editor.apply();
                                            }
                                            catch(Exception ex){
                                                Log.d("Exception: ", Objects.requireNonNull(ex.getMessage()));
                                            }
                                        }
                                        startActivity(intent);
                                        clear();
                                    } else if (userRoleId == 2) {
                                        alertDialog.dismiss();
                                        intent = new Intent(Login.this, ManagerActivity.class);
                                        startActivity(intent);
                                        clear();
                                    } else if (userRoleId == 4 || userRoleId == null) {
                                        alertDialog.dismiss();
                                        Toast.makeText(Login.this, "Неверный логин или пароль. Проверьте введенные данные!", Toast.LENGTH_SHORT).show();
                                        userRoleId = 0;
                                    }
                                }

                            }

                            @Override
                            public void onFailure(Call<List<UserResponce>> call, Throwable t) {
                                alertDialog.dismiss();
                                Toast.makeText(Login.this, "Некорректные данные", Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        Toast.makeText(Login.this, "Некорректные данные", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception ex){
                    Log.d("Exception: ", Objects.requireNonNull(ex.getMessage()));
                }
            }
        });
    }
    public void Skip(View view){
            userRoleId = 3;
            getGuestInfo(3);
            intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            clear();
    }
    private void init() {
        bookIconImageView = findViewById(R.id.bookIconImageView);
        bookITextView = findViewById(R.id.bookITextView);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
        noAccount = findViewById(R.id.noAccountTextViewLoginActivity);
        login=findViewById(R.id.loginEditText);
        password=findViewById(R.id.passwordEditText);
        btn_login=findViewById(R.id.loginButton);
        checkInternetConnection=new CheckInternetConnection();
        checkBox=findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        showPasswordSwitch=findViewById(R.id.switchShowPasswordLoginActivity);
    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    public void getGuestInfo(Integer id){
        try {
            Call<List<GuestResponse>> call = iMyApi.getGuestInfo(id);
            call.enqueue(new Callback<List<GuestResponse>>() {
                @Override
                public void onResponse(Call<List<GuestResponse>> call, Response<List<GuestResponse>> response) {
                    for (GuestResponse guestResponse : response.body()) {
                        userId = guestResponse.getId();
                        userLogin = guestResponse.getLogin();
                        userEmail = guestResponse.getEmail();
                    }
                }

                @Override
                public void onFailure(Call<List<GuestResponse>> call, Throwable t) {

                }
            });
        }
        catch(Exception ex){
            Log.d("Exception: ", Objects.requireNonNull(ex.getMessage()));
        }
    }
    private void clear(){
        login.setText(null);
        password.setText(null);
    }
    private void loadWithSharedPreferences(String login,String password){
        LoginUser user = new LoginUser(login, password);
        Call<List<UserResponce>> call = iMyApi.checkLogin(user);
        call.enqueue(new Callback<List<UserResponce>>() {
            @Override
            public void onResponse(Call<List<UserResponce>> call, Response<List<UserResponce>> response) {
                for (UserResponce userResponce : response.body()) {
                    userId = userResponce.getId();
                    userRoleId = userResponce.getRoleId();
                    userEmail = userResponce.getEmail();
                    userLogin = userResponce.getLogin();
                        intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        clear();
                }
            }
            @Override
            public void onFailure(Call<List<UserResponce>> call, Throwable t) {
                Toast.makeText(Login.this, "Некорректные данные", Toast.LENGTH_LONG).show();
            }
        });
    }
    
}

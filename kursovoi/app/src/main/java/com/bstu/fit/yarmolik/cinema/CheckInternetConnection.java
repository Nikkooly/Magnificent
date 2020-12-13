package com.bstu.fit.yarmolik.cinema;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telecom.CallScreeningService;
import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import dmax.dialog.SpotsDialog;

public class CheckInternetConnection extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;
    private AlertDialog alertDialog;
    public static boolean networkState = true;

    public void installListener(Context context) {

        if (broadcastReceiver == null) {
            broadcastReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {

                    Bundle extras = intent.getExtras();

                    NetworkInfo info = (NetworkInfo) extras
                            .getParcelable("networkInfo");

                    NetworkInfo.State state = info.getState();
                    Log.d("InternalBroadcastReceiver", info.toString() + " "
                            + state.toString());

                    if (state == NetworkInfo.State.CONNECTED) {
                        onNetworkUp(context);
                    } else {
                        onNetworkDown(context);
                    }

                }
            };

            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
    private void onNetworkDown(Context context){
         alertDialog = new SpotsDialog.Builder()
                .setContext(context)
                .setTheme(R.style.CustomInternetDialog)
                .build();
        alertDialog.show();
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Интернет-подключение отсутствует");
        builder.setMessage("Работа приложения будет приостановлена. Пожалуйста включите интернет-соеденение и войдите в приложение заново");
        builder.setCancelable(true);
        builder.create();
        builder.show();*/
    }
    private void onNetworkUp(Context context){
        if(alertDialog!=null){
            alertDialog.cancel();
            networkState = true;
        }

    }

}

package com.bstu.fit.yarmolik.cinema.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bstu.fit.yarmolik.cinema.Login;
import com.bstu.fit.yarmolik.cinema.R;

import java.io.File;
import java.util.Objects;


public class FragmentMore extends Fragment {
private Button buttonClose;
private TextView outTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_more, container, false);
        buttonClose=view.findViewById(R.id.button5);
        outTextView = view.findViewById(R.id.textView51);
        outTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });

        if(Login.userRoleId!=3) {
            buttonClose.setVisibility(View.VISIBLE);
            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finishApplicationWithCleanSharedPreferencesFile();
                }
            });
        }
        return view;
    }
    private void finishApplicationWithCleanSharedPreferencesFile(){
        File file= new File("/data/data/com.bstu.fit.yarmolik.cinema/shared_prefs/user.xml");
        file.delete();
        finishActivity();
        //Intent homeIntent = new Intent(getContext(), Login.class);
       // homeIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
       // homeIntent.addCategory( Intent.CATEGORY_HOME );
        //homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(homeIntent);
        //getActivity().getSupportFragmentManager().popBackStack();
        //Objects.requireNonNull(getActivity()).finish();
        //System.exit(0);
    }
    private void finishActivity() {

        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        System.exit(0);
    }
}

package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.RunnymedeRobotics.myapplication.R;


public class SettingsFragment extends BasicFragment {

    private int layout;

    Button storeDataBtn;

    TextView ipTextView;
    TextView compeTextView;

    String ipAddress = "";
    String competetion = "";

    public SettingsFragment(){}


    @SuppressLint("ValidFragment")
    public SettingsFragment(int layout){
        this.layout = layout;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        storeDataBtn = (Button) getView().findViewById(R.id.save_settings);
        ipTextView = (TextView) getView().findViewById(R.id.ip_address_text_edit);
        compeTextView = (TextView) getView().findViewById(R.id.comp_text_view);


        SharedPreferences pref = getContext().getSharedPreferences("settings",0);
        final SharedPreferences.Editor editor = pref.edit();

        //Gets the stored strings and sets it to the local variables
        ipAddress = pref.getString("ip",null);
        competetion = pref.getString("competition",null);

        //Sets the stored prefrences to the text view
        ipTextView.setText(ipAddress);
        compeTextView.setText(competetion);


        storeDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Updates settings
                competetion = compeTextView.getText().toString();
                ipAddress = ipTextView.getText().toString();
                editor.putString("competition",competetion);
                editor.putString("ip",ipAddress);
                editor.commit();
            }
        });
        return inflater.inflate(this.layout, container, false);
    }
}

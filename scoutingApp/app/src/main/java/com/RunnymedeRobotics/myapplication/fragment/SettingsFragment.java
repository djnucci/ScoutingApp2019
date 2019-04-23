package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;


public class SettingsFragment extends BasicFragment {

    private int layout;

    Button storeDataBtn;

    EditText ipEditText;
    EditText compEditText;
    EditText botPlacementEditText;

    public static String ipAddress = "";
    public static String competition = "";


    public SettingsFragment(){}


    @SuppressLint("ValidFragment")
    public SettingsFragment(int layout){
        this.layout = layout;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(this.layout, container, false);
        storeDataBtn = (Button) view.findViewById(R.id.save_settings);
        ipEditText = (EditText) view.findViewById(R.id.ip_address_text_edit);
        compEditText = (EditText) view.findViewById(R.id.regional_text_edit);
        botPlacementEditText = (EditText) view.findViewById(R.id.bot_placement);

        SharedPreferences pref = getContext().getSharedPreferences("settings",0);
        final SharedPreferences.Editor editor = pref.edit();


        //Gets the stored strings and sets it to the local variables
        ipAddress = pref.getString("ip","");
        competition = pref.getString("competition","");

        //Sets the stored prefrences to the text view
        ipEditText.setText(ipAddress);
        compEditText.setText(competition);


        storeDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Updates settings
                competition = compEditText.getText().toString();
                ipAddress = ipEditText.getText().toString();
                editor.putString("competition", competition);
                editor.putString("ip",ipAddress);
                editor.commit();
            }
        });


        if(MainActivity.matchLists.isMatchlistPresent()){
        }
        return view;
    }

    public static void updateSettings(Context context){

        SharedPreferences pref = context.getSharedPreferences("settings",0);
        final SharedPreferences.Editor editor = pref.edit();
        ipAddress = pref.getString("ip",null);
        competition = pref.getString("competition",null);
    }

    public static void checkSettings(Context context) {
        SharedPreferences pref = context.getSharedPreferences("settings", 0);
        final SharedPreferences.Editor editor = pref.edit();
        //Gets the stored strings and sets it to the local variables
        ipAddress = pref.getString("ip", null);
        competition = pref.getString("competition", null);
        if (competition == null) {
            MainActivity.makeToast("Please add competition in settings", context);
        }
    }

}

package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Auto;

public class SetupFragment extends BasicFragment {
    RadioButton levelOneBtn;
    RadioButton levelTwoRightBtn;
    RadioButton levelTwoLeftBtn;
    RadioButton hatchPreload;
    RadioButton cargoPreload;
    RadioButton noPrelaod;
    Button matchPlayTab;
    Button endGameTab;
    private int layout;
    ImageView habPlatforms;

    public SetupFragment() {
    }

    @SuppressLint("ValidFragment")
    public SetupFragment(int layout) {
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(this.layout, container, false);
       // final Auto auto= new Auto();

        levelOneBtn = (RadioButton) view.findViewById(R.id.setup_level_one);
        levelTwoLeftBtn = (RadioButton) view.findViewById(R.id.setup_level_two_left);
        levelTwoRightBtn = (RadioButton) view.findViewById(R.id.setup_level_two_left);

        hatchPreload = (RadioButton) view.findViewById(R.id.setup_hatch_radioButton);
        cargoPreload = (RadioButton) view.findViewById((R.id.setup_cargo_radioButton));
        noPrelaod = (RadioButton) view.findViewById(R.id.setup_nothing_radioButton);

        matchPlayTab = (Button) view.findViewById(R.id.scouting_setup_match);
        endGameTab = (Button) view.findViewById(R.id.scouting_setup_endgame);

        habPlatforms = (ImageView) view.findViewById(R.id.setup_platform_image);

        habPlatforms.setVisibility(View.VISIBLE);
/*
        matchPlayTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auto auto = new Auto();
                if (cargoPreload.isChecked()) {
                    auto.setStartingObj('C');
                    auto.setAutoPreload('1');
                    System.out.print("ABC");
                } else if (hatchPreload.isChecked()) {
                    auto.setStartingObj('H');
                    auto.setAutoPreload('1');
                } else if (noPrelaod.isChecked()) {
                    auto.setStartingObj('N');
                    auto.setAutoPreload('0');
                }
                else{
                    auto.setStartingObj('N');
                    auto.setAutoPreload('0');
                }

                if (levelOneBtn.isChecked()) {
                    auto.setAutoLvl(1);
                }
                if (levelTwoLeftBtn.isChecked() || levelTwoRightBtn.isChecked()) {
                    auto.setAutoLvl(2);
                }
                Log.e("Preload" , auto.getAutoPreload()+"");
                Log.e("StartingObj", auto.getStartingObj()+"");
                MainActivity.globalSubmitMatch.setAuto(auto);
                Log.e("TEST", MainActivity.globalSubmitMatch.getAuto().getAutoPreload()+"");

            }
        });
        */

/*
        cargoPreload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auto.setStartingObj('C');
                auto.setAutoPreload('1');
                MainActivity.globalSubmitMatch.setAuto(auto);
            }
        });
        */
        return view;
    }

    public void onDestroy(){
        //Storing data in Auto object
        Auto auto = new Auto();
        if (cargoPreload.isChecked()) {
            auto.setStartingObj('C');
            auto.setAutoPreload('1');
            MainActivity.keepFromSetup[1] = 'C';
            System.out.print("ABC");
        } else if (hatchPreload.isChecked()) {
            auto.setStartingObj('H');
            auto.setAutoPreload('1');
            MainActivity.keepFromSetup[1] = 'H';
        } else if (noPrelaod.isChecked()) {
            auto.setStartingObj('N');
            auto.setAutoPreload('0');
            MainActivity.keepFromSetup[1] = 'N';
        }
        else{
            auto.setStartingObj('N');
            auto.setAutoPreload('0');
            MainActivity.keepFromSetup[1] = 'N';
        }

        if (levelOneBtn.isChecked()) {
            auto.setAutoLvl(1);
            MainActivity.keepFromSetup[0] = '1';
        }
        if (levelTwoLeftBtn.isChecked() || levelTwoRightBtn.isChecked()) {
            auto.setAutoLvl(2);
            MainActivity.keepFromSetup[0] = '2';
        }
        MainActivity.globalSubmitMatch.setAuto(auto);
        Log.e("TEST", MainActivity.globalSubmitMatch.getAuto().getAutoPreload()+"");


        //storing data for tab history for the match






        super.onDestroy();
    }

}

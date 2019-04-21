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
import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.Match;

import java.util.ArrayList;
import java.util.Arrays;

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
    boolean lvlChecked = false;
    boolean preloadChecked= false;


    ArrayList<RadioButton> setupLevelList= new ArrayList<RadioButton>(Arrays.asList(levelOneBtn,levelTwoLeftBtn,levelTwoRightBtn));

    ArrayList<RadioButton> setupPreloadList = new ArrayList<RadioButton>(Arrays.asList(hatchPreload,cargoPreload,noPrelaod));
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
        lvlChecked = false;
        preloadChecked= false;

        levelOneBtn = (RadioButton) view.findViewById(R.id.setup_level_one);
        levelTwoLeftBtn = (RadioButton) view.findViewById(R.id.setup_level_two_left);
        levelTwoRightBtn = (RadioButton) view.findViewById(R.id.setup_level_two_right);

        hatchPreload = (RadioButton) view.findViewById(R.id.setup_hatch_radioButton);
        cargoPreload = (RadioButton) view.findViewById((R.id.setup_cargo_radioButton));
        noPrelaod = (RadioButton) view.findViewById(R.id.setup_nothing_radioButton);

        matchPlayTab = (Button) view.findViewById(R.id.scouting_setup_match);
        endGameTab = (Button) view.findViewById(R.id.scouting_setup_endgame);

        habPlatforms = (ImageView) view.findViewById(R.id.setup_platform_image);

        setupPreloadList = new ArrayList<RadioButton>(Arrays.asList(hatchPreload,cargoPreload,noPrelaod));
        setupLevelList= new ArrayList<RadioButton>(Arrays.asList(levelOneBtn,levelTwoLeftBtn,levelTwoRightBtn));

        habPlatforms.setVisibility(View.VISIBLE);


        if (MainActivity.globalSubmitMatch.getAuto().getStartingObj() == 'C' ){
            cargoPreload.setChecked(true);
        }
        else if(MainActivity.globalSubmitMatch.getAuto().getStartingObj() == 'H'){
            hatchPreload.setChecked(true);
        }
        else if(MainActivity.globalSubmitMatch.getAuto().getStartingObj() == 'N'){
            noPrelaod.setChecked(true);
        }

        if(MainActivity.globalSubmitMatch.getAuto().getAutoLvl() == 1){
            levelOneBtn.setChecked(true);
        }
        else if(MainActivity.globalSubmitMatch.getAuto().getAutoLvl() == 2)
        {
            levelTwoLeftBtn.setChecked(true);
        }

if(!lvlChecked) {
    for (int i = 0; i < setupLevelList.size(); i++) {
        getIsLevelAndPreloadChecked();
        final int copyOfi = i;
        setupLevelList.get(i).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (setupLevelList.get(copyOfi).isChecked()) {
                    //Log.e("LVL BTN PRESSEDL", setupLevelList.get(copyOfi).getTag().toString());
                    lvlChecked = true;
                    getIsLevelAndPreloadChecked();

                }


            }
        });
        if(lvlChecked){
            break;
        }
    }
}
        if(!preloadChecked) {
            for (int i = 0; i < setupPreloadList.size(); i++) {
                getIsLevelAndPreloadChecked();

                final int copyOfi = i;
                setupPreloadList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (setupPreloadList.get(copyOfi).isChecked()) {
                            preloadChecked = true;
                            getIsLevelAndPreloadChecked();

                        }


                    }
                });
                if(preloadChecked){
                    break;
                }
            }
        }
        return view;
    }
    public boolean getIsLevelAndPreloadChecked(){
        if(this.lvlChecked &&  this.preloadChecked){
            MainActivity.hasPreloadAndSetupLvlSelected = true;
            return true;
        }
        return false;
    }

    public void onDestroy(){
        //Storing data in Auto object
        Auto auto = new Auto();
        if (cargoPreload.isChecked()) {
            auto.setStartingObj('C');
            auto.setAutoPreload('1');
            //MainActivity.keepFromSetup[1] = 'C';
            System.out.print("ABC");
        } else if (hatchPreload.isChecked()) {
            auto.setStartingObj('H');
            auto.setAutoPreload('1');
           // MainActivity.keepFromSetup[1] = 'H';
        } else if (noPrelaod.isChecked()) {
            auto.setStartingObj('N');
            auto.setAutoPreload('0');
           // MainActivity.keepFromSetup[1] = 'N';FV
        }
        else{
            auto.setStartingObj('N');
            auto.setAutoPreload('0');
            //MainActivity.keepFromSetup[1] = 'N';
        }

        if (levelOneBtn.isChecked()) {
            auto.setAutoLvl(1);
           // MainActivity.keepFromSetup[0] = '1';
        }
        if (levelTwoLeftBtn.isChecked() || levelTwoRightBtn.isChecked()) {
            auto.setAutoLvl(2);
            //MainActivity.keepFromSetup[0] = '2';
        }
        MainActivity.globalSubmitMatch.setAuto(auto);
        Log.e("TEST", MainActivity.globalSubmitMatch.getAuto().getAutoPreload()+"");

        Log.e("AUTO PRELOAD", MainActivity.globalSubmitMatch.getAuto().getStartingObj() +"");
        Log.e("AUTO LEVEL", MainActivity.globalSubmitMatch.getAuto().getAutoLvl() +"");
        Log.e("AUTO PRELOAD", MainActivity.globalSubmitMatch.getAuto().getAutoPreload() +"");
        //storing data for tab history for the match






        super.onDestroy();
    }

}

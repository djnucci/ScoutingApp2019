package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Auto;

import org.apache.http.impl.cookie.BestMatchSpec;

public class SetupFragment extends BasicFragment {
    private int layout;

    private RadioButton levelOneBtn;
    private RadioButton levelTwoRightBtn;
    private RadioButton levelTwoLeftBtn;

    private RadioButton hatchPreload;
    private RadioButton cargoPreload;
    private  RadioButton noPrelaod;

   private Button matchPlayTab;
    private Button endGameTab;

    public SetupFragment(){}

    @SuppressLint("ValidFragment")
    public SetupFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(this.layout, container, false);


        levelOneBtn = (RadioButton) view.findViewById(R.id.setup_level_one);
        levelTwoLeftBtn = (RadioButton) view.findViewById(R.id.setup_level_two_left);
        levelTwoRightBtn = (RadioButton) view.findViewById(R.id.setup_level_two_left);

        hatchPreload = (RadioButton) view.findViewById(R.id.setup_hatch_radioButton);
        cargoPreload = (RadioButton) view.findViewById((R.id.setup_cargo_radioButton));
        noPrelaod = (RadioButton)  view.findViewById(R.id.setup_nothing_radioButton);

        matchPlayTab = (Button) view.findViewById(R.id.scouting_setup_match);
        endGameTab = (Button) view.findViewById(R.id.scouting_setup_endgame);

        matchPlayTab.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Auto auto = new Auto();
                                                if(cargoPreload.isChecked()){
                                                    auto.setStartingObj('C');
                                                    auto.setAutoPreload('1');
                                                }
                                                else if (hatchPreload.isChecked()){
                                                    auto.setStartingObj('H');
                                                    auto.setAutoPreload('1');
                                                }
                                                else if(noPrelaod.isChecked()){
                                                    auto.setStartingObj('N');
                                                    auto.setAutoPreload('1');
                                                }

                                                if(levelOneBtn.isChecked()){
                                                    auto.setAutoLvl(1);
                                                }
                                                if (levelTwoLeftBtn.isChecked() || levelTwoRightBtn.isChecked()){
                                                    auto.setAutoLvl(2);
                                                }
                                                MainActivity.globalSubmitMatch.setAuto(auto);

                                            }
                                        });





        return view;
    }
}

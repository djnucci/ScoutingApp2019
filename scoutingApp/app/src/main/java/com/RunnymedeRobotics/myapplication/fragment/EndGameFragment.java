package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Auto;
import com.RunnymedeRobotics.myapplication.datastructureclasses.EndGame;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.RunnymedeRobotics.myapplication.jsonqueue.JsonWrapper;
import com.RunnymedeRobotics.myapplication.jsonqueue.QueueWrapper;
import com.RunnymedeRobotics.myapplication.network.CallAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import com.RunnymedeRobotics.myapplication.network.CallAPI;

public class EndGameFragment extends BasicFragment {
    /**
     * layout
     */
    private int layout;
    /**
     * initiating the layout properties for the endgame screen
     */
    private CheckBox levelOneClimb;
    private CheckBox levelTwoLeftClimb;
    private CheckBox levelTwoRightClimb;
    private CheckBox levelThreeClimb;

    ArrayList<CheckBox> climbLevels;

    private CheckBox buddyd;

    private RadioGroup climbFailRadiogrp;

    private RadioButton levelOneClimbFail;
    private RadioButton levelTwoClimbFail;
    private RadioButton levelThreeClimbFail;

    //EndGame a;
    private int climbTimeStart;
    private int climbLevel2Time;
    private int climbTimeEnd;
    private int climbDuration;


    private Button finalSubmitMatch;

    public EndGameFragment() {
    }

    @SuppressLint("ValidFragment")
    public EndGameFragment(int layout) {
        this.layout = layout;
    }

    /**
     * Gets the values from different checkboxes.
     * Final submit btn to finish the match.
     * TODO: Timestamps
     * TODO: Timer implementation
     * TODO: Creating JSON files and submitting match to server
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(this.layout, container, false);

        //Callll once
        /** -------------------------------------------------------------
         /** ----------------------------------------------------------          **/
        //MainActivity.globalSubmitMatch = new SubmitMatch();

        levelOneClimb = (CheckBox) view.findViewById(R.id.level_one_endgame_climb_chkbx);
        levelTwoLeftClimb = (CheckBox) view.findViewById(R.id.level_two_engame_climb_left_chkbx);
        levelTwoRightClimb = (CheckBox) view.findViewById(R.id.level_two_endgame_climb_right_chkbx);
        levelThreeClimb = (CheckBox)  view.findViewById(R.id.level_three_endgame_climb_chkbx);

        buddyd = (CheckBox) view.findViewById(R.id.buddyd_climb_chkbx);

        climbFailRadiogrp = (RadioGroup) view.findViewById(R.id.climb_fail_radiogroup);

        levelOneClimbFail = (RadioButton) view.findViewById(R.id.level_one_fail_rdbtn);
        levelTwoClimbFail = (RadioButton) view.findViewById(R.id.level_two_fail_rdbtn);
        levelThreeClimbFail = (RadioButton) view.findViewById(R.id.level_three_fail_rdbtn);

        finalSubmitMatch = (Button) view.findViewById(R.id.final_submit_btn);

        climbLevels = new ArrayList<CheckBox>(Arrays.asList(levelOneClimb,levelTwoLeftClimb,levelTwoRightClimb,levelThreeClimb));
        climbDuration = 0;
        climbTimeEnd =0;
        climbTimeStart = 0;
       // a = new EndGame();

           levelOneClimb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    climbTimeStart = (int)CycleHelper.TimeHepler.getElapsedTimeSecs();
                }
            });

        levelTwoLeftClimb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelOneClimb.setChecked(true);
                climbTimeEnd = ((int)CycleHelper.TimeHepler.getElapsedTimeSecs());

            }
        });
        levelTwoRightClimb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelOneClimb.setChecked(true);
                climbTimeEnd =((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
            }
        });
        levelThreeClimb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelOneClimb.setChecked(true);
                climbTimeEnd =((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
            }
        });




        finalSubmitMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * TODO: TIMER
             * TODO: VALUES FOR timeToClimb, climbStart, climbEnd for the EndGame Object
             */
            public void onClick(View v){
                /**
                 * New object of endgame to record data for the match
                 */


                /**
                 * Sets values of all radiobtns(default of ramp is 'N')
                 * and chechboxes(default being false for climbs)
                 */


                EndGame endgame = new EndGame();
                /**
                 * Sets values of all radiobtns(default of ramp is 'N')
                 * and chechboxes(default being false for climbs)
                 */
                if(levelOneClimb.isChecked()){
                    endgame.setLevelOne(true);
                }
                else {
                    endgame.setLevelOne(false);
                }

                if(levelTwoLeftClimb.isChecked() || levelTwoRightClimb.isChecked()){
                    endgame.setLevelTwo(true);
                }
                else {
                    endgame.setLevelTwo(false);
                }

                if(levelThreeClimb.isChecked()){
                    endgame.setLevelThree(true);
                }
                else{
                    endgame.setLevelThree(false);
                }

                if(buddyd.isChecked()){
                    endgame.setRamp(true);
                }
                else {
                    endgame.setRamp(false);
                }

                if(levelOneClimbFail.isChecked()){
                    endgame.setFailLevel('1');
                }
                else if(levelTwoClimbFail.isChecked()){
                    endgame.setFailLevel('2');
                }
                else if(levelThreeClimbFail.isChecked()){
                    endgame.setFailLevel('3');
                }
                else{
                    endgame.setFailLevel('N');
                }

                if(climbTimeEnd>0 && climbTimeStart>0){
                    endgame.setCimbStart((int)climbTimeStart);
                    endgame.setClimbEnd((int) climbTimeEnd);
                    endgame.setTimeToClimb((int) climbDuration);
                }

                MainActivity.globalSubmitMatch.setEndGame(endgame);
                MainActivity.queueWrapper.addToQueueWrapper(MainActivity.globalSubmitMatch);
                JsonWrapper.writeQueueToFile(MainActivity.queueWrapper, getContext());
                JsonWrapper.writeMatchToFile(MainActivity.globalSubmitMatch, getContext());
                CallAPI.submitLocalQueue(MainActivity.queueWrapper, getContext());
                Log.e("ATUO LVL FROM AUTO OBJ" ,MainActivity.globalSubmitMatch.getAuto().getAutoLvl() + "");
                Log.e("LEVEL FAIL", MainActivity.globalSubmitMatch.getEndGame().getFailLevel()+"");
                Log.e("LEVEL FAIL", MainActivity.globalSubmitMatch.getEndGame().getFailLevel()+"");

                InitInfoFragment initInfo = new InitInfoFragment(R.layout.scouting_start_page);
                FragmentTransaction f = getActivity().getSupportFragmentManager().beginTransaction();
                f.replace(R.id.fragment_container, initInfo);
                f.addToBackStack(null);
                f.commit();
            }}



        );


        return view;
    }
    public void onDestroy(){

        Log.e("AUTO PRELOAD END", MainActivity.globalSubmitMatch.getAuto().getStartingObj() +"");
        Log.e("AUTO LEVEL END", MainActivity.globalSubmitMatch.getAuto().getAutoLvl() +"");
        EndGame endgame = new EndGame();
        /**
         * Sets values of all radiobtns(default of ramp is 'N')
         * and chechboxes(default being false for climbs)
         */
        if(levelOneClimb.isChecked()){
            endgame.setLevelOne(true);
        }
        else {
            endgame.setLevelOne(false);
        }

        if(levelTwoLeftClimb.isChecked() || levelTwoRightClimb.isChecked()){
            endgame.setLevelTwo(true);
        }
        else {
            endgame.setLevelTwo(false);
        }

        if(levelThreeClimb.isChecked()){
            endgame.setLevelThree(true);
        }
        else{
            endgame.setLevelThree(false);
        }

        if(buddyd.isChecked()){
            endgame.setRamp(true);
        }
        else {
            endgame.setRamp(false);
        }

        if(levelOneClimbFail.isChecked()){
            endgame.setFailLevel('1');
        }
        else if(levelTwoClimbFail.isChecked()){
            endgame.setFailLevel('2');
        }
        else if(levelThreeClimbFail.isChecked()){
            endgame.setFailLevel('3');
        }
        else{
            endgame.setFailLevel('N');
        }

        if(climbTimeEnd>0 && climbTimeStart>0){
            endgame.setCimbStart((int)climbTimeStart);
            endgame.setClimbEnd((int) climbTimeEnd);
            endgame.setTimeToClimb((int) climbDuration);
        }

        MainActivity.globalSubmitMatch.setEndGame(endgame);
        //MainActivity.globalSubmitMatch = new SubmitMatch();

        super.onDestroy();
    }



}

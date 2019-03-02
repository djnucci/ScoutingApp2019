package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.RunnymedeRobotics.myapplication.datastructureclasses.InitInfo;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.Match;

public class InitInfoFragment extends BasicFragment {

    private int layout;

    EditText nameEditText;
    EditText matchEditText;
    EditText teamEditText;
    Button submitBtn;

    Button red1Btn;
    Button red2Btn;
    Button red3Btn;
    Button blue1Btn;
    Button blue2Btn;
    Button blue3Btn;

    private static int team;




    public InitInfoFragment(){}

    @SuppressLint("ValidFragment")
    public InitInfoFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(this.layout, container, false);

        nameEditText = (EditText) view.findViewById(R.id.name_edit_text);
        matchEditText = (EditText) view.findViewById(R.id.match_edit_text);
        teamEditText = (EditText) view.findViewById(R.id.team_edit_text);
        submitBtn = (Button) view.findViewById(R.id.scouting_start_setup);
        red1Btn = (Button) view.findViewById(R.id.red_one);
        red2Btn = (Button) view.findViewById(R.id.red_two);
        red3Btn = (Button) view.findViewById(R.id.red_three);
        blue1Btn = (Button) view.findViewById(R.id.blue_one);
        blue2Btn = (Button) view.findViewById(R.id.blue_two);
        blue3Btn = (Button) view.findViewById(R.id.blue_three);


        matchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }



            @Override
            public void afterTextChanged(Editable s) {
                try{
                    Match match = MainActivity.matchLists.getMatch(Integer.parseInt(matchEditText.getText().toString()));
                    red1Btn.setText(match.getR1() + "");
                    red2Btn.setText(match.getR2() + "");
                    red3Btn.setText(match.getR3() + "");
                    blue1Btn.setText(match.getB1() + "");
                    blue2Btn.setText(match.getB2() + "");
                    blue3Btn.setText(match.getB3() + "");
                    Log.e("Text", red1Btn.getText().toString());

                }catch (IndexOutOfBoundsException e){
                    Log.e("error", e.toString());
                }
                catch (NullPointerException e){
                    Log.e("error", e.toString());
                    e.getStackTrace();
                }
                catch (java.lang.NumberFormatException e){
                    Log.e("error: ", e.toString());
                    e.printStackTrace();
                }
            }
        });

        buttonListner(red1Btn);
        buttonListner(red2Btn);
        buttonListner(red3Btn);
        buttonListner(blue1Btn);
        buttonListner(blue2Btn);
        buttonListner(blue3Btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitInfo initInfo = new InitInfo();


                initInfo.setEvent(SettingsFragment.competetion);
                initInfo.setTeamNumber(Integer.parseInt(teamEditText.getText().toString()));
                initInfo.setMatchNumber(Integer.parseInt(matchEditText.getText().toString()));
                initInfo.setName(nameEditText.getText().toString());

                try {
                    initInfo.setAllianceColour(MainActivity.matchLists.getMatch(Integer.parseInt(matchEditText.getText().toString())).getAllianceColour(
                            Integer.parseInt(teamEditText.getText().toString())
                    ));
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
                MainActivity.globalSubmitMatch = new SubmitMatch();
                MainActivity.globalSubmitMatch.setInitInfo(initInfo);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("Submit", "Done");
                    }
                }).run();
            }
        });

        return view;
    }

    public int buttonListner(final Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    team = Integer.parseInt(btn.getText().toString());
                    teamEditText.setText(team + "");
                }
                catch (java.lang.NumberFormatException e){
                    Log.e("error", e.toString());
                    return;
                }

            }
        });
        return team;
    }


}

package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.RunnymedeRobotics.myapplication.datastructureclasses.InitInfo;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;

public class InitInfoFragment extends BasicFragment {

    private int layout;

    EditText nameEditText;
    EditText matchEditText;
    EditText teamEditText;

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

        InitInfo initInfo = new InitInfo();

        initInfo.setEvent(SettingsFragment.competetion);
        initInfo.setTeamNumber(Integer.parseInt(teamEditText.getText().toString()));
        initInfo.setMatchNumber(Integer.parseInt(matchEditText.getText().toString()));
        initInfo.setName(nameEditText.getText().toString());

        MainActivity.globalSubmitMatch = new SubmitMatch();
        MainActivity.globalSubmitMatch.setInitInfo(initInfo);

        return view;
    }

}

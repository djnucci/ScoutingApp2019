package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.RunnymedeRobotics.myapplication.R;

public class AutoFragment extends BasicFragment {
    private int layout;

    Button levelOneBtn;
    public AutoFragment(){}

    @SuppressLint("ValidFragment")
    public AutoFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(this.layout, container, false);

        levelOneBtn = (Button) view.findViewById(R.id.setup_level_one);


        return view;
    }
}

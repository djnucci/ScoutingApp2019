package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.network.CallAPI;
/**
 * Created by Simar on 3/6/2019.
 */

public class SyncDataFragment extends BasicFragment {
    private int layout;
    Button syncButton;

    public SyncDataFragment(){}

    @SuppressLint("ValidFragment")
    public SyncDataFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(this.layout, container, false);
        syncButton = (Button) view.findViewById(R.id.sync);
        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Updates settings
                CallAPI.submitLocalQueue(MainActivity.queueWrapper, getContext());
            }
        });

        return view;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }


    public static String getBtnIds(View view, Button btn){
        int btnId = btn.getId();
        String id = view.getResources().getResourceName(btnId);
        return  id.substring(39, id.length());
    }
}

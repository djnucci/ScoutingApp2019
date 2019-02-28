package com.RunnymedeRobotics.myapplication.filehandler;

import android.content.Context;

import com.RunnymedeRobotics.myapplication.datastructureclasses.MatchLists;
import com.RunnymedeRobotics.myapplication.fragment.SettingsFragment;
import com.google.gson.Gson;

import org.json.JSONException;

public class InflateSchedule{

    public static MatchLists inflateSchedule(Context context) throws JSONException {
       String shceduleString =  FileHandler.readFromFile(context, SettingsFragment.competetion + "_schedule.json");
       return (new Gson().fromJson(shceduleString,MatchLists.class));
    }
}

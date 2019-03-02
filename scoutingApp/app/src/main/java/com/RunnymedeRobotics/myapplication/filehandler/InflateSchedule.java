package com.RunnymedeRobotics.myapplication.filehandler;

import android.content.Context;
import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.MatchLists;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//TODO Redundant shift to JSONWrapper and integrate with the file reader method there
public class InflateSchedule{

    public static MatchLists inflateSchedule(Context context)  {
        File sdcard = new File(context.getFilesDir().getPath());

//Get the text file
        File file = new File(sdcard,"schedule.json");

//Read text from file
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//Find the view by its id
        Gson gson = new Gson();
        MatchLists matchLists = gson.fromJson(text.toString(),MatchLists.class);
        return matchLists;
    }
}

package com.RunnymedeRobotics.myapplication.jsonqueue;

import android.content.Context;
import android.provider.SyncStateContract;
import android.util.Log;

import com.RunnymedeRobotics.myapplication.Constants;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Simar on 2/18/2019.
 */

public class JsonWrapper {


    public static QueueWrapper getQueueDataFromFile(Context context){
        String val = readFromFile(context, Constants.QUEUE_FILE_NAME);
        return (new Gson()).fromJson(val, QueueWrapper.class);
    }

    public static void writeQueueToFile(QueueWrapper queueWrapper, Context context){
        writeToFile((new Gson()).toJson(queueWrapper),context, Constants.QUEUE_FILE_NAME);
    }

    public static void writeMatchToFile(SubmitMatch submitMatch, Context context){
        writeToFile((new Gson()).toJson(submitMatch),context, submitMatch.getInitInfo().getMatchNumber() +""+submitMatch.getInitInfo().getTeamNumber()+"_" + submitMatch.getInitInfo().getEvent()+"_match.json");
    }

    public static void newQueue(Context context){
        writeToFile("",context, Constants.QUEUE_FILE_NAME);
    }



    private static String readFromFile(Context context, String fileName) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static void writeToFile(String data,Context context, String fileName) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }



}

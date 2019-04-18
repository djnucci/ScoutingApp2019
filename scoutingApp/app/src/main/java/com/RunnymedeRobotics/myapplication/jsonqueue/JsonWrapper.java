package com.RunnymedeRobotics.myapplication.jsonqueue;

import android.content.Context;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.util.Log;

import com.RunnymedeRobotics.myapplication.Constants;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmittedFile;
import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.MatchLists;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import static android.content.ContentValues.TAG;

/**
 * Created by Simar on 2/18/2019.
 */

public class JsonWrapper {


    public static QueueWrapper getQueueDataFromFile(Context context, String fileName){
        String val = readFromFile(context, fileName);
        return (new Gson()).fromJson(val, QueueWrapper.class);
    }

    public static MatchLists inflateMatchList(Context context){
        String val = readFromFile(context,Constants.MATCH_LIST_FILENAME);
        return (new Gson()).fromJson(val,MatchLists.class);
    }


    public static void writeQueueToFile(QueueWrapper queueWrapper, Context context, String fileName){
        try {
            writeToFile((new Gson()).toJson(queueWrapper), fileName,context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMatchToFile(SubmitMatch submitMatch, Context context){
        try {
            String fileName = submitMatch.getInitInfo().getMatchNumber() +"_"+submitMatch.getInitInfo().getTeamNumber()+"_" + submitMatch.getInitInfo().getEvent()+"_match.json";
            writeToFile((new Gson()).toJson(submitMatch),fileName , context);
            writeToFile((new Gson()).toJson(new SubmittedFile(fileName, submitMatch.getInitInfo().getEvent())), "files_submitted.json", context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void newQueue(Context context){
        try {
            writeToFile("", Constants.QUEUE_FILE_NAME, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeToFile(String data, String fileName, Context context) throws IOException {
        File root = Environment.getExternalStorageDirectory();

        File outDir = new File(root.getAbsolutePath() + File.separator + "Scouting_App_2019");
        Writer writer;
        boolean success = true;
        if (!outDir.exists()) {
            success = outDir.mkdirs();
        }
        if (success) {
            File outPutFile = new File(outDir, fileName);
            writer = new PrintWriter(new FileWriter(outPutFile));
            Log.e("Writing to File",data);
            writer.write(data);
            writer.close();
            writer.flush();
        } else {
           Log.e("Error","Folder not created properly");
        }
    }

    public static String readFromFile(Context context, String fileName){
            String line = null;

            try {
                FileInputStream fileInputStream = new FileInputStream (new File(Environment.getExternalStorageDirectory().getAbsolutePath() +File.separator+ "Scouting_App_2019" +File.separator+fileName));
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();

                while ( (line = bufferedReader.readLine()) != null )
                {
                    stringBuilder.append(line + System.getProperty("line.separator"));
                }
                fileInputStream.close();
                line = stringBuilder.toString();

                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                Log.d(TAG, ex.getMessage());
            }
            catch(IOException ex) {
                Log.d(TAG, ex.getMessage());
            }
            return line;
        }
    }




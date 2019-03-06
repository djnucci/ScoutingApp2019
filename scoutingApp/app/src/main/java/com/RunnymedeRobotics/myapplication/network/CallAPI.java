package com.RunnymedeRobotics.myapplication.network;


import android.util.Log;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.fragment.SettingsFragment;
import com.RunnymedeRobotics.myapplication.jsonqueue.JsonWrapper;
import com.RunnymedeRobotics.myapplication.jsonqueue.QueueWrapper;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simar on 2/18/2019.
 */

public class CallAPI {



    /**
     * Post local queue wrapper to server
     * @param queueWrapper
     */
    public  static String submitLocalQueue(QueueWrapper queueWrapper) throws java.lang.IllegalStateException{
        if(SettingsFragment.ipAddress.equals("")){
            System.out.println("Please set value to serverIP");
            return "Please set value to serverIP";
        }

        //specifies http post to server ip and creates httppost object
        HttpClient httpclient = new DefaultHttpClient();
        Log.e("POST ADRESS : ", SettingsFragment.ipAddress+":8080/RunnymedeRoboticsScoutingApplication_war_exploded/Database/addQueueWrapper");
        Log.e("POST ADRESS : ", (SettingsFragment.ipAddress+":8080/RunnymedeRoboticsScoutingApplication_war_exploded/Database/addQueueWrapper").replaceAll("\\s+",""));
        HttpPost httppost = new HttpPost("http://"+(SettingsFragment.ipAddress+":8080/RunnymedeRoboticsScoutingApplication_war_exploded/Database/addQueueWrapper").replaceAll("\\s+",""));
        Log.e("Queue Wrapper ", (new Gson()).toJson(queueWrapper) +"");

        try {
            //Creates name value pair to pass onto the server
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        //The queue name value pair coincides on the java jax-rs server side
        nameValuePairs.add(new BasicNameValuePair("queue",(new Gson()).toJson(queueWrapper)));
        //Encodes the request to urlencodeded to conciede with the server side
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        //Executes http response
        HttpResponse httpResponse = httpclient.execute(httppost);
        //returns the response from server if any
            if(httpResponse.equals("post_complete")){
                JsonWrapper.newQueue(MainActivity.getContext());
            }
        return "Post Completed ==> " + httpResponse.toString();
    }
    catch (ClientProtocolException e){
        e.printStackTrace();
        return "Post Error";
    }
    catch (IOException  e){
        e.printStackTrace();
        return "Post Error";
    }
    catch (IllegalStateException e){
            e.printStackTrace();
            return "Post Error";
    }

}






}

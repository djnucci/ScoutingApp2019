package com.RunnymedeRobotics.myapplication.jsonqueue;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Simar on 2/18/2019.
 */

public class QueueWrapper {

    private ArrayList<SubmitMatch> submitMatchArrayList = new ArrayList<>();
    private static Gson gson = new Gson();

    public QueueWrapper() {

    }

    public QueueWrapper(ArrayList<SubmitMatch> submitMatchArrayList) {
        this.submitMatchArrayList = submitMatchArrayList;
    }

    public ArrayList<SubmitMatch> getSubmitMatchArrayList() {
        return submitMatchArrayList;
    }

    public void setSubmitMatchArrayList(ArrayList<SubmitMatch> submitMatchArrayList) {
        this.submitMatchArrayList = submitMatchArrayList;
    }

    public void addToQueueWrapper(SubmitMatch submitMatch){
        submitMatchArrayList.add(submitMatch);
    }


}

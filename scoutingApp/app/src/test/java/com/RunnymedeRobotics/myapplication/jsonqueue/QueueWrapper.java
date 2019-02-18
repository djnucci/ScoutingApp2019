package com.example.simar.androidsqlitetest.jsonqueue;

import com.example.simar.androidsqlitetest.pojo.SubmitMatch;

import java.util.ArrayList;

/**
 * Created by Simar on 2/18/2019.
 */

public class QueueWrapper {

    ArrayList<SubmitMatch> submitMatchArrayList = new ArrayList<>();

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

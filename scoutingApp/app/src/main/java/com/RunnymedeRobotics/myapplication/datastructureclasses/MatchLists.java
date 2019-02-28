package com.RunnymedeRobotics.myapplication.datastructureclasses;

import java.util.ArrayList;

public class MatchLists {

    ArrayList<Match> matchArrayList = new ArrayList<>();

    public MatchLists(ArrayList<Match> matchArrayList) {
        this.matchArrayList = matchArrayList;
    }

    public ArrayList<Match> getMatchArrayList() {
        return matchArrayList;
    }

    public void setMatchArrayList(ArrayList<Match> matchArrayList) {
        this.matchArrayList = matchArrayList;
    }


}

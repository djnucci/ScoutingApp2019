package com.RunnymedeRobotics.myapplication.datastructureclasses.schedule;

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

    public Match getMatch(int match){
       return matchArrayList.get(match-1);
    }



}

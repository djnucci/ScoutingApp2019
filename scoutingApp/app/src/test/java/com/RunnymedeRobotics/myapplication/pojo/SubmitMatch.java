package com.example.simar.androidsqlitetest.pojo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Submit match POJO
 */
public class SubmitMatch {

    Auto auto = new Auto();
    EndGame endGame = new EndGame();
    InitInfo initInfo = new InitInfo();
    ArrayList<Cycle> cycleArrayList = new ArrayList<>();

    /**
     * Blank Constructor
     */
    public SubmitMatch() {
    }

    /**
     * Constructor for all fields
     * @param auto
     * @param endGame
     * @param initInfo
     * @param cycleArrayList
     */
    public SubmitMatch(Auto auto, EndGame endGame, InitInfo initInfo, ArrayList<Cycle> cycleArrayList) {
        this.auto = auto;
        this.endGame = endGame;
        this.initInfo = initInfo;
        this.cycleArrayList = cycleArrayList;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public EndGame getEndGame() {
        return endGame;
    }

    public void setEndGame(EndGame endGame) {
        this.endGame = endGame;
    }

    public InitInfo getInitInfo() {
        return initInfo;
    }

    public void setInitInfo(InitInfo initInfo) {
        this.initInfo = initInfo;
    }

    public ArrayList<Cycle> getCycleArrayList() {
        return cycleArrayList;
    }

    public void setCycleArrayList(ArrayList<Cycle> cycleArrayList) {
        this.cycleArrayList = cycleArrayList;
    }
}

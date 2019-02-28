package com.RunnymedeRobotics.myapplication.datastructureclasses;

import java.util.ArrayList;

/**
 * Submit match POJO
 */
public class SubmitMatch {

    Auto auto = new Auto();
    EndGame endGame = new EndGame();
    InitInfo initInfo = new InitInfo();
    ArrayList<Teleop> teleopsList = new ArrayList<>();
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
     * @param teleopsList
     * @param cycleArrayList
     */
    public SubmitMatch(Auto auto, EndGame endGame, InitInfo initInfo, ArrayList<Teleop> teleopsList, ArrayList<Cycle> cycleArrayList) {
        this.auto = auto;
        this.endGame = endGame;
        this.initInfo = initInfo;
        this.teleopsList = teleopsList;
        this.cycleArrayList = cycleArrayList;
    }

    /**
     * Gets teleopsList.
     *
     * @return Value of teleopsList.
     */
    public ArrayList<Teleop> getTeleopsList() {
        return teleopsList;
    }

    /**
     * Sets new teleopsList.
     *
     * @param teleopsList New value of teleopsList.
     */
    public void setTeleopsList(ArrayList<Teleop> teleopsList) {
        this.teleopsList = teleopsList;
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

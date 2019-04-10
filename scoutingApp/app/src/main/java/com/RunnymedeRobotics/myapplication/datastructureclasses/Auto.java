package com.RunnymedeRobotics.myapplication.datastructureclasses;

/**
 * Class for the data structure for the auto data set on the MYSQL server
 *
 * Auto_level (int)
 * Auto_order (int)
 * Auto_preload (char)
 *
 */
public class Auto {

    /**
     * The Id.
     */
    int id;
    /**
     * The Start pos.
     */
    String startPos = "";
    /**
     * The Place pos.
     */
    String placePos = "";
    /**
     * The Starting obj.
     */
    char startingObj = ' ';
    /**
     * The Time.
     */
    float time;
    /**
     * Auto Lvl
     */
    int autoLvl;
    /**
     * Auto Order
     */
    int autoOrder;
    /**
     * Auto Preload
     */
    char autoPreload;

    /**
     * Blank Constructor
     */
    public Auto() {
    }

    /**
     * Constructor not blank
     * @param id
     * @param startPos
     * @param placePos
     * @param startingObj
     * @param time
     * @param autoLvl
     * @param autoOrder
     * @param autoPreload
     */
    public Auto(int id, String startPos, String placePos, char startingObj, float time, int autoLvl, int autoOrder, char autoPreload) {
        this.id = id;
        this.startPos = startPos;
        this.placePos = placePos;
        this.startingObj = startingObj;
        this.time = time;
        this.autoLvl = autoLvl;
        this.autoOrder = autoOrder;
        this.autoPreload = autoPreload;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets start pos.
     *
     * @return the start pos
     */
    public String getStartPos() {
        return startPos;
    }

    /**
     * Sets start pos.
     *
     * @param startPos the start pos
     */
    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    /**
     * Gets place pos.
     *
     * @return the place pos
     */
    public String getPlacePos() {
        return placePos;
    }

    /**
     * Sets place pos.
     *
     * @param placePos the place pos
     */
    public void setPlacePos(String placePos) {
        this.placePos = placePos;
    }

    /**
     * Gets starting obj.
     *
     * @return the starting obj
     */
    public char getStartingObj() {
        return startingObj;
    }

    /**
     * Sets starting obj.
     *
     * @param startingObj the starting obj
     */
    public void setStartingObj(char startingObj) {
        this.startingObj = startingObj;
    }

    /**
     * Get time float [ ].
     *
     * @return the float [ ]
     */
    public float getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(float time) {
        this.time = time;
    }


    /**
     * Gets autoPreload.
     *
     * @return Value of autoPreload.
     */
    public char getAutoPreload() {
        return autoPreload;
    }

    /**
     * Sets new autoPreload.
     *
     * @param autoPreload New value of autoPreload.
     */
    public void setAutoPreload(char autoPreload) {
        this.autoPreload = autoPreload;
    }

    /**
     * Sets new autoOrder.
     *
     * @param autoOrder New value of autoOrder.
     */
    public void setAutoOrder(int autoOrder) {
        this.autoOrder = autoOrder;
    }

    /**
     * Gets autoOrder.
     *
     * @return Value of autoOrder.
     */
    public int getAutoOrder() {
        return autoOrder;
    }

    /**
     * Gets autoLvl.
     *
     * @return Value of autoLvl.
     */
    public int getAutoLvl() {
        return autoLvl;
    }

    /**
     * Sets new autoLvl.
     *
     * @param autoLvl New value of autoLvl.
     */
    public void setAutoLvl(int autoLvl) {
        this.autoLvl = autoLvl;
    }
}

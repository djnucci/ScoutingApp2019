package com.RunnymedeRobotics.myapplication.pojo;


import java.sql.Time;

/**
 * The type End game.
 *
 Level1 (bool)
 Level2 (bool)
 Level3 (bool)
 defense (bool)
 ramp(bool)
 level_fail (int)
 Climb_start_time (seconds) (int)
 Climb_end_time (seconds) (int)
 *
 */
public class EndGame {

    /**
     * The Id.
     */
    int id;
    /**
     * The Level one.
     */
    boolean levelOne;
    /**
     * The Level two.
     */
    boolean levelTwo;
    /**
     * The Level three.
     */
    boolean levelThree;
    /**
     * The Ramp.
     */
    boolean ramp;
    /**
     * The Time to climb.
     */
    float timeToClimb;
    /**
     * The Fail level.
     */
    char failLevel;

    /**
     * Climb Start
     */
    Time cimbStart;

    /**
     * Climb End timestamp
     */
    Time climbEnd;
    /**
     * Instantiates a new End game.
     */
    public EndGame() {
    }

    /**
     * Contructor for all the fields
     * @param id
     * @param levelOne
     * @param levelTwo
     * @param levelThree
     * @param ramp
     * @param timeToClimb
     * @param failLevel
     * @param cimbStart
     * @param climbEnd
     */
    public EndGame(int id, boolean levelOne, boolean levelTwo, boolean levelThree, boolean ramp, float timeToClimb, char failLevel, Time cimbStart, Time climbEnd) {
        this.id = id;
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
        this.ramp = ramp;
        this.timeToClimb = timeToClimb;
        this.failLevel = failLevel;
        this.cimbStart = cimbStart;
        this.climbEnd = climbEnd;
    }

    /**
     * Is level one boolean.
     *
     * @return the boolean
     */
    public boolean isLevelOne() {
        return levelOne;
    }

    /**
     * Sets level one.
     *
     * @param levelOne the level one
     */
    public void setLevelOne(boolean levelOne) {
        this.levelOne = levelOne;
    }

    /**
     * Is level two boolean.
     *
     * @return the boolean
     */
    public boolean isLevelTwo() {
        return levelTwo;
    }

    /**
     * Sets level two.
     *
     * @param levelTwo the level two
     */
    public void setLevelTwo(boolean levelTwo) {
        this.levelTwo = levelTwo;
    }

    /**
     * Is level three boolean.
     *
     * @return the boolean
     */
    public boolean isLevelThree() {
        return levelThree;
    }

    /**
     * Sets level three.
     *
     * @param levelThree the level three
     */
    public void setLevelThree(boolean levelThree) {
        this.levelThree = levelThree;
    }

    /**
     * Is ramp boolean.
     *
     * @return the boolean
     */
    public boolean isRamp() {
        return ramp;
    }

    /**
     * Sets ramp.
     *
     * @param ramp the ramp
     */
    public void setRamp(boolean ramp) {
        this.ramp = ramp;
    }

    /**
     * Gets time to climb.
     *
     * @return the time to climb
     */
    public float getTimeToClimb() {
        return timeToClimb;
    }

    /**
     * Sets time to climb.
     *
     * @param timeToClimb the time to climb
     */
    public void setTimeToClimb(float timeToClimb) {
        this.timeToClimb = timeToClimb;
    }

    /**
     * Gets fail level.
     *
     * @return the fail level
     */
    public char getFailLevel() {
        return failLevel;
    }

    /**
     * Sets fail level.
     *
     * @param failLevel the fail level
     */
    public void setFailLevel(char failLevel) {
        this.failLevel = failLevel;
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
     * Gets Climb End timestamp.
     *
     * @return Value of Climb End timestamp.
     */
    public Time getClimbEnd() {
        return climbEnd;
    }

    /**
     * Gets Climb Start.
     *
     * @return Value of Climb Start.
     */
    public Time getCimbStart() {
        return cimbStart;
    }

    /**
     * Sets new Climb Start.
     *
     * @param cimbStart New value of Climb Start.
     */
    public void setCimbStart(Time cimbStart) {
        this.cimbStart = cimbStart;
    }

    /**
     * Sets new Climb End timestamp.
     *
     * @param climbEnd New value of Climb End timestamp.
     */
    public void setClimbEnd(Time climbEnd) {
        this.climbEnd = climbEnd;
    }
}

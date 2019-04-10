package com.RunnymedeRobotics.myapplication.datastructureclasses;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Time;
/**
 * The type Cycle.
 *
 * * Cycle
 *  *      game_piece (Char)
 *  *      Score (bool)
 *  *      pickup_location (String)
 *  *      dropoff_location (String)
 *  *      pickup_time (seconds) (int)
 *  *      dropoff_time (seconds) (int)
 */
@DatabaseTable(tableName = "cycle")
public class Cycle {

    /**
     * The Id.
     */
    @DatabaseField(id = true)
    int id;
    /**
     * The Cycle number.
     */
    @DatabaseField
    int cycleNumber;
    /**
     * The Field element.
     */
    @DatabaseField
    char fieldElement = ' ';
    /**
     * The Pick up location.
     */
    @DatabaseField
    String pickUp = "";
    /**
     * The Place location.
     */
    @DatabaseField
    String place = "";
    /**
     * The Defense.
     */
    @DatabaseField
    boolean defense;
    /**
     * The Drop.
     */
    @DatabaseField
    boolean drop;

    /**
     * pickup Timetsamp
     */
    @DatabaseField
    int pickupTime;

    /**
     * Time stamp for dropoff
     */
    @DatabaseField
    int dropoffTime;



    /**
     * Instantiates a new Cycle.
     */
    public Cycle() {
    }

    /**
     * Constructor for all fields
     * @param id
     * @param cycleNumber
     * @param fieldElement
     * @param pickUp
     * @param place
     * @param defense
     * @param drop
     * @param pickupTime
     * @param dropoffTime
     */
    public Cycle(int id, int cycleNumber, char fieldElement, String pickUp, String place, boolean defense, boolean drop, int pickupTime, int dropoffTime) {
        this.id = id;
        this.cycleNumber = cycleNumber;
        this.fieldElement = fieldElement;
        this.pickUp = pickUp;
        this.place = place;
        this.defense = defense;
        this.drop = drop;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
    }

    /**
     * Gets field element.
     *
     * @return the field element
     */
    public char getFieldElement() {
        return fieldElement;
    }

    /**
     * Sets field element.
     *
     * @param fieldElement the field element
     */
    public void setFieldElement(char fieldElement) {
        this.fieldElement = fieldElement;
    }

    /**
     * Gets pick up.
     *
     * @return the pick up
     */
    public String getPickUp() {
        return pickUp;
    }

    /**
     * Sets pick up.
     *
     * @param pickUp the pick up
     */
    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    /**
     * Gets place.
     *
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets place.
     *
     * @param place the place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Is defense boolean.
     *
     * @return the boolean
     */
    public boolean isDefense() {
        return defense;
    }

    /**
     * Sets defense.
     *
     * @param defense the defense
     */
    public void setDefense(boolean defense) {
        this.defense = defense;
    }

    /**
     * Is drop boolean.
     *
     * @return the boolean
     */
    public boolean isDrop() {
        return drop;
    }

    /**
     * Sets drop.
     *
     * @param drop the drop
     */
    public void setDrop(boolean drop) {
        this.drop = drop;
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
     * Gets cycle number.
     *
     * @return the cycle number
     */
    public int getCycleNumber() {
        return cycleNumber;
    }

    /**
     * Sets cycle number.
     *
     * @param cycleNumber the cycle number
     */
    public void setCycleNumber(int cycleNumber) {
        this.cycleNumber = cycleNumber;
    }


    /**
     * Gets pickupTime.
     *
     * @return Value of pickupTime.
     */
    public int getPickupTime() {
        return pickupTime;
    }

    /**
     * Sets new dropoffTime.
     *
     * @param dropoffTime New value of dropoffTime.
     */
    public void setDropoffTime(int dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    /**
     * Sets new pickupTime.
     *
     * @param pickupTime New value of pickupTime.
     */
    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    /**
     * Gets dropoffTime.
     *
     * @return Value of dropoffTime.
     */
    public int getDropoffTime() {
        return dropoffTime;
    }

}

package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Auto;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Cycle;
import com.RunnymedeRobotics.myapplication.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchPlayFragment extends BasicFragment {
    public static boolean gameStart;
    private static boolean hasPiece;
    private char pickedUpPiece;
    private int crossNum;
    private static boolean hasCrossed ;
    private int layout;
    private int cycleNum;


    Cycle c = new Cycle();
    ArrayList<Cycle> cycles;

    private Button startMatchBtn;

    private Button crossPickupHatchBtn;
    private Button crossPickupCargoBtn;
    private Button crossDropGamePieceBtn;
    private Button crossFieldBtn;

    private Button pickupHpLeftHatchBtn;
    private Button pickupHpLeftCargoBtn;
    private Button pickupHpRightHatchBtn;
    private Button pickupHpRightCargoBtn;
    private Button pickupCargoBayLeftBtn;
    private Button pickupCargoBayRightBtn;

    private Button scoreBusLeftFarBtn;
    private Button scoreBusLeftMiddleBtn;
    private Button scoreBusLeftCloseBtn;

    private Button scoreBusRightFarBtn;
    private Button scoreBusRightMiddleBtn;
    private Button scoreBusRightCloseBtn;

    private Button scoreBusFrontSideLeftBtn;
    private Button scoreBusFrontSideRightBtn;

    private Button scoreRocketFarSideHatchLowBtn;
    private Button scoreRocketFarSideHatchMidBtn;
    private Button scoreRocketFarSideHatchHighBtn;

    private Button scoreRocketMidSideCargoLowBtn;
    private Button scoreRocketMidSideCargoMidBtn;
    private Button scoreRocketMidSideCargohighBtn;

    private Button scoreRocketNearSideHatchLowBtn;
    private Button scoreRocketNearSideHatchMidBtn;
    private Button scoreRocketNearSideHatchHighBtn;

    private Button pickupLooseHatchBtn;
    private Button pickupLooseCargoBtn;
    private Button dropGamePieceBtn;

    private ScrollView rocketFarHatchScrollView;
    private ScrollView rocketMidCargoScrollView;
    private ScrollView rocketCloseHatchScrollView;

    private Button defenseBtn;

    ArrayList<Button> pickupBtns = new ArrayList<Button>(Arrays.asList(pickupHpLeftHatchBtn,pickupHpLeftCargoBtn,
                                                                       pickupHpRightHatchBtn,pickupHpRightCargoBtn,
                                                                       pickupCargoBayLeftBtn,pickupCargoBayRightBtn,
                                                                       pickupLooseHatchBtn,pickupLooseCargoBtn));

    ArrayList<Button> scoreBtns = new ArrayList<Button>(Arrays.asList(scoreBusLeftFarBtn,scoreBusLeftMiddleBtn,
                                                                     scoreBusLeftCloseBtn,scoreBusRightFarBtn,
                                                                     scoreBusRightMiddleBtn,scoreBusRightCloseBtn,
                                                                     scoreBusFrontSideLeftBtn,scoreBusFrontSideRightBtn,
                                                                     scoreRocketFarSideHatchLowBtn,scoreRocketFarSideHatchMidBtn,
                                                                      scoreRocketFarSideHatchHighBtn,scoreRocketMidSideCargoLowBtn,
                                                                     scoreRocketMidSideCargoMidBtn,scoreRocketMidSideCargohighBtn,
                                                                     scoreRocketNearSideHatchLowBtn,scoreRocketNearSideHatchMidBtn,
                                                                      scoreRocketNearSideHatchHighBtn));

    ArrayList<ScrollView> scoreScrolls = new ArrayList<ScrollView>(Arrays.asList(rocketFarHatchScrollView,rocketMidCargoScrollView,rocketCloseHatchScrollView));

    ArrayList<Button> dropBtns = new ArrayList<Button>(Arrays.asList(dropGamePieceBtn));

    ArrayList<Button> crossBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn,crossPickupCargoBtn,crossPickupHatchBtn));

    ArrayList<Button> allBtns;

    public MatchPlayFragment() {
        makeBtnsVisible(scoreBtns);
    }

    @SuppressLint("ValidFragment")
    public MatchPlayFragment(int layout) {
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // CycleHelper.TimeHepler.start();
       View view = inflater.inflate(this.layout, container, false);

        crossNum = 0;
        hasCrossed = isCrossed(crossNum);
         hasPiece = true;
         gameStart  = false;
         cycleNum = 0;
         //pickedUpPiece = ?



        startMatchBtn = (Button) view.findViewById(R.id.matchplay_start_match_btn);

        crossPickupHatchBtn = (Button) view.findViewById(R.id.matchplay_cross_hatch_pickup_btn);
        crossPickupCargoBtn = (Button) view.findViewById(R.id.matchplay_cross_cargo_pickup_btn);
        crossDropGamePieceBtn = (Button) view.findViewById(R.id.matchplay_cross_drop_gamepiece_btn);
        crossFieldBtn = (Button) view.findViewById(R.id.matchplay_cross_field_btn);

        Log.e("int val: " ,R.id.matchplay_pickup_hp_left_hatch_btn +"");
        pickupHpLeftHatchBtn = (Button) view.findViewById(R.id.matchplay_pickup_hp_left_hatch_btn);
        pickupHpLeftCargoBtn = (Button) view.findViewById(R.id.matchplay_pickup_hp_left_cargo_btn);
        pickupHpRightHatchBtn = (Button) view.findViewById(R.id.matchplay_pickup_hp_right_hatch_btn);
        pickupHpRightCargoBtn = (Button) view.findViewById(R.id.matchplay_pickup_hp_right_cargo_btn);
        pickupCargoBayLeftBtn = (Button) view.findViewById(R.id.matchplay_pickup_cargobay_left_cargo_btn);
        pickupCargoBayRightBtn = (Button) view.findViewById(R.id.matchplay_pickup_cargobay_right_cargo_btn);

        scoreBusLeftFarBtn = (Button) view.findViewById(R.id.matchplay_cargoship_leftside_far_scoring_btn);
        scoreBusLeftMiddleBtn = (Button) view.findViewById(R.id.matchplay_cargoship_leftside_middle_scoring_btn);
        scoreBusLeftCloseBtn = (Button) view.findViewById(R.id.matchplay_cargoship_leftside_close_scoring_btn);

        scoreBusRightFarBtn = (Button) view.findViewById(R.id.matchplay_cargoship_rightside_far_scoring_btn);
        scoreBusRightMiddleBtn = (Button) view.findViewById(R.id.matchplay_cargoship_rightside_middle_scoring_btn);
        scoreBusRightCloseBtn = (Button) view.findViewById(R.id.matchplay_cargoship_rightside_close_scoring_btn);

        scoreBusFrontSideLeftBtn = (Button) view.findViewById(R.id.matchplay_cargoship_frontside_left_scoring_btn);
        scoreBusFrontSideRightBtn = (Button) view.findViewById(R.id.matchplay_cargoship_frontside_right_scoring_btn);

        scoreRocketFarSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_low_hatch_btn);
        scoreRocketFarSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_mid_hatch_btn);
        scoreRocketFarSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_high_hatch_btn);

        scoreRocketMidSideCargoLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_low_btn);
        scoreRocketMidSideCargoMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_mid_btn);
        scoreRocketMidSideCargohighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_high_btn);

        scoreRocketNearSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_low_hatch_btn);
        scoreRocketNearSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_mid_hatch_btn);
        scoreRocketNearSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_high_hatch_btn);

        pickupLooseHatchBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_hatch_btn);
        pickupLooseCargoBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_cargo_btn);
        dropGamePieceBtn = (Button) view.findViewById(R.id.matchplay_drop_alliance_side_btn);

        defenseBtn = (Button) view.findViewById(R.id.matchplay_defense_btn);



        pickupBtns = new ArrayList<Button>( Arrays.asList(
                pickupHpLeftHatchBtn,pickupHpRightHatchBtn,pickupLooseHatchBtn,crossPickupHatchBtn,
                pickupHpRightCargoBtn,pickupCargoBayLeftBtn,pickupCargoBayRightBtn,pickupLooseCargoBtn,crossPickupCargoBtn,pickupHpLeftCargoBtn));

       scoreBtns = new ArrayList<Button>(Arrays.asList(scoreBusLeftFarBtn,scoreBusLeftMiddleBtn,
                scoreBusLeftCloseBtn,scoreBusRightFarBtn,
                scoreBusRightMiddleBtn,scoreBusRightCloseBtn,
                scoreBusFrontSideLeftBtn,scoreBusFrontSideRightBtn,
                scoreRocketFarSideHatchLowBtn,scoreRocketFarSideHatchMidBtn,
                scoreRocketFarSideHatchHighBtn,scoreRocketMidSideCargoLowBtn,
                scoreRocketMidSideCargoMidBtn,scoreRocketMidSideCargohighBtn,
                scoreRocketNearSideHatchLowBtn,scoreRocketNearSideHatchMidBtn,
                scoreRocketNearSideHatchHighBtn));

         scoreScrolls = new ArrayList<ScrollView>(Arrays.asList(rocketFarHatchScrollView,rocketMidCargoScrollView,rocketCloseHatchScrollView));

         dropBtns = new ArrayList<Button>(Arrays.asList(dropGamePieceBtn,crossDropGamePieceBtn));

         crossBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn,crossPickupCargoBtn,crossPickupHatchBtn));

        cycles = new ArrayList<Cycle>();
        CycleHelper.TimeHepler.start();












        if(MainActivity.globalSubmitMatch.getAuto().getAutoPreload() == '1'){
            makeBtnsInvisible(pickupBtns);
            //Log.e("STATE","ITS GETTING HERE");
            makeBtnsInvisible(crossBtns);
        }
        else{
            makeBtnsInvisible(scoreBtns);
        }







        for(int i = 0; i < pickupBtns.size();i++){
            //Dumb way but it works to YEET
            final int copyOfi = i;
            pickupBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    c = new Cycle();
                    cycleNum++;
                    hasPiece= true;
                    /**
                     * this returns the id of the button atm
                     * TODO: get the text of the ID of the button
                     */
                    c.setPickUp(pickupBtns.get(copyOfi).getId() +"");
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls);
                    c.setCycleNumber(cycleNum);
                    //char test = findPickupPiece(copyOfi);
                    c.setFieldElement(findPickupPiece(copyOfi));
                    c.setPickupTime((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
                    MainActivity.globalSubmitMatch.getCycleArrayList().add(c);

                }
            });
        }


        for(int i = 0; i < scoreBtns.size();i++){
            final int copyOfi = i;
            scoreBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     * this returns the id of the button atm
                     * TODO:get the text of the ID of the button
                     */
                    c.setPlace(scoreBtns.get(copyOfi).getId()+"");
                    c.setDropoffTime((int) CycleHelper.TimeHepler.getElapsedTimeSecs());
                    c.setDrop(false);
                    hasPiece= false;
                    cycles.add(c);
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls);
                }
            });
        }


        for(int i = 0; i < dropBtns.size();i++){
            dropBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hasPiece= false;
                    c.setDrop(true);
                    c.setPlace("dropped");
                    c.setDropoffTime((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
                    cycles.add(c);
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls);
                }
            });
        }

        crossFieldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crossNum ++;
                hasCrossed = isCrossed(crossNum);
                decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls);
                Log.e("CROSSED VALUE", crossNum+"" + "hasCrossed: " + hasCrossed);
            }
        });



        startMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMatchBtn.setVisibility(View.GONE);
                //Log.e("STATE","GP");
            }

        });
        return view;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    /**
     * makes all btns in arraylist invisible
     * @param toMakeInvisible
     */
    public void makeBtnsInvisible(ArrayList<Button> toMakeInvisible){
        for (int i = 0; i < toMakeInvisible.size(); i ++){
            System.out.println(toMakeInvisible.get(i).getId());
           // Log.e("STATE:",(toMakeInvisible.get(i).getId())+"YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEET     " + i);
            (toMakeInvisible.get(i)).setVisibility(View.INVISIBLE);
        }
    }

    /**
     * makes all btns in arraylist visible
     * @param toMakeVisible
     */
    public  void  makeBtnsVisible(ArrayList<Button> toMakeVisible){
        for (int i = 0; i < toMakeVisible.size(); i ++){
            toMakeVisible.get(i).setVisibility(View.VISIBLE);
        }
    }

    /**
     * makes all scrollviews in arraylist invisible
     * @param toMakeInvisible
     */
    public void makeScrollViewInvisible(ArrayList<ScrollView> toMakeInvisible){
        for (int i = 0; i < toMakeInvisible.size(); i ++){
            toMakeInvisible.get(i).setVisibility(View.INVISIBLE);
        }
    }

    /**
     * makes all scrollviews in arraylise visible
     * @param toMakeVisible
     */
    public void makeScrollViewVisible(ArrayList<ScrollView> toMakeVisible){
        for (int i = 0; i < toMakeVisible.size(); i ++){
            toMakeVisible.get(i).setVisibility(View.VISIBLE);
        }
    }
    public void decideVisiblilites(ArrayList<Button> crossBtns1, ArrayList<Button> pickupBtns1, ArrayList<Button> scoreBtns1, ArrayList<Button> dropBtns1, ArrayList<ScrollView> scoreScrolls1){
        if(hasCrossed == true){


            makeBtnsInvisible(pickupBtns1);
            makeBtnsInvisible(scoreBtns1);
//            makeScrollViewInvisible(scoreScrolls1);
            makeBtnsInvisible(dropBtns1);
            makeBtnsVisible(crossBtns1);
        }
        else if (hasCrossed== false)
    {


            if(hasPiece == true){
                makeBtnsVisible(scoreBtns1);
               // makeScrollViewVisible(scoreScrolls1);
                makeBtnsVisible(dropBtns1);
                makeBtnsInvisible(pickupBtns1);
                makeBtnsInvisible(dropBtns1);
            }
            else {
                makeBtnsVisible(pickupBtns1);
                makeBtnsInvisible(scoreBtns1);
                makeBtnsInvisible(dropBtns1);
            }
        makeBtnsInvisible(crossBtns1);

        }
    }

    public boolean isCrossed(int crossNum1){
        if(crossNum1%2 == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public char findPickupPiece(int place){
        if (place <=3){
            return 'H';
        }
        else {
            return 'C';
        }


    }
    public void onDestroy(){

        MainActivity.globalSubmitMatch.setCycleArrayList(cycles);
        Log.e("TEST", MainActivity.globalSubmitMatch.getAuto().getAutoPreload()+"");

        super.onDestroy();
    }
}


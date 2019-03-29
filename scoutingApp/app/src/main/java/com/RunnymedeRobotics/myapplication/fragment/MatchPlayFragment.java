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
import android.widget.ImageView;
import android.widget.ScrollView;

import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Auto;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Cycle;
import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.datastructureclasses.Teleop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchPlayFragment extends BasicFragment {
    public static boolean gameStart;
    private static boolean hasPiece;
    private  static boolean rocketExpandBtnsClicked;
    private char pickedUpPiece;
    private int crossNum;
    private static boolean hasCrossed ;
    private int layout;
    private int cycleNum;



    Cycle c = new Cycle();
    ArrayList<Cycle> cycles;

    Teleop t = new Teleop();
    ArrayList<Teleop> teleops1;


    private ImageView matchImage;
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

    private Button scoreRocketRightFarSideHatchLowBtn;
    private Button scoreRocketRightFarSideHatchMidBtn;
    private Button scoreRocketRightFarSideHatchHighBtn;

    private Button scoreRocketRightMidSideCargoLowBtn;
    private Button scoreRocketRightMidSideCargoMidBtn;
    private Button scoreRocketRightMidSideCargoHighBtn;

    private Button scoreRocketRightNearSideHatchLowBtn;
    private Button scoreRocketRightNearSideHatchMidBtn;
    private Button scoreRocketRightNearSideHatchHighBtn;

    private Button scoreRocketLeftFarSideHatchLowBtn;
    private Button scoreRocketLeftFarSideHatchMidBtn;
    private Button scoreRocketLeftFarSideHatchHighBtn;

    private Button scoreRocketLeftMidSideCargoLowBtn;
    private Button scoreRocketLeftMidSideCargoMidBtn;
    private Button scoreRocketLeftMidSideCargoHighBtn;

    private Button scoreRocketLeftNearSideHatchLowBtn;
    private Button scoreRocketLeftNearSideHatchMidBtn;
    private Button scoreRocketLeftNearSideHatchHighBtn;

    private Button scoreRocketRightFarSideHatchExpandOptionsBtn;
    private Button scoreRocketRightMidSideCargoExpandOptionsBtn;
    private Button scoreRocketRightNearSideHatchExpandOptionsBtn;

    private Button scoreRocketLeftFarSideHatchExpandOptionsBtn;
    private Button scoreRocketLeftMidSideCargoExpandOptionsBtn;
    private Button scoreRocketLeftNearSideHatchExpandOptionsBtn;

    private Button pickupLooseHatchBtn;
    private Button pickupLooseCargoBtn;
    private Button dropGamePieceBtn;

    private ScrollView rocketFarHatchScrollView;
    private ScrollView rocketMidCargoScrollView;
    private ScrollView rocketCloseHatchScrollView;

    private Button defendedBtn;

    ArrayList<Button> pickupBtns = new ArrayList<Button>(Arrays.asList(pickupHpLeftHatchBtn,pickupHpLeftCargoBtn,
                                                                       pickupHpRightHatchBtn,pickupHpRightCargoBtn,
                                                                       pickupCargoBayLeftBtn,pickupCargoBayRightBtn,
                                                                       pickupLooseHatchBtn,pickupLooseCargoBtn));

    ArrayList<Button> scoreBtns = new ArrayList<Button>(Arrays.asList(scoreBusLeftFarBtn,scoreBusLeftMiddleBtn,
            scoreBusLeftCloseBtn,scoreBusRightFarBtn,
            scoreBusRightMiddleBtn,scoreBusRightCloseBtn,
            scoreBusFrontSideLeftBtn,scoreBusFrontSideRightBtn,
            scoreRocketRightFarSideHatchLowBtn,scoreRocketRightFarSideHatchMidBtn,
            scoreRocketRightFarSideHatchHighBtn,scoreRocketRightMidSideCargoLowBtn,
            scoreRocketRightMidSideCargoMidBtn,scoreRocketRightMidSideCargoHighBtn,
            scoreRocketRightNearSideHatchLowBtn,scoreRocketRightNearSideHatchMidBtn,
            scoreRocketRightNearSideHatchHighBtn,scoreRocketLeftFarSideHatchLowBtn,scoreRocketLeftFarSideHatchMidBtn,
            scoreRocketLeftFarSideHatchHighBtn,scoreRocketLeftMidSideCargoLowBtn,
            scoreRocketLeftMidSideCargoMidBtn,scoreRocketLeftMidSideCargoHighBtn,
            scoreRocketLeftNearSideHatchLowBtn,scoreRocketLeftNearSideHatchMidBtn,
            scoreRocketLeftNearSideHatchHighBtn));

    ArrayList<Button> scoreRocketRightFarSideHatchBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketRightFarSideHatchLowBtn,
            scoreRocketRightFarSideHatchMidBtn,
            scoreRocketRightFarSideHatchHighBtn));

    ArrayList<Button> scoreRocketRightMidSideCargoBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketRightMidSideCargoLowBtn,
            scoreRocketRightMidSideCargoMidBtn,
            scoreRocketRightMidSideCargoHighBtn));

    ArrayList<Button> scoreRocketRightNearSideHatchBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketRightNearSideHatchLowBtn,
            scoreRocketRightNearSideHatchMidBtn,
            scoreRocketRightNearSideHatchHighBtn));


    ArrayList<Button> scoreRocketLeftFarSideHatchBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketLeftFarSideHatchLowBtn,
            scoreRocketLeftFarSideHatchMidBtn,
            scoreRocketLeftFarSideHatchHighBtn));

    ArrayList<Button> scoreRocketLeftMidSideCargoBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketLeftMidSideCargoLowBtn,
            scoreRocketLeftMidSideCargoMidBtn,
            scoreRocketLeftMidSideCargoHighBtn));

    ArrayList<Button> scoreRocketLeftNearSideHatchBtns = new ArrayList<Button>(Arrays.asList(
            scoreRocketLeftNearSideHatchLowBtn,
            scoreRocketLeftNearSideHatchMidBtn,
            scoreRocketLeftNearSideHatchHighBtn));


    ArrayList<Button> scoreRocketExpandBtns = new ArrayList<Button>(Arrays.asList(scoreRocketRightFarSideHatchExpandOptionsBtn,
            scoreRocketRightMidSideCargoExpandOptionsBtn,
            scoreRocketRightNearSideHatchExpandOptionsBtn,
            scoreRocketLeftFarSideHatchExpandOptionsBtn,
            scoreRocketLeftMidSideCargoExpandOptionsBtn,
            scoreRocketLeftNearSideHatchExpandOptionsBtn));

    ArrayList<ScrollView> scoreScrolls = new ArrayList<ScrollView>(Arrays.asList(rocketFarHatchScrollView,rocketMidCargoScrollView,rocketCloseHatchScrollView));

    ArrayList<Button> dropBtns = new ArrayList<Button>(Arrays.asList(dropGamePieceBtn));

    ArrayList<Button> crossBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn,crossPickupCargoBtn,crossPickupHatchBtn));

    ArrayList<Button> crossDropBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn));

    ArrayList<Button> defendedBtns = new ArrayList<Button>(Arrays.asList(defendedBtn));

    ArrayList<Button> allBtns;
    ArrayList<ArrayList> scoreListOfRocketBtns = new ArrayList<ArrayList>(Arrays.asList(scoreRocketLeftFarSideHatchBtns,scoreRocketLeftMidSideCargoBtns,scoreRocketLeftNearSideHatchBtns,
            scoreRocketRightFarSideHatchBtns,scoreRocketRightMidSideCargoBtns,scoreRocketRightNearSideHatchBtns));
    ArrayList<Button> scoreRocketBtns = new ArrayList<>(Arrays.asList(scoreRocketRightFarSideHatchLowBtn,scoreRocketRightFarSideHatchMidBtn,
            scoreRocketRightFarSideHatchHighBtn,scoreRocketRightMidSideCargoLowBtn,
            scoreRocketRightMidSideCargoMidBtn,scoreRocketRightMidSideCargoHighBtn,
            scoreRocketRightNearSideHatchLowBtn,scoreRocketRightNearSideHatchMidBtn,
            scoreRocketRightNearSideHatchHighBtn,scoreRocketLeftFarSideHatchLowBtn,scoreRocketLeftFarSideHatchMidBtn,
            scoreRocketLeftFarSideHatchHighBtn,scoreRocketLeftMidSideCargoLowBtn,
            scoreRocketLeftMidSideCargoMidBtn,scoreRocketLeftMidSideCargoHighBtn,
            scoreRocketLeftNearSideHatchLowBtn,scoreRocketLeftNearSideHatchMidBtn,
            scoreRocketLeftNearSideHatchHighBtn));



    ArrayList<Button> crossPickupBtns = new ArrayList<Button>(Arrays.asList(crossPickupHatchBtn,crossPickupCargoBtn));
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

         gameStart  = false;
         rocketExpandBtnsClicked = false;
         cycleNum = 0;
         //pickedUpPiece = ?


        matchImage = (ImageView) view.findViewById(R.id.matchplay_field_image);
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

        scoreRocketRightFarSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_low_hatch_btn);
        scoreRocketRightFarSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_mid_hatch_btn);
        scoreRocketRightFarSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_high_hatch_btn);

        scoreRocketRightMidSideCargoLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_low_btn);
        scoreRocketRightMidSideCargoMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_mid_btn);
        scoreRocketRightMidSideCargoHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_high_btn);

        scoreRocketRightNearSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_low_hatch_btn);
        scoreRocketRightNearSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_mid_hatch_btn);
        scoreRocketRightNearSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_high_hatch_btn);

        scoreRocketLeftFarSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_far_low_hatch_btn);
        scoreRocketLeftFarSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_far_mid_hatch_btn);
        scoreRocketLeftFarSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_far_high_hatch_btn);

        scoreRocketLeftMidSideCargoLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_mid_cargo_low_btn);
        scoreRocketLeftMidSideCargoMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_mid_cargo_mid_btn);
        scoreRocketLeftMidSideCargoHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_mid_cargo_high_btn);

        scoreRocketLeftNearSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_near_low_hatch_btn);
        scoreRocketLeftNearSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_near_mid_hatch_btn);
        scoreRocketLeftNearSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_near_high_hatch_btn);



        scoreRocketLeftFarSideHatchExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_far_hatch_expandOptions_btn);
        scoreRocketLeftMidSideCargoExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_mid_cargo_expandOptions_btn);
        scoreRocketLeftNearSideHatchExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_left_near_hatch_expandOptions_btn);

        scoreRocketRightFarSideHatchExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_hatch_expandOptions_btn);
        scoreRocketRightMidSideCargoExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_expandOptions_btn);
        scoreRocketRightNearSideHatchExpandOptionsBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_hatch_expandOptions_btn);

        pickupLooseHatchBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_hatch_btn);
        pickupLooseCargoBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_cargo_btn);
        dropGamePieceBtn = (Button) view.findViewById(R.id.matchplay_drop_alliance_side_btn);

        defendedBtn = (Button) view.findViewById(R.id.matchplay_defended_btn);



        pickupBtns = new ArrayList<Button>( Arrays.asList(
                pickupHpLeftHatchBtn,pickupHpRightHatchBtn,pickupLooseHatchBtn,crossPickupHatchBtn,
                pickupHpRightCargoBtn,pickupCargoBayLeftBtn,pickupCargoBayRightBtn,pickupLooseCargoBtn,crossPickupCargoBtn,pickupHpLeftCargoBtn));


       scoreBtns = new ArrayList<Button>(Arrays.asList(scoreBusLeftFarBtn,scoreBusLeftMiddleBtn,
                scoreBusLeftCloseBtn,scoreBusRightFarBtn,
                scoreBusRightMiddleBtn,scoreBusRightCloseBtn,
                scoreBusFrontSideLeftBtn,scoreBusFrontSideRightBtn
                ));
       scoreRocketBtns = new ArrayList<>(Arrays.asList(
               scoreRocketRightFarSideHatchLowBtn,scoreRocketRightFarSideHatchMidBtn,scoreRocketRightFarSideHatchHighBtn,
               scoreRocketRightMidSideCargoLowBtn,scoreRocketRightMidSideCargoMidBtn,scoreRocketRightMidSideCargoHighBtn,
               scoreRocketRightNearSideHatchLowBtn,scoreRocketRightNearSideHatchMidBtn,scoreRocketRightNearSideHatchHighBtn,
               scoreRocketLeftFarSideHatchLowBtn,scoreRocketLeftFarSideHatchMidBtn,scoreRocketLeftFarSideHatchHighBtn,
               scoreRocketLeftMidSideCargoLowBtn,scoreRocketLeftMidSideCargoMidBtn,scoreRocketLeftMidSideCargoHighBtn,
               scoreRocketLeftNearSideHatchLowBtn,scoreRocketLeftNearSideHatchMidBtn,scoreRocketLeftNearSideHatchHighBtn));

         scoreRocketRightFarSideHatchBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketRightFarSideHatchLowBtn,
                scoreRocketRightFarSideHatchMidBtn,
                scoreRocketRightFarSideHatchHighBtn));

       scoreRocketRightMidSideCargoBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketRightMidSideCargoLowBtn,
                scoreRocketRightMidSideCargoMidBtn,
                scoreRocketRightMidSideCargoHighBtn));

         scoreRocketRightNearSideHatchBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketRightNearSideHatchLowBtn,
                scoreRocketRightNearSideHatchMidBtn,
                scoreRocketRightNearSideHatchHighBtn));


        scoreRocketLeftFarSideHatchBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketLeftFarSideHatchLowBtn,
                scoreRocketLeftFarSideHatchMidBtn,
                scoreRocketLeftFarSideHatchHighBtn));

         scoreRocketLeftMidSideCargoBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketLeftMidSideCargoLowBtn,
                scoreRocketLeftMidSideCargoMidBtn,
                scoreRocketLeftMidSideCargoHighBtn));

         scoreRocketLeftNearSideHatchBtns = new ArrayList<Button>(Arrays.asList(
                scoreRocketLeftNearSideHatchLowBtn,
                scoreRocketLeftNearSideHatchMidBtn,
                scoreRocketLeftNearSideHatchHighBtn));

        scoreRocketExpandBtns = new ArrayList<Button>(Arrays.asList(scoreRocketLeftFarSideHatchExpandOptionsBtn,
                scoreRocketLeftMidSideCargoExpandOptionsBtn,
                scoreRocketLeftNearSideHatchExpandOptionsBtn,
                scoreRocketRightFarSideHatchExpandOptionsBtn,
                scoreRocketRightMidSideCargoExpandOptionsBtn,
                scoreRocketRightNearSideHatchExpandOptionsBtn));

         scoreListOfRocketBtns = new ArrayList<ArrayList>(Arrays.asList(scoreRocketLeftFarSideHatchBtns,scoreRocketLeftMidSideCargoBtns,scoreRocketLeftNearSideHatchBtns,
                scoreRocketRightFarSideHatchBtns,scoreRocketRightMidSideCargoBtns,scoreRocketRightNearSideHatchBtns));

         scoreScrolls = new ArrayList<ScrollView>(Arrays.asList(rocketFarHatchScrollView,rocketMidCargoScrollView,rocketCloseHatchScrollView));

         dropBtns = new ArrayList<Button>(Arrays.asList(dropGamePieceBtn,crossDropGamePieceBtn));

         crossBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn,crossPickupCargoBtn,crossPickupHatchBtn));

        crossPickupBtns = new ArrayList<Button>(Arrays.asList(crossPickupHatchBtn,crossPickupCargoBtn));

        crossDropBtns = new ArrayList<Button>(Arrays.asList(crossDropGamePieceBtn));

        defendedBtns = new ArrayList<Button>(Arrays.asList(defendedBtn));

        cycles = new ArrayList<Cycle>();

        teleops1 = new ArrayList<Teleop>();




        Log.e("BTN ID", getBtnIds(view,scoreRocketRightFarSideHatchLowBtn));








        if(MainActivity.globalSubmitMatch.getAuto().getAutoPreload() == '1'){
            hasPiece = true;
            decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
            makeBtnsInvisible(pickupBtns);
            //Log.e("STATE","ITS GETTING HERE");
            makeBtnsInvisible(crossBtns);
            makeBtnsInvisible(crossPickupBtns);
            makeBtnsInvisible(crossDropBtns);
            Log.e("DEFEND BTN VISIBILITY", "YEET");
            makeBtnsVisible(defendedBtns);
        }
        else{
            hasPiece = false;
            decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
            makeRocketBtnsInvisible();
            makeBtnsInvisible(scoreBtns);
            makeBtnsInvisible(dropBtns);
            makeBtnsInvisible(crossPickupBtns);
            makeBtnsInvisible(scoreRocketExpandBtns);
        }

        for (int i = 0; i < scoreListOfRocketBtns.size(); i++){
            int copyOfI = i;
            //ArrayList<ArrayList> test = scoreListOfRocketBtns.get(i);
            makeBtnsInvisible(scoreListOfRocketBtns.get(i));
        }
        Log.e("BIT", "CH");
        if( MainActivity.startBtnPressed){
            startMatchBtn.setVisibility(View.INVISIBLE);
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

                    c.setPickUp(getBtnIds(v,pickupBtns.get(copyOfi)));
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
                    makeRocketBtnsInvisible();
                    c.setCycleNumber(cycleNum);
                    //char test = findPickupPiece(copyOfi);
                    c.setFieldElement(findPickupPiece(copyOfi));
                    c.setPickupTime((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
                    Log.e("pickup time:", c.getPickupTime()+"");
                   // MainActivity.globalSubmitMatch.getCycleArrayList().add(c);
                    rocketExpandBtnsClicked = false;

                }
            });
        }

        for(int i = 0; i < scoreBtns.size();i++){
            final int copyOfi = i;
            scoreBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(cycleNum == 0 && MainActivity.globalSubmitMatch.getAuto().getAutoPreload() =='1'&& CycleHelper.TimeHepler.getElapsedTimeSecs()<=15 )
                    {
                        c.setFieldElement(MainActivity.globalSubmitMatch.getAuto().getStartingObj());
                        c.setPickUp("Preload from auto");

                    }
                    //else if( cycleNum == 0 && MainActivity.globalSubmitMatch.getAuto().getAutoPreload() =="1")

                    c.setPlace(getBtnIds(v,scoreBtns.get(copyOfi)));
                    c.setDropoffTime((int) CycleHelper.TimeHepler.getElapsedTimeSecs());
                    Log.e("Dropoff time", c.getDropoffTime()+"");
                    c.setDrop(false);
                    hasPiece= false;
                    cycles.add(c);
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
                    makeRocketBtnsInvisible();
                    rocketExpandBtnsClicked = false;
                }
            });
        }
        matchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRocketBtnsInvisible();
                if(hasPiece && !hasCrossed){
                    makeBtnsVisible(scoreRocketExpandBtns);
                }



            }
        });
        for(int i = 0; i < scoreRocketExpandBtns.size();i++){
            final int copyOfi = i;
            final ArrayList<Button> sizeOfRocketBtnsForEachList = scoreListOfRocketBtns.get(i);
            scoreRocketExpandBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //scoreRocketExpandBtns.get(copyOfi).setVisibility(View.INVISIBLE);
                    rocketExpandBtnsClicked = true;
                    for(int j = 0; j<sizeOfRocketBtnsForEachList.size(); j++){
                        ArrayList<Button> rocketBtnIndex = scoreListOfRocketBtns.get(copyOfi);
                        rocketBtnIndex.get(j).setVisibility(View.VISIBLE);

                    }

                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
                    rocketExpandBtnsClicked = false;
                   // makeRocketBtnsInvisible();

                }
            });
        }

        for(int i = 0; i < scoreRocketBtns.size();i++){
            final int copyOfi = i;
            scoreRocketBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(cycleNum == 0 && MainActivity.globalSubmitMatch.getAuto().getAutoPreload() =='1'&& CycleHelper.TimeHepler.getElapsedTimeSecs()<=15 )
                    {
                        c.setFieldElement(MainActivity.globalSubmitMatch.getAuto().getStartingObj());
                        c.setPickUp("Preload from auto");

                    }
                    //else if( cycleNum == 0 && MainActivity.globalSubmitMatch.getAuto().getAutoPreload() =="1")

                    c.setPlace(getBtnIds(v,scoreRocketBtns.get(copyOfi)));
                    c.setDropoffTime((int) CycleHelper.TimeHepler.getElapsedTimeSecs());
                    Log.e("Dropoff time", c.getDropoffTime()+"");
                    c.setDrop(false);
                    hasPiece= false;
                    cycles.add(c);
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
                    makeRocketBtnsInvisible();
                    rocketExpandBtnsClicked = false;
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
                    decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns,defendedBtns);
                    makeRocketBtnsInvisible();
                }
            });
        }


        for(int i = 0; i < defendedBtns.size();i++){
            //Dumb way but it works to YEET
            final int copyOfi = i;
            defendedBtns.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c.setDefense(true);

                }
            });
        }


        crossFieldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t = new Teleop();
                crossNum ++;
                hasCrossed = isCrossed(crossNum);
                t.setTimeCrosses((int)CycleHelper.TimeHepler.getElapsedTimeSecs());
                teleops1.add(t);
                decideVisiblilites(crossBtns,  pickupBtns,  scoreBtns,  dropBtns,scoreScrolls, crossDropBtns,crossPickupBtns, defendedBtns);
                makeRocketBtnsInvisible();
                Log.e("CROSSED VALUE", crossNum+"" + "hasCrossed: " + hasCrossed);
            }
        });



        startMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMatchBtn.setVisibility(View.INVISIBLE);
                CycleHelper.TimeHepler.start();
                startMatchBtn.getVisibility();
                MainActivity.startBtnPressed = true;

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
            //System.out.println(toMakeInvisible.get(i).getId());
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

    public void makeRocketBtnsInvisible(){
        for(int i = 0; i < this.scoreListOfRocketBtns.size();i++){
            for(int j = 0; j< this.scoreListOfRocketBtns.get(i).size(); j++){
                ArrayList<Button> test = scoreListOfRocketBtns.get(i);
                test.get(j).setVisibility(View.INVISIBLE);
            }
        }
    }
    public void decideVisiblilites(ArrayList<Button> crossBtns1, ArrayList<Button> pickupBtns1,
                                   ArrayList<Button> scoreBtns1, ArrayList<Button> dropBtns1,
                                   ArrayList<ScrollView> scoreScrolls1, ArrayList<Button> crossDropBtns1,
                                   ArrayList<Button> crossPickupBtns1, ArrayList<Button> defendedBtns1){
        setRocketBtnsVisibility(this.scoreRocketExpandBtns);
        if(hasCrossed == true){

            if(hasPiece == true){
                makeBtnsInvisible(pickupBtns1);
                makeBtnsInvisible(scoreBtns1);
//            makeScrollViewInvisible(scoreScrolls1);
                makeBtnsInvisible(dropBtns1);
                makeBtnsVisible(crossDropBtns1);
                makeBtnsInvisible(crossPickupBtns1);
            }
            else{
                makeBtnsInvisible(pickupBtns1);
                makeBtnsInvisible(scoreBtns1);
//            makeScrollViewInvisible(scoreScrolls1);
                makeBtnsInvisible(dropBtns1);
                makeBtnsVisible(crossPickupBtns1);
                makeBtnsInvisible(crossDropBtns1);

            }
            makeBtnsInvisible(defendedBtns1);
            crossFieldBtn.setText("Cross back");
        }
        else if (hasCrossed== false)
    {
        crossFieldBtn.setText("Cross");


            if(hasPiece == true){
                makeBtnsVisible(scoreBtns1);
                makeBtnsVisible(scoreRocketExpandBtns);
               // makeScrollViewVisible(scoreScrolls1);
                makeBtnsVisible(dropBtns1);
                makeBtnsInvisible(pickupBtns1);
                makeBtnsVisible(dropBtns1);
                makeBtnsVisible(defendedBtns1);
                if(rocketExpandBtnsClicked == true){
                    makeBtnsInvisible(this.scoreRocketExpandBtns);
                }
                else if (rocketExpandBtnsClicked == false){
                    makeBtnsVisible(this.scoreRocketExpandBtns);
                }
            }
            else {
                makeBtnsInvisible(this.scoreRocketExpandBtns);
                makeBtnsVisible(pickupBtns1);
                makeBtnsInvisible(scoreBtns1);
                makeBtnsInvisible(dropBtns1);
                makeBtnsInvisible(defendedBtns1);

            }
        makeBtnsInvisible(crossBtns1);

        }
    }

    public void setRocketBtnsVisibility(ArrayList<Button> scoreRocketExpandBtns1)
    {
        if(hasCrossed){
           makeBtnsInvisible(scoreRocketExpandBtns1);
             }
             else if (!hasCrossed){
                 if (hasPiece){
                     makeBtnsVisible(scoreRocketExpandBtns1);
                 }
                 else if(!hasPiece){
                     makeBtnsInvisible(scoreRocketExpandBtns1);
                 }
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
        MainActivity.globalSubmitMatch.setTeleopsList(teleops1);
        Log.e("TEST", MainActivity.globalSubmitMatch.getAuto().getAutoPreload()+"");
        Log.e("AUTO PRELOAD", MainActivity.globalSubmitMatch.getAuto().getStartingObj() +"");
        Log.e("AUTO LEVEL", MainActivity.globalSubmitMatch.getAuto().getAutoLvl() +"");

        super.onDestroy();
    }

}


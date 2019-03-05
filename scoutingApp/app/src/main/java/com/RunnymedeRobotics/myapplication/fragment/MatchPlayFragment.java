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

public class MatchPlayFragment extends BasicFragment {
    private int layout;

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
    private Button scoreRocketFarSideHatchhighBtn;

    private Button scoreRocketMidSideCargoLowBtn;
    private Button scoreRocketMidSideCargoMidBtn;
    private Button scoreRocketMidSideCargohighBtn;

    private Button scoreRocketNearSideHatchLowBtn;
    private Button scoreRocketNearSideHatchMidBtn;
    private Button scoreRocketNearSideHatchHighBtn;

    private Button pickupLooseHatchBtn;
    private Button pickupLooseCargoBtn;
    private Button dropGamePieceBtn;


    public MatchPlayFragment() {
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

        startMatchBtn = (Button) view.findViewById(R.id.matchplay_start_match_btn);

        crossPickupHatchBtn = (Button) view.findViewById(R.id.matchplay_cross_hatch_pickup_btn);
        crossPickupCargoBtn = (Button) view.findViewById(R.id.matchplay_cross_cargo_pickup_btn);
        //crossDropGamePieceBtn = (Button) view.findViewById(R.id.mat);
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
        scoreRocketFarSideHatchhighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_far_high_hatch_btn);

        scoreRocketMidSideCargoLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_low_btn);
        scoreRocketMidSideCargoMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_mid_btn);
        scoreRocketMidSideCargohighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_mid_cargo_high_btn);

        scoreRocketNearSideHatchLowBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_low_hatch_btn);
        scoreRocketNearSideHatchMidBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_mid_hatch_btn);
        scoreRocketNearSideHatchHighBtn = (Button) view.findViewById(R.id.matchplay_rocket_right_near_high_hatch_btn);

        pickupLooseHatchBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_hatch_btn);
        pickupLooseCargoBtn = (Button) view.findViewById(R.id.matchplay_pickup_freeplay_cargo_btn);
        dropGamePieceBtn = (Button) view.findViewById(R.id.matchplay_drop_alliance_side_btn);

        startMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMatchBtn.setVisibility(View.GONE);
                Log.e("STATE","GP");
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
}


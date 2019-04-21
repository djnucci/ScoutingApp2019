package com.RunnymedeRobotics.myapplication.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.RunnymedeRobotics.myapplication.MainActivity;
import com.RunnymedeRobotics.myapplication.R;
import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.Match;

import java.util.ArrayList;



public class MatchesFragment extends BasicFragment {

    TableLayout tableLayout;
    TextView[][] textViews = new TextView[MainActivity.matchLists.getMatchArrayList().size()][7];
    EditText editText;
    LayoutInflater inflater1;



    private int layout;

    public MatchesFragment() {
    }

    @SuppressLint("ValidFragment")
    public MatchesFragment(int layout) {
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(this.layout, container, false);

        tableLayout = (TableLayout) view.findViewById(R.id.matches_table_layout);
        editText = (EditText) view.findViewById(R.id.team_number_edit_text);








        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        ArrayList<Match> matchArrayList = MainActivity.matchLists.getMatchArrayList();

       if (!matchArrayList.isEmpty()) {
            Log.e("Not Empty : ", "true");
            for (int i = 0; i < matchArrayList.size(); i++) {
                for (int a = 0; a < 6; a++) {
                    textViews[i][a] = (new TextView(getActivity()));
                    textViews[i][a].setWidth(100);
                    textViews[i][a].setLayoutParams(lp);
                    if(a == 0){
                        textViews[i][a].setText(String.valueOf(matchArrayList.get(i).getMatchNum()));

                    }
                    else {
                        textViews[i][a].setText(String.valueOf(matchArrayList.get(i).getTeam(a + 1)));
                        if(a < 3){
                            textViews[i][a].setTextColor(Color.parseColor("RED"));
                        }
                        else {
                            textViews[i][a].setTextColor(Color.parseColor("BLUE"));
                        }
                    }
                }
            }



        }
        else {

        }





        int[] tableRowId = {R.id.row_1,R.id.row_2,R.id.row_3,R.id.row_4,R.id.row_5,R.id.row_6};

        for (int a = 0; a < 6; a++) {

            TableRow row = (TableRow) view.findViewById(tableRowId[a]);
            row.setLayoutParams(lp);
            for(int i = 0; i < matchArrayList.size() ; i++){

              //  row.addView(textViews[a][i]);
            }
           // tableLayout.addView(row);
        }


        return view;

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }


}

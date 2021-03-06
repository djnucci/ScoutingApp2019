package com.RunnymedeRobotics.myapplication;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.RunnymedeRobotics.myapplication.datastructureclasses.schedule.MatchLists;
import com.RunnymedeRobotics.myapplication.datastructureclasses.SubmitMatch;
import com.RunnymedeRobotics.myapplication.filehandler.InflateSchedule;
import com.RunnymedeRobotics.myapplication.fragment.BasicFragment;
import com.RunnymedeRobotics.myapplication.fragment.EndGameFragment;
import com.RunnymedeRobotics.myapplication.fragment.InitInfoFragment;
import com.RunnymedeRobotics.myapplication.fragment.MatchPlayFragment;
import com.RunnymedeRobotics.myapplication.fragment.SettingsFragment;
import com.RunnymedeRobotics.myapplication.fragment.SetupFragment;
import com.RunnymedeRobotics.myapplication.fragment.SyncDataFragment;
import com.RunnymedeRobotics.myapplication.jsonqueue.JsonWrapper;
import com.RunnymedeRobotics.myapplication.jsonqueue.QueueWrapper;
import com.google.gson.Gson;

import java.util.Set;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    public static SubmitMatch globalSubmitMatch = new SubmitMatch();
    public static MatchLists matchLists;
    public static QueueWrapper queueWrapper = new QueueWrapper();
    //[startLvl, startObj]
    public static char[] keepFromSetup = new char[2];
    public static boolean hasPreloadAndSetupLvlSelected = false;
    public static boolean startBtnPressed = false;


    private int currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BasicFragment(R.layout.app_bar_main)).commit();
            navigationView.setCheckedItem(R.id.nav_main_page);
        }
        if( Build.VERSION.SDK_INT >= 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
        }


       startupPorcedure();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            switch (currentLayout){
                case R.layout.stats:
                    break;
                case R.layout.transfer:
                    break;
                case R.layout.schedule:
                    navigationView.setCheckedItem(R.id.nav_main_page);
                    break;
            }

            switch (currentLayout){
                case R.layout.stats:
                case R.layout.transfer:
                case R.layout.schedule:
                    int layout = R.layout.app_bar_main;
                    switchBasicFrag(layout);
                    break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        int layout;

        switch (id){
            case R.id.nav_main_page:
                layout = R.layout.app_bar_main;
                switchBasicFrag(layout);
                break;
            case R.id.nav_schedule:
                layout = R.layout.schedule;
                switchBasicFrag(layout);
                break;
            case R.id.nav_file_transfer:
                layout = R.layout.transfer;
                switchBasicFrag(layout,new SyncDataFragment(layout));
                break;
            case R.id.nav_scouting:
                layout = R.layout.scouting_start_page;
                switchBasicFrag(layout, new InitInfoFragment(layout));
                break;
            case R.id.nav_stats:
                layout = R.layout.stats;
                switchBasicFrag(layout);
                break;
            case R.id.nav_settings:
                layout = R.layout.settings_fragment;
                switchBasicFrag(layout,new SettingsFragment(layout));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchBasicFrag(int layout){
        Fragment f = new BasicFragment(layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
        currentLayout = layout;
        //YEEET
    }

    public void switchBasicFrag(int layout, Fragment fragment){
        Fragment f = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
        currentLayout = layout;
    }

    public void switchScoutingTab(View button){
        Log.e("Tab Init","True");
        int layout;
        switch (button.getId()){
            case R.id.scouting_start_setup:
            case R.id.scouting_setup_setup:
            case R.id.scouting_match_setup:
            case R.id.scouting_endgame_setup:
                layout = R.layout.scouting_setup;
                switchBasicFrag(layout, new SetupFragment(layout));
                break;
            case R.id.scouting_setup_match:
                if(hasPreloadAndSetupLvlSelected){
                    layout = R.layout.scouting_match_play;
                    switchBasicFrag(layout,new MatchPlayFragment(layout));
                    break;
                }
                else {
                    break;
                }
            case R.id.scouting_match_match:
                layout = R.layout.scouting_match_play;
                switchBasicFrag(layout,new MatchPlayFragment(layout));
                break;
            case R.id.scouting_endgame_match:
                layout = R.layout.scouting_match_play;
                switchBasicFrag(layout);
                break;
            case R.id.scouting_setup_endgame:
            case R.id.scouting_match_endgame:
            case R.id.scouting_endgame_endgame:
                layout = R.layout.scouting_endgame;
                switchBasicFrag(layout, new EndGameFragment(layout));
                break;
        }

    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public static Context getContext(){
        return getContext();
    }

    public void startupPorcedure(){
        SettingsFragment.updateSettings(this);
        matchLists = InflateSchedule.inflateSchedule(this);
        MainActivity.queueWrapper = JsonWrapper.getQueueDataFromFile(this);
        if(MainActivity.queueWrapper == null){
            queueWrapper= new QueueWrapper();
        }
        else {
            Log.e("Queue Wrapper Status" , queueWrapper.getSubmitMatchArrayList().size()+"");
        }
    }

    public static void makeToast(String toasString, Context context){
        Toast.makeText(context,toasString,Toast.LENGTH_LONG).show();
    }

    public static void checkSettings(Context context){

    }

    public void setActionBar(String heading) {
        // TODO Auto-generated method stub

       ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setTitle(heading);
        actionBar.show();

    }


}

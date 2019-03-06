package com.RunnymedeRobotics.myapplication.fragment;

import com.RunnymedeRobotics.myapplication.datastructureclasses.Cycle;

import java.util.ArrayList;

public class CycleHelper {

    public static  ArrayList<Cycle> cycleArrayList = new ArrayList<>();

    public static class TimeHepler{

        private static long startTime = 0;
        private static boolean running = false;
        private static long currentTime = 0;

        public static void start() {
            TimeHepler.startTime = System.currentTimeMillis();
            TimeHepler.running = true;
        }

        public static void stop() {
            TimeHepler.running = false;
        }

        public static void pause() {
            TimeHepler.running = false;
            currentTime = System.currentTimeMillis() - startTime;
        }
        public static void resume() {
            TimeHepler.running = true;
            TimeHepler.startTime = System.currentTimeMillis() - currentTime;
        }

        //elaspsed time in milliseconds
        public static long getElapsedTimeMili() {
            long elapsed = 0;
            if (running) {
                elapsed =((System.currentTimeMillis() - startTime)/100) % 1000 ;
            }
            return elapsed;
        }

        //elaspsed time in seconds
        public static long getElapsedTimeSecs() {
            long elapsed = 0;
            if (running) {
                elapsed = ((System.currentTimeMillis() - startTime) / 1000);
            }
            return elapsed;
        }

    }


    public void addCycle(Cycle cycle){

        CycleHelper.cycleArrayList.add(cycle);
    }


    public Cycle getCycle(int id){
        return cycleArrayList.get(id);
    }


}

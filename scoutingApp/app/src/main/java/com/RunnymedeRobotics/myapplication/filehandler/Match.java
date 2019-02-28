package com.RunnymedeRobotics.myapplication.filehandler;

public class Match {
        private int r1;
        private int r2;
        private int r3;
        private int b1;
        private int b2;
        private int b3;
        private int mathcNum;
        private  int test;


        public void match(int r1,int r2,int r3,int b1,int b2,int b3) {
            this.setR1(r1);
            this.setR2(r2);
            this.setR3(r3);
            this.setB1(b1);
            this.setB2(b2);
            this.setB3(b3);

        }


        public int getR1() {
            return r1;
        }


        public void setR1(int r1) {
            this.r1 = r1;
        }


        public int getR2() {
            return r2;
        }


        public void setR2(int r2) {
            this.r2 = r2;
        }


        public int getR3() {
            return r3;
        }


        public void setR3(int r3) {
            this.r3 = r3;
        }


        public int getB1() {
            return b1;
        }


        public void setB1(int b1) {
            this.b1 = b1;
        }


        public int getB2() {
            return b2;
        }


        public void setB2(int b2) {
            this.b2 = b2;
        }


        public int getB3() {
            return b3;
        }


        public void setB3(int b3) {
            this.b3 = b3;
        }


        public int getMathcNum() {
            return mathcNum;
        }


        public void setMathcNum(int mathcNum) {
            this.mathcNum = mathcNum;
        }

        public String toSttring(int r1,int r2,int r3,int b1,int b2,int b3, int matchNum) {
            return ("matchNum: " + matchNum + " r1: " + r1 + " r2: " + r2 +" r3: " + r3 +" b1: " + b2 +" b2: " + b2 +" b3: " + b3);
        }


    }

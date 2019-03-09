package com.RunnymedeRobotics.myapplication.datastructureclasses;

public class SubmittedFile {

    String fileName="";
    String comp = "";

    public SubmittedFile(){}

    public SubmittedFile(String fileName, String comp) {
        this.fileName = fileName;
        this.comp = comp;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }
}

package com.headfracturestudios.golfscorecard;


import android.os.Parcel;
import android.os.Parcelable;

public class Hole {
    private int mHoleNumber;
    private int mScore;

    @Override
    public String toString() {
        return String.valueOf(mScore);
    }

    public Hole(int holeNumber, int score){
        mHoleNumber = holeNumber;
        mScore = score;
    }

    public int getHoleNumber() {
        return mHoleNumber;
    }

    public void setHoleNumber(int holeNumber) {
        mHoleNumber = holeNumber;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public String getHoleString(int holeNumber){
        return ("Hole " + holeNumber + ":");
    }

    public int addScore(){
        return ++ mScore;
    }

    public int subtractScore(){
        return -- mScore;
    }


}

package com.celestial.myapplication;

import java.util.ArrayList;

public class Doctor {
    private String name;
   private int consultTime;
     private int nextAvailableTime = 0;

     private ArrayList<Patient> patients = new ArrayList<>();

    private boolean isConsulting = false;

    public Doctor(String name, int consultTime) {
        this.name = name;
        this.consultTime = consultTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(int consultTime) {
        this.consultTime = consultTime;
    }

    public void consultPatient() {
      //  timePass = timePass + consultTime;
        isConsulting = true;
    }


    public void consultPatient(Patient p){
        patients.add(p);
        nextAvailableTime = nextAvailableTime+consultTime;
       // timePass = timePass + consultTime;
      //  isConsulting = true;
    }

    public int getNextAvailableTime(){
        return nextAvailableTime;
    }

    public boolean isDoctorAvailable(){
        return !isConsulting;
    }

    public boolean isAvailableForThisTime(int time){
        return nextAvailableTime<=time;
    }

}

package com.celestial.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QueueAlgorithm {

    private ArrayList<Doctor> doctors;

    private ArrayList<Patient> patients;

    private int timeTaken = 0;

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public QueueAlgorithm(ArrayList<Doctor> doctors, ArrayList<Patient> patients) {
        this.doctors = doctors;
        this.patients = patients;

        findFastestDoctor();
    }

    public Doctor findFastestDoctor() {
        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor doctor, Doctor t1) {
                return doctor.getConsultTime() > t1.getConsultTime() ? 1 : -1;
            }
        });
        return doctors.get(0);
    }


    public int getWaitingTimeOfPatientAtPosition(int ptPos) {
        int patientPosition = 0;
        int waitingTime = 0;

        while (patientPosition < patients.size()) {
            for (Doctor d : doctors) {
                if (d.isAvailableForThisTime(timeTaken) && patientPosition<patients.size()) {
                    d.consultPatient(patients.get(patientPosition));
                  //  System.out.println("Waiting Time for patient : "+patients.get(patientPosition).getName()+" is "+timeTaken+" m");
                    if(patientPosition == ptPos-1){
                        print("Waiting Time for Position : "+ptPos+" is : "+timeTaken+" m");
                        return 0;
                    }
//                    if(ptPos == patientPosition-1){
//                        waitingTime = timeTaken;
//                        System.out.println("Waiting Time for patient : "+patients.get(patientPosition).getName()+" is "+timeTaken+" m");
//                        return 0;
//                    }

                    if(patientPosition<patients.size()){
                        patientPosition++;
                    }
                }
            }
            if(patientPosition<patients.size()){
                timeTaken++;
            }
        }


        return timeTaken;
    }

    private void queuePatientWithDoctor() {

    }

    private void print(String s){
        System.out.println(s);
    }


}

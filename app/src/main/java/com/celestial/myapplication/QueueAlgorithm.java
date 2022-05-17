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
                return doctor.getConsultTime()>t1.getConsultTime()? 1:-1;
            }
        });
        return doctors.get(0);
    }


    public int getWaitingTimeOfPatientAtPosition(int i) {
        int patientPosition = 0;
//           for(Doctor d: doctors){
//               if(d.isAvailableForThisTime(timeTaken)){
//                   d.consultPatient(patients.get(patientPosition));
//                   patientPosition++;
//               }
//           }

       while(patientPosition<patients.size()){
            for(Doctor d: doctors){
                if(d.isAvailableForThisTime(timeTaken)){
                    if(patientPosition == i-1){
                        System.out.println("Waiting time for patient no:" +i+" is "+timeTaken);
                    }
                    d.consultPatient(patients.get(patientPosition));

                    patientPosition++;
                }
            }



            timeTaken = timeTaken+1;
        }
        System.out.println("Waiting time: "+timeTaken);

        return timeTaken;
    }

    private void queuePatientWithDoctor(){

    }


}

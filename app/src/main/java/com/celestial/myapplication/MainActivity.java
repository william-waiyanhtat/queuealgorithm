package com.celestial.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private QueueAlgorithm queueAlgorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void populateData(){
        Doctor A = new Doctor("A",3);
        Doctor B = new Doctor("B",4);
        Doctor C = new Doctor("C",2);

        ArrayList<Doctor> doctorArrayList = new ArrayList<>();

        doctorArrayList.add(A);
        doctorArrayList.add(B);
        doctorArrayList.add(C);

        ArrayList<Patient> patientArrayList = new ArrayList<>();
        for(int i= 0;i<10;i++){
            Patient patient = new Patient("Patient "+ String.valueOf(i+1));
            patientArrayList.add(patient);
        }


        queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);

        int waitingTime =  queueAlgorithm.getWaitingTimeOfPatientAtPosition(3);
    }
}
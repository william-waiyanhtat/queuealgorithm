package com.celestial.myapplication;

import static org.junit.Assert.assertEquals;

import com.celestial.myapplication.algorithm.QueueAlgorithm;
import com.celestial.myapplication.model.Doctor;
import com.celestial.myapplication.model.Patient;

import org.junit.Test;

import java.util.ArrayList;

public class AlgorithmTest {
    @Test
    public void fastestDoctorTest() {
        Doctor A = new Doctor("A",3);
        Doctor B = new Doctor("B",4);
        Doctor C = new Doctor("C",2);

        ArrayList<Doctor> doctorArrayList = new ArrayList<>();

        doctorArrayList.add(A);
        doctorArrayList.add(B);
        doctorArrayList.add(C);
        doctorArrayList.add(new Doctor("D",5));
        doctorArrayList.add(new Doctor("E",1));
        doctorArrayList.add(new Doctor("F",3));

        ArrayList<Patient> patientArrayList = new ArrayList<>();
        for(int i= 0;i<10;i++){
            Patient patient = new Patient("Patient "+ String.valueOf(i+1));
            patientArrayList.add(patient);
        }

        QueueAlgorithm queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);


        Doctor d = queueAlgorithm.sortDoctors();

      //  System.out.println("Name: "+d.getName()+", Time: "+d.getConsultTime());

        for(Doctor doc : queueAlgorithm.getDoctors()){
            System.out.println("Name: "+doc.getName()+", Time: "+doc.getConsultTime());
        }

        assertEquals(d,C);
    }

    @Test
    public void consultingStatusTest(){
        Doctor d = new Doctor("D",4);

    //    d.consultPatient();

        assertEquals(d.isDoctorAvailable(),false);
    }

    @Test
    public void consultTimeTest(){
        Doctor a = new Doctor("A",3);
//        print("TimePass:"+a.timePass+"");
//        a.consultPatient();
//
//        print("TimePass:"+a.timePass+"");
        assertEquals(true,true);
    }

    @Test
    public void testNextAvailableTime(){
        Doctor a = new Doctor("A",3);
        a.consultPatient(new Patient("aa"));
     //   print("Next AvailableTime: "+a.getNextAvailableTime());

        a.consultPatient(new Patient("bb"));
    //    print("Next AvailableTime: "+a.getNextAvailableTime());

    //    assertEquals(a.getNextAvailableTime(), 6);


    }

    @Test
    public void testNextAvailableTimeWithTime(){
        Doctor a = new Doctor("A",3);
        a.consultPatient(new Patient("aa"));
      //  print("Next AvailableTime: "+a.getNextAvailableTime());

        print("Is Available For 3min : "+a.isAvailableForThisTime(3));
        print("Is Available For 4min : "+a.isAvailableForThisTime(4));

        a.consultPatient(new Patient("bb"));
      //  print("Next AvailableTime: "+a.getNextAvailableTime());

       // assertEquals(a.getNextAvailableTime(), 6);


    }


    @Test
    public void totalWaitingTime(){
        Doctor a = new Doctor("A",3);
        Doctor b = new Doctor("B",4);
        Doctor c = new Doctor("C",2);
        Doctor d = new Doctor("D",5);

        ArrayList<Doctor> doctorArrayList = new ArrayList<>();

        doctorArrayList.add(a);
        doctorArrayList.add(b);
        doctorArrayList.add(c);
        doctorArrayList.add(d);

        ArrayList<Patient> patientArrayList = new ArrayList<>();
        for(int i= 0;i<10;i++){
            Patient patient = new Patient("Patient "+ String.valueOf(i+1));
            patientArrayList.add(patient);
        }

        QueueAlgorithm queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);

        queueAlgorithm.getWaitingTimeOfPatientAtPosition(9);

        //assertEquals(a.getNextAvailableTime(), 6);


    }


    @Test
    public void totalWaitingTime1(){
        Doctor a = new Doctor("A",3);
        Doctor b = new Doctor("B",4);
//        Doctor c = new Doctor("C",2);
//        Doctor d = new Doctor("D",5);

        ArrayList<Doctor> doctorArrayList = new ArrayList<>();

        doctorArrayList.add(a);
        doctorArrayList.add(b);
//        doctorArrayList.add(c);
//        doctorArrayList.add(d);

        ArrayList<Patient> patientArrayList = new ArrayList<>();
        for(int i= 0;i<11;i++){
            Patient patient = new Patient("Patient "+ String.valueOf(i+1));
            patientArrayList.add(patient);
        }

        QueueAlgorithm queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);

        queueAlgorithm.getWaitingTimeOfPatientAtPosition(11);

     //   assertEquals(a.getNextAvailableTime(), 6);


    }

    private void print(String s){
        System.out.println(s);
    }
}

package com.celestial.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.celestial.myapplication.adapter.DoctorListAdapter;
import com.celestial.myapplication.algorithm.QueueAlgorithm;
import com.celestial.myapplication.model.Doctor;
import com.celestial.myapplication.model.Patient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private QueueAlgorithm queueAlgorithm;

    private EditText edtDocName;
    private EditText edtDocTime;
    private Button btnAdd;
    private Button btnClear;

    private RecyclerView recyclerView;

    private EditText edtNumOfPatient;
    private Button btnQueue;

    private EditText edtPatientNumber;
    private TextView tvResult;

    private Button btnCalculate;

    private DoctorListAdapter adapter;

    private ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        edtDocName = findViewById(R.id.edt_doc_name);
        edtDocTime = findViewById(R.id.edt_consult_time);

        btnAdd = findViewById(R.id.btn_add_doctor);

        btnClear = findViewById(R.id.btn_clear_doc);

        recyclerView = findViewById(R.id.rcy_doctor_list);

        adapter = new DoctorListAdapter();

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        edtNumOfPatient = findViewById(R.id.edt_num_of_patient);

        btnQueue = findViewById(R.id.btn_queue);

        edtPatientNumber = findViewById(R.id.edt_patient_number);

        btnCalculate = findViewById(R.id.btn_calculate);

        tvResult = findViewById(R.id.tv_waiting_time);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtDocName.getText().toString().isEmpty() &&
                !edtDocTime.getText().toString().isEmpty()){
                    doctorArrayList.add(new Doctor(edtDocName.getText().toString(),
                            Integer.parseInt(edtDocTime.getText().toString())));
                    adapter.setData(doctorArrayList);

                    edtDocTime.getText().clear();
                    edtDocName.getText().clear();
                }else{
                    Toast.makeText(MainActivity.this, "Input doctor name and consult time", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorArrayList.clear();
                adapter.clearData();
            }
        });

//        btnQueue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!edtNumOfPatient.getText().toString().isEmpty()){
//                    int patientCount = Integer.parseInt(edtNumOfPatient.getText().toString());
//                    ArrayList<Patient> patientArrayList = new ArrayList<>();
//
//                    for(int i = 0;i< patientCount;i++){
//                        patientArrayList.add(new Patient(String.valueOf(i)));
//                    }
//
//                    queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);
//
//
//                }else{
//                    Toast.makeText(MainActivity.this, "Input patient count", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtNumOfPatient.getText().toString().isEmpty()){
                    int patientCount = Integer.parseInt(edtNumOfPatient.getText().toString());
                    ArrayList<Patient> patientArrayList = new ArrayList<>();

                    for(int i = 0;i< patientCount;i++){
                        patientArrayList.add(new Patient(String.valueOf(i)));
                    }

                    queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);


                }else{
                    Toast.makeText(MainActivity.this, "Input patient count", Toast.LENGTH_SHORT).show();
                    tvResult.setText("Waiting Time: ");
                    return;
                }



                if(queueAlgorithm == null){
                    int patientCount = Integer.parseInt(edtNumOfPatient.getText().toString());
                    ArrayList<Patient> patientArrayList = new ArrayList<>();

                    for(int i = 0;i< patientCount;i++){
                        patientArrayList.add(new Patient(String.valueOf(i)));
                    }

                    if(doctorArrayList.isEmpty()){
                        Toast.makeText(MainActivity.this, "Doctor List is Empty", Toast.LENGTH_SHORT).show();
                       tvResult.setText("Waiting Time: ");
                        return;
                    }
                    
                    queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);
                }



                if(!edtPatientNumber.getText().toString().isEmpty()){
                    if(queueAlgorithm!=null){
                        int patientPosition = Integer.parseInt(edtPatientNumber.getText().toString());

                        if(patientPosition>queueAlgorithm.getPatients().size()){
                            Toast.makeText(MainActivity.this, "Patient position can't exceed patient count", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(!queueAlgorithm.getDoctors().isEmpty()){
                            int time = queueAlgorithm.getWaitingTimeOfPatientAtPosition(patientPosition);

                            tvResult.setText("Waiting time for patient number: "+patientPosition+ " is "+time+" min");
                        }else{
                            Toast.makeText(MainActivity.this, "Doctor list is empty", Toast.LENGTH_SHORT).show();
                            tvResult.setText("Waiting time: ");
                            return;
                        }
                       
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Input patient number", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

//    private void populateData(){
//        Doctor A = new Doctor("A",3);
//        Doctor B = new Doctor("B",4);
//        Doctor C = new Doctor("C",2);
//
//        ArrayList<Doctor> doctorArrayList = new ArrayList<>();
//
//        doctorArrayList.add(A);
//        doctorArrayList.add(B);
//        doctorArrayList.add(C);
//
//        ArrayList<Patient> patientArrayList = new ArrayList<>();
//        for(int i= 0;i<10;i++){
//            Patient patient = new Patient("Patient "+ String.valueOf(i+1));
//            patientArrayList.add(patient);
//        }
//
//
//        queueAlgorithm = new QueueAlgorithm(doctorArrayList,patientArrayList);
//
//        int waitingTime =  queueAlgorithm.getWaitingTimeOfPatientAtPosition(3);
//    }


}
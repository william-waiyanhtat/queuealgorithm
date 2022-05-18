package com.celestial.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.celestial.myapplication.model.Doctor;
import com.celestial.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.DoctorListViewHolder> {

    private ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    public void setData(List<Doctor> list){
        this.doctorArrayList.clear();
        this.doctorArrayList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(Doctor d){
        this.doctorArrayList.add(d);
        notifyDataSetChanged();
    }

    public void clearData(){
        doctorArrayList.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DoctorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_doctor_item, parent, false);

        DoctorListViewHolder vh = new DoctorListViewHolder(view);
        return vh;
    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorListViewHolder holder, int position) {
       holder.tvName.setText(doctorArrayList.get(position).getName());
       holder.tvConsultTime.setText(doctorArrayList.get(position).getConsultTime()+" min");
    }

    class DoctorListViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvConsultTime;


        public DoctorListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_doc_name);
            tvConsultTime = itemView.findViewById(R.id.tv_time);
        }
    }
}

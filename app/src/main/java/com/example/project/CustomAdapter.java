package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<Animal> animals;
    public CustomAdapter(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void updateAnimals(ArrayList<Animal> animals){ this.animals = animals;};

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Animal a = animals.get(position);
        holder.name.setText(a.getName());
        holder.location.setText(a.getLocation());
        holder.size.setText(a.getSize() + determineUnit(a) + " (avg)");
        holder.funFact.setText(a.getAuxdata());
    }

    public String determineUnit(Animal a){
        if(Integer.parseInt(a.getSize()) > 5){
            return "cm";
        }
        else{
            return "m";
        }
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView size;
        public TextView location;
        public TextView funFact;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            size = itemView.findViewById(R.id.size);
            location = itemView.findViewById(R.id.location);
            funFact = itemView.findViewById(R.id.funFact);
        }
    }
}

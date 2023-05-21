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
        holder.title.setText(a.getName());
        holder.kingdom.setText(a.getKingdom());
        holder.aclass.setText(a.getAclass());
        holder.order.setText(a.getOrder());
        holder.description.setText(a.getDescription());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView kingdom;
        public TextView aclass;
        public TextView order;
        public TextView family;
        public TextView description;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            kingdom = itemView.findViewById(R.id.kingdom);
            aclass = itemView.findViewById(R.id.aclass);
            order = itemView.findViewById(R.id.order);
            family = itemView.findViewById(R.id.family);
            description = itemView.findViewById(R.id.description);
        }
    }
}

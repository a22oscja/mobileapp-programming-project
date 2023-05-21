package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "";
    Gson gson = new Gson();
    RecyclerView recyclerView;
    ArrayList<Animal> animals = new ArrayList<Animal>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recView);
        customAdapter = new CustomAdapter(animals);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //new JsonTask(this).execute(JSON_URL);

        testingFunction();
    }

    public void testingFunction() {
        animals.add(new Animal("Elefant","Animalia","Mammalia","Proboscidea","Elephantidae","a\na\na\na\na\na\na\na\nb\nb\nb\nb\nb\n"));
        animals.add(new Animal("Elefant","Animalia","Mammalia","Proboscidea","Elephantidae","a\na\na\na\na\na\na\na\nb\nb\nb\nb\nb\n"));
        animals.add(new Animal("Elefant","Animalia","Mammalia","Proboscidea","Elephantidae","a\na\na\na\na\na\na\na\nb\nb\nb\nb\nb\n"));
        animals.add(new Animal("Elefant","Animalia","Mammalia","Proboscidea","Elephantidae","a\na\na\na\na\na\na\na\nb\nb\nb\nb\nb\n"));
        animals.add(new Animal("Elefant","Animalia","Mammalia","Proboscidea","Elephantidae","a\na\na\na\na\na\na\na\nb\nb\nb\nb\nb\n"));
        customAdapter.updateAnimals(animals);
        customAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPostExecute(String json) {
        Type type = new TypeToken<ArrayList<Animal>>() {}.getType();
        animals = gson.fromJson(json, type);
        customAdapter.updateAnimals(animals);
        customAdapter.notifyDataSetChanged();
    }
}

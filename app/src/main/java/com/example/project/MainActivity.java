package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener, View.OnClickListener {

    private final String JSON_URL = "";
    Gson gson = new Gson();
    RecyclerView recyclerView;
    ArrayList<Animal> animals = new ArrayList<Animal>();
    CustomAdapter customAdapter;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        recyclerView = findViewById(R.id.recView);
        customAdapter = new CustomAdapter(animals);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Type type = new TypeToken<ArrayList<Animal>>() {}.getType();
        animals = gson.fromJson(json, type);
        customAdapter.updateAnimals(animals);
        customAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
}

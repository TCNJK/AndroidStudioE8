package com.example.androidstudioe8;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Models.*;

public class Lab1RecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));

        animalList = new ArrayList<>();
        animalList.add(new Animal(1, "Lion", "The lion is a species in the family Felidae."));
        animalList.add(new Animal(2, "Tiger", "The tiger is the largest living cat species."));
        animalList.add(new Animal(3, "Elephant", "Elephants are largestthe largest existing land animals."));

        animalAdapter = new AnimalAdapter(animalList, this);
        recyclerView.setAdapter(animalAdapter);
    }
}
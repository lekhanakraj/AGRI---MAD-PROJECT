package com.example.agri;

import static android.graphics.Color.WHITE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class input extends AppCompatActivity {
    EditText etName;
    EditText etAge;
    Spinner spinner;
    Button btn,btn1;
DatabaseReference farmer;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        etName = findViewById(R.id.etname);
        etAge = findViewById(R.id.etRollno);
        spinner=findViewById(R.id.spinnerCourse);
        spinner.setBackgroundColor(WHITE);
        btn=findViewById(R.id.btn111);

        farmer = FirebaseDatabase.getInstance().getReference().child("Farmer");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFarmerData();
            }
        });



    }
    private void insertFarmerData(){
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String acre= spinner.getSelectedItem().toString();
        farmers farm= new farmers(name,age,acre);
        farmer.push().setValue(farm);
        Toast.makeText(input.this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}

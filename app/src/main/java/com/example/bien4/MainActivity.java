package com.example.bien4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    TextView Bien;
    ImageButton bt1;
    ImageButton bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bien = findViewById(R.id.Bien_fb);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        DatabaseReference Bien_fb = FirebaseDatabase.getInstance().getReference("Bien_fb");
        DatabaseReference bt_fb = FirebaseDatabase.getInstance().getReference("ON");
        Bien_fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Bien.setText(snapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_fb.setValue(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_fb.setValue(0);
            }
        });

            }
        }






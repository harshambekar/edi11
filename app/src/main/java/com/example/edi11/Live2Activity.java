package com.example.edi11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Live2Activity extends AppCompatActivity {

    private TextView dataTextView;
    private TextView dataTextView1;
    private DatabaseReference databaseRef;
    private DatabaseReference databaseRef1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live2);

        dataTextView = findViewById(R.id.dataTextView);
        dataTextView1=findViewById(R.id.dataTextView1);
        databaseRef = FirebaseDatabase.getInstance().getReference().child("smart_enrgy_stats").child("power");
        databaseRef1 = FirebaseDatabase.getInstance().getReference().child("smart_enrgy_stats").child("energy");
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Float voltage = dataSnapshot.getValue(Float.class);
                if (voltage != null) {
                    dataTextView.setText(String.valueOf(voltage));
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
        databaseRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Float consu = dataSnapshot.getValue(Float.class);
                if (consu != null) {
                    dataTextView1.setText(String.valueOf(consu));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }
}
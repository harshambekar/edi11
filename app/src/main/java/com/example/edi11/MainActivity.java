package com.example.edi11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edi11.viewmodel.PaymentActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut;
    Button btnLogOut3;
    Button btnLogOut4;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.btnLogout);
        btnLogOut3 = findViewById(R.id.btnLogout3);
        btnLogOut4 = findViewById(R.id.btnLogout4);



        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        });

        btnLogOut3.setOnClickListener(view ->{

            startActivity(new Intent(MainActivity.this, Live2Activity.class));

        });
        btnLogOut4.setOnClickListener(view ->{

            startActivity(new Intent(MainActivity.this, CheckoutActivity.class));

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}
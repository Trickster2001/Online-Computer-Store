package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class repair extends AppCompatActivity {
    EditText writeproblem,Name;
    Button submit, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        writeproblem=(EditText) findViewById(R.id.problem);
        Name=(EditText)findViewById(R.id.entername);
        submit=(Button) findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { probleminsert();}
        });
        back=(Button) findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backprocess();}
        });
    }

    private void backprocess() {
        startActivity(new Intent(getApplicationContext(),dashboard.class));
        finish();
    }

    private void probleminsert() {
        Map<String,Object> map=new HashMap<>();
        map.put("Customer Name",Name.getText().toString());
        map.put("Problem",writeproblem.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Repair").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Name.setText("");
                        writeproblem.setText("");
                        Toast.makeText(getApplicationContext(), "Inserted Successsfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Insertion Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
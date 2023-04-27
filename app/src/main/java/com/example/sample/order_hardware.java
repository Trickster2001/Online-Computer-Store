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

public class order_hardware extends AppCompatActivity {
    EditText prname,name,phone,address;
    Button order,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_hardware);
        prname=(EditText)findViewById(R.id.add_product_name);
        name= (EditText)findViewById(R.id.add_cust_name);
        phone= (EditText)findViewById(R.id.add_phone);
        address= (EditText)findViewById(R.id.add_address);

        back=(Button) findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),hardware.class));
                finish();
            }
        });

        order=(Button)findViewById(R.id.add_order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert();
            }
        });
    }

    private void processinsert() {
        Map<String, Object> map = new HashMap<>();
        map.put("Product Name", prname.getText().toString());
        map.put("Customer Name", name.getText().toString());
        map.put("Phone Number", phone.getText().toString());
        map.put("Delivery Address",address.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Order Hardware").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        prname.setText("");
                        name.setText("");
                        phone.setText("");
                        address.setText("");
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
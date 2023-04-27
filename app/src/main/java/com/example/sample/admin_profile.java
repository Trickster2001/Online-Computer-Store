package com.example.sample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class admin_profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView fullname,email,phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        drawerLayout=findViewById(R.id.drawer_layout);

        phone=findViewById(R.id.profile_phone);
        email=findViewById(R.id.profile_email);
        fullname=findViewById(R.id.profile_name);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        userId=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference=fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                phone.setText(value.getString("Phone"));
                fullname.setText(value.getString("FullName"));
                email.setText(value.getString("Email"));

            }
        });
    }
    public void ClickMenu(View view){admin_dashboard.openDrawer(drawerLayout); }


    public void ClickLogo(View view){admin_dashboard.closeDrawer(drawerLayout); }

    public void ClickDashboard(View view){ admin_dashboard.redirectActivity(this,admin_dashboard.class); }

    public void ClickProfile(View view){ recreate(); }

    public void ClickAboutUs(View view){ admin_dashboard.redirectActivity(this,admin_aboutus.class); }


    public void ClickLogout(View view){ admin_dashboard.redirectActivity(this,admin_logout.class); }

    @Override
    protected void onPause() {
        super.onPause();

        admin_dashboard.closeDrawer(drawerLayout);
    }


}


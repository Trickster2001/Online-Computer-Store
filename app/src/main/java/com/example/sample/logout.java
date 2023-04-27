package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class logout extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        drawerLayout=findViewById(R.id.drawer_layout);
        logout = findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
            }
        });
    }
    public void ClickMenu(View view){dashboard.openDrawer(drawerLayout); }


    public void ClickLogo(View view){dashboard.closeDrawer(drawerLayout); }

    public void ClickDashboard(View view){ dashboard.redirectActivity(this,dashboard.class); }

    public void ClickProfile(View view){ dashboard.redirectActivity(this,profile.class); }

    public void ClickAboutUs(View view){ dashboard.redirectActivity(this,aboutus.class); }


    public void ClickLogout(View view){ recreate(); }

    @Override
    protected void onPause() {
        super.onPause();

        dashboard.closeDrawer(drawerLayout);
    }
}
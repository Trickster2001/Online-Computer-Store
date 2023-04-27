package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class aboutus extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){dashboard.openDrawer(drawerLayout); }


    public void ClickLogo(View view){dashboard.closeDrawer(drawerLayout); }

    public void ClickDashboard(View view){ dashboard.redirectActivity(this,dashboard.class); }

    public void ClickProfile(View view){ dashboard.redirectActivity(this,profile.class); }

    public void ClickAboutUs(View view){ recreate(); }


    public void ClickLogout(View view){ dashboard.redirectActivity(this,logout.class); }

    @Override
    protected void onPause() {
        super.onPause();

        dashboard.closeDrawer(drawerLayout);
    }

}
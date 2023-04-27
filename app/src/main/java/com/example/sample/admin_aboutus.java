package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class admin_aboutus extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_aboutus);

        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){admin_dashboard.openDrawer(drawerLayout); }


    public void ClickLogo(View view){admin_dashboard.closeDrawer(drawerLayout); }

    public void ClickDashboard(View view){ admin_dashboard.redirectActivity(this,admin_dashboard.class); }

    public void ClickProfile(View view){ admin_dashboard.redirectActivity(this,admin_profile.class); }

    public void ClickAboutUs(View view){ recreate(); }


    public void ClickLogout(View view){ admin_dashboard.redirectActivity(this,admin_logout.class); }

    @Override
    protected void onPause() {
        super.onPause();

        admin_dashboard.closeDrawer(drawerLayout);
    }

}
package com.example.freshapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout ;
    BottomNavigationView btm_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbarss);
        setSupportActionBar(toolbar);

        NavigationView  nav_view = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        btm_view=findViewById(R.id.btm_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);

            }
        });




        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView,new YogaFragment())
                    .commit();
            nav_view.setCheckedItem(R.id.homeFragment);

        }

        btm_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView,new YogaFragment())
                                .commit();
                        break;
                    case R.id.callFragment:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView,new HandballFragment())
                                .commit();
                        break;
                    case R.id.settingsFragment:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView,new VollyballFragment())
                                .commit();
                        break;

                }
                return true;
            }
        });




    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.homeFragment2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView,new HomeFragment())
                        .commit();
                break;

            case R.id.callFragment2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView,new CallFragment())
                        .commit();
                break;

            case R.id.settingsFragment2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView,new SettingsFragment())
                        .commit();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
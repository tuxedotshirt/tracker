package com.example.don.tracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    final Fragment homeFragment = new Home();
    final Fragment calendarFragment = new Calendar();
    final Fragment myWorkoutsFragment = new MyWorkouts();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    return true;

                case R.id.navigation_calendar:
                    fm.beginTransaction().hide(active).show(calendarFragment).commit();
                    active = calendarFragment;
                    return true;

                case R.id.navigation_my_workouts:
                    fm.beginTransaction().hide(active).show(myWorkoutsFragment).commit();
                    active = myWorkoutsFragment;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, calendarFragment, "3").hide(calendarFragment).commit();
        fm.beginTransaction().add(R.id.main_container, myWorkoutsFragment, "2").hide(myWorkoutsFragment).commit();
        fm.beginTransaction().add(R.id.main_container,homeFragment, "1").commit();
    }

}

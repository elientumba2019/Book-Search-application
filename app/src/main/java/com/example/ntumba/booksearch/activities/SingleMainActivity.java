package com.example.ntumba.booksearch.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ntumba.booksearch.R;

public abstract class SingleMainActivity extends AppCompatActivity {


    /**
     * returns a fragment from an activity
     * that extends this class
     * @return
     */
    public abstract Fragment makeFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_main_layout);


        //getting manager
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.general_container);


        //putting on screen
        if(fragment == null){
            fragment = makeFragment();
            manager.beginTransaction().add(R.id.general_container , fragment).commit();
        }
    }
}

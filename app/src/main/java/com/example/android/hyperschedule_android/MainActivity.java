package com.example.android.hyperschedule_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android.hyperschedule_android.Fragments.main_fragment;


public class MainActivity extends AppCompatActivity {
    private main_fragment mMain_Fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMain_Fragment= new main_fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Fragment_Container, mMain_Fragment)
                .commit();
    }
}

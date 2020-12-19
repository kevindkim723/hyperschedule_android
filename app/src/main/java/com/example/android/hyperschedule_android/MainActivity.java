package com.example.android.hyperschedule_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android.hyperschedule_android.Fragments.list_fragment;

public class MainActivity extends AppCompatActivity {
    private list_fragment mListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListFragment = new list_fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.Fragment_Container, mListFragment)
                .commit();
    }
}

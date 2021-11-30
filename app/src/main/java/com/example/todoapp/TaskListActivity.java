package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class TaskListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new TaskListFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
        return fragment;
    }
}
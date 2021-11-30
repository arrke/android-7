package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID) getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = TaskFragment.newInstance(taskId);
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
        return fragment;
    }
}
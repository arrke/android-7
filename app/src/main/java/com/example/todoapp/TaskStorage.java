package com.example.todoapp;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private List<Task> tasks;
    public static TaskStorage getInstance(){ return taskStorage;}
    private TaskStorage(){
        tasks = new ArrayList<>();
        for(int i=0;i<=3;i++){
            Task task = new Task();
            task.setName("Zadanie #"+i);
            task.setDone(i%3 == 0);
            tasks.add(task);
        }
    }
    public Task getTask(UUID id){
        Task task1 = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            task1 =  tasks.stream().filter(task -> task.getId().equals(id))
                    .findFirst().orElse(null);
        }
        return task1;
    }

    public void addTask(Task task){
        tasks.add(task);
    }
}

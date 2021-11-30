package com.example.todoapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public Task(){
        id = UUID.randomUUID();
        date = new Date();
    }
}

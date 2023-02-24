package com.azati.study.springeventsdemo.entity;

import lombok.Data;

@Data
public class MyItem implements Versionable {
    private int id;
    private String name;
    private int number;
    private int version;

    public MyItem(String name, int number) {
        this.name = name;
        this.number = number;
        version = 0;
    }

    @Override
    public void incrementVersion() {
        version++;
    }

    @Override
    public void setInitialVersion() {
        version = 1;
    }
}

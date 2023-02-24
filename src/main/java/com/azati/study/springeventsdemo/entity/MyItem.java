package com.azati.study.springeventsdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MyItem implements Versionable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int number;
    private int version;

    public MyItem(String name, int number) {
        this.name = name;
        this.number = number;
        version = 0;
    }

    public MyItem() {

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

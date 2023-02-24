package com.azati.study.springeventsdemo.event;

import com.azati.study.springeventsdemo.entity.MyItem;

public class VersionableCreatedEvent extends VersionableEvent {
    public VersionableCreatedEvent(MyItem source) {
        super(source);
    }
}

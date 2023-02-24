package com.azati.study.springeventsdemo.event;

import com.azati.study.springeventsdemo.entity.MyItem;

public class VersionableUpdatedEvent extends VersionableEvent {
    private MyItem oldVersion;

    public VersionableUpdatedEvent(MyItem source, MyItem oldVersion) {
        super(source);
        this.oldVersion = oldVersion;
    }

    public MyItem getOldVersion() {
        return oldVersion;
    }

}

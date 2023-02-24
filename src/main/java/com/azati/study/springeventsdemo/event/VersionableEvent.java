package com.azati.study.springeventsdemo.event;

import com.azati.study.springeventsdemo.entity.MyItem;
import org.springframework.context.ApplicationEvent;

public class VersionableEvent extends ApplicationEvent {
    public VersionableEvent(MyItem source) {
        super(source);
    }

    @Override
    public MyItem getSource() {
        return (MyItem) super.getSource();
    }
}

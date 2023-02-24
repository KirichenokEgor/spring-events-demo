package com.azati.study.springeventsdemo.component;

import com.azati.study.springeventsdemo.entity.MyItem;
import com.azati.study.springeventsdemo.event.VersionableCreatedEvent;
import com.azati.study.springeventsdemo.event.VersionableEvent;
import com.azati.study.springeventsdemo.event.VersionableUpdatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateVersionListener implements ApplicationListener<VersionableEvent> {
    @Override
    public void onApplicationEvent(VersionableEvent event) {
        MyItem item = event.getSource();
        if (event instanceof VersionableCreatedEvent) {
            item.setInitialVersion();
        }
        if (event instanceof VersionableUpdatedEvent) {
            MyItem oldVersion = ((VersionableUpdatedEvent) event).getOldVersion();
            item.setVersion(oldVersion.getVersion());
            item.incrementVersion();
        }
    }
}

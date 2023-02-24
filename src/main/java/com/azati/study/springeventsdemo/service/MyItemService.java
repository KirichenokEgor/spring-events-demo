package com.azati.study.springeventsdemo.service;

import com.azati.study.springeventsdemo.entity.MyItem;
import com.azati.study.springeventsdemo.event.VersionableCreatedEvent;
import com.azati.study.springeventsdemo.event.VersionableUpdatedEvent;
import com.azati.study.springeventsdemo.repository.InMemoryRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MyItemService {
    private final InMemoryRepository repository;
    private ApplicationEventPublisher applicationEventPublisher;

    public MyItemService(InMemoryRepository repository, ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public MyItem insert(MyItem model) {
        applicationEventPublisher.publishEvent(new VersionableCreatedEvent(model));
        return repository.save(model);
    }

    public MyItem update(MyItem model) {
        MyItem modelInDB = repository.getById(model.getId());
        if (modelInDB == null) return null;
        applicationEventPublisher.publishEvent(new VersionableUpdatedEvent(model, modelInDB));
        return repository.save(model);
    }
}

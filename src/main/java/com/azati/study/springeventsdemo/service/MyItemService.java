package com.azati.study.springeventsdemo.service;

import com.azati.study.springeventsdemo.entity.MyItem;
import com.azati.study.springeventsdemo.event.VersionableCreatedEvent;
import com.azati.study.springeventsdemo.event.VersionableUpdatedEvent;
import com.azati.study.springeventsdemo.repository.MyItemRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyItemService {
    private final MyItemRepository repository;
    private ApplicationEventPublisher applicationEventPublisher;

    public MyItemService(MyItemRepository repository, ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public MyItem insert(MyItem model) {
        applicationEventPublisher.publishEvent(new VersionableCreatedEvent(model));
        return repository.save(model);
    }

    public MyItem update(MyItem model) {
        Optional<MyItem> modelInDB = repository.findById(model.getId());
        if (modelInDB.isEmpty()) return null;
        applicationEventPublisher.publishEvent(new VersionableUpdatedEvent(model, modelInDB.get()));
        return repository.save(model);
    }

    public List<MyItem> findAll() {
        return (List<MyItem>) repository.findAll();
    }
}

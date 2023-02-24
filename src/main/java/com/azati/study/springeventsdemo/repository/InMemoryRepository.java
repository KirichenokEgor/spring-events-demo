package com.azati.study.springeventsdemo.repository;

import com.azati.study.springeventsdemo.entity.MyItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryRepository {
    Map<Integer, MyItem> storage = new HashMap<>();
    int nextId = 1;

    public MyItem save(MyItem item) {
        if (item.getId() == 0) item.setId(nextId++);
        storage.put(item.getId(), item);
        return item;
    }

    public MyItem getById(int id) {
        return storage.get(id);
    }
}

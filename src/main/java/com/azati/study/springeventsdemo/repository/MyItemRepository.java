package com.azati.study.springeventsdemo.repository;

import com.azati.study.springeventsdemo.entity.MyItem;
import org.springframework.data.repository.CrudRepository;

public interface MyItemRepository extends CrudRepository<MyItem, Integer> {
}

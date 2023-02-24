package com.azati.study.springeventsdemo.controller;

import com.azati.study.springeventsdemo.entity.MyItem;
import com.azati.study.springeventsdemo.service.MyItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/MyItem")
public class MyController {

    private final MyItemService service;

    public MyController(MyItemService service) {
        this.service = service;
    }

    @ResponseStatus(CREATED)
    @PostMapping(produces = {APPLICATION_JSON_VALUE})
    public MyItem create(@RequestBody MyItem model) {
        return service.insert(model);
    }

    @PutMapping(produces = {APPLICATION_JSON_VALUE})
    public MyItem update(@RequestBody MyItem model) {
        return service.update(model);
    }

    @GetMapping(produces = {APPLICATION_JSON_VALUE})
    public List<MyItem> getAll() {
        return service.findAll();
    }

}

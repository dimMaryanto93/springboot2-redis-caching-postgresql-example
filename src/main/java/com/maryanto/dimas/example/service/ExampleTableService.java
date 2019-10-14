package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.entity.ExampleTable;
import com.maryanto.dimas.example.repository.ExampleTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ExampleTableService {

    @Autowired
    private ExampleTableRepository repository;

    @Transactional
    public ExampleTable save(ExampleTable value) {
        return repository.save(value);
    }

    @Transactional
    public void removeById(String id) {
        repository.deleteById(id);
    }

    public Optional<ExampleTable> findById(String id) {
        return repository.findById(id);
    }

    public Iterable<ExampleTable> list() {
        return repository.findAll();
    }
}

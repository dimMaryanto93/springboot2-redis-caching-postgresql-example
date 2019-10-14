package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.entity.ExampleTable;
import org.springframework.data.repository.CrudRepository;

public interface ExampleTableRepository extends CrudRepository<ExampleTable, String> {
}

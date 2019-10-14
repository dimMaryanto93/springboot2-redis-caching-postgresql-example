package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.entity.ExampleTable;
import com.maryanto.dimas.example.service.ExampleTableService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/example-tables")
public class ExampleTableController {

    @Autowired
    private ExampleTableService service;

    @PostMapping("/created")
    public ResponseEntity<?> createPost(@RequestBody @Valid ExampleTable value) {
        value = service.save(value);
        return ok(value);
    }

    @GetMapping("/{id}/findById")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Optional<ExampleTable> tableExampleOptional = service.findById(id);
        if (!tableExampleOptional.isPresent()) {
            return noContent().build();
        }

        ExampleTable value = tableExampleOptional.get();
        return ok(value);
    }

    @DeleteMapping("/{id}/deleteById")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        Optional<ExampleTable> tableExampleOptional = service.findById(id);
        if (!tableExampleOptional.isPresent()) {
            return noContent().build();
        }

        ExampleTable value = tableExampleOptional.get();
        service.removeById(value.getId());
        return ok().build();
    }

}

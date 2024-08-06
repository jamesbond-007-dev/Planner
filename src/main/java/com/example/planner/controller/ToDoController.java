package com.example.planner.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.planner.model.ToDoItems;
import com.example.planner.service.TodoServiceInterface;

@RestController
public class ToDoController {


    @Autowired
    TodoServiceInterface service;


    // Create Table
    @PostMapping("/createTable")
    public ResponseEntity<String> createTable() {
        service.createTable();
        ResponseEntity<String> response = new ResponseEntity<>("Table Created Successfully", HttpStatus.OK);
        return response;

    }


    // Insert Values into Table
    @PostMapping("/insertValues")
    public ResponseEntity<String> insertValue(@RequestBody ToDoItems items) {
        service.insertValues(items);
        return new ResponseEntity<>("Values Inserted Successfully", HttpStatus.OK);
    }


    // Fetch All Items from Table
    @GetMapping("/getAll")
    public ResponseEntity<List<Map<String, Object>>> fetchAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> result = service.fetchAll();
        if (result.isEmpty()) {
            map.put("result", result);
            map.put("success", false);
            map.put("query_at", LocalDateTime.now());

            list.add(map);
        } else {
            list = service.fetchAll();
        }

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    // Update Item
    @PutMapping("updateItem")
    public ResponseEntity<String> update(@RequestBody ToDoItems items) {

        ResponseEntity<String> response = new ResponseEntity<>("Item Successfully Updated", HttpStatus.OK);
        int result = service.update(items);
        if (result == 0) {
            return new ResponseEntity<>("No Updation", HttpStatus.I_AM_A_TEAPOT);
        } else {
            return response;
        }

    }


    // Patch Update
    @PatchMapping("/patchUpdate/{id}")
    public ResponseEntity<String> batchUpdate(@PathVariable int id, @RequestParam(name = "value", required = true) String value) {
        int result = service.patchUpdate(id, value);
        if (result == 0) {
            return new ResponseEntity<>("No Update Took Place", HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>("Successfully patch updated", HttpStatus.OK);
    }





        // Delete Item
        @DeleteMapping("deleteItem/{id}")
        public ResponseEntity<String> deleteItem ( @PathVariable int id){
            int result = service.deleteItem(id);
            if (result == 0) {
                return new ResponseEntity<>("No deletion took Place", HttpStatus.EXPECTATION_FAILED);
            }
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        }


    }

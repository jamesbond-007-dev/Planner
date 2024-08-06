package com.example.planner.repository;

import java.util.List;
import java.util.Map;

import com.example.planner.model.ToDoItems;

public interface ToDoInterface {
    public void createTable();
    public void insertValues(ToDoItems items);
    public List<Map<String,Object>> fetchAll();
    public int update(ToDoItems items);
    public int patchUpdate(int id,String parameter);
    public int deleteItem(int id);
}

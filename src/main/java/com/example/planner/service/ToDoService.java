package com.example.planner.service;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planner.model.ToDoItems;
import com.example.planner.repository.ToDoInterface;



@Service
public class ToDoService implements TodoServiceInterface{

    @Autowired
    ToDoInterface repo;

    public void createTable(){
        repo.createTable();
    }


    public void insertValues(ToDoItems items){
        repo.insertValues(items);
    }



    public List<Map<String,Object>> fetchAll(){
        return repo.fetchAll();
    }


    public int update(ToDoItems items){

        List<Map<String,Object>> list_of_items = fetchAll();
        for(Map<String,Object> map : list_of_items) {
            if(map.get("id").equals(items.getId())){
                return  repo.update(items);
            }
        }
        return 0;
    }



    // patch update
    public int patchUpdate(int id,String parameter){
            List<Map<String,Object>> list = fetchAll();
            for(Map<String,Object> items : list){
                if(items.get("id").equals(id)){
                    return repo.patchUpdate(id,parameter);
                }
            }
        return 0;
    }


    // delete Item
    public int deleteItem(int id){
        List<Map<String,Object>> list = fetchAll();
        for(Map<String,Object> map : list){
            if(map.get("id").equals(id)){
                return repo.deleteItem(id);
            }
        }
        return 0;
    }


    



}

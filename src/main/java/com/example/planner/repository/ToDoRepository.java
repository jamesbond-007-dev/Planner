package com.example.planner.repository;

import java.util.List;
import java.util.Map;

import com.example.planner.config.ItemsConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.planner.model.ToDoItems;

@Repository
public class ToDoRepository implements ToDoInterface {

    @Autowired
    JdbcTemplate jdbc;


    @Autowired
    ItemsConfigurations configurations;

    // Add columns into sql
    public void createTable() {
        String sql = "CREATE TABLE to_do_items (" +
                "auto_id INT AUTO_INCREMENT , " +
                "id INT NOT NULL, " +
                "title VARCHAR(256), " +
                "description VARCHAR(256), " +
                "dueDate DATETIME, " +
                "priority VARCHAR(256), " +
                "status VARCHAR(256), " +
                "PRIMARY KEY (auto_id))";

        jdbc.execute(sql);
    }



    // Insert Values into table: daily_planner
    public void insertValues(ToDoItems items){
        String sql = "INSERT INTO to_do_items (id, title, description, dueDate, priority, status) VALUES (?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, items.getId(),items.getTitle(),items.getDescription(),items.getDueDate(),items.getPriority(),items.getStatus());
    }



    // Fetch All Items from Table
    public List<Map<String,Object>> fetchAll(){
//            String sql = "select * from to_do_items";
        String sql = configurations.getFetchAll();
            return jdbc.queryForList(sql);
    }


    // Update Items
    public int update(ToDoItems items){
        String sql = "UPDATE to_do_items SET title = ?, description = ?, dueDate = ?, priority = ?, status = ? WHERE id = ?";
       return  jdbc.update(sql,items.getTitle(),items.getDescription(),items.getDueDate(),items.getPriority(),items.getStatus(),items.getId());

    }


    // update Patch Resource
    public int patchUpdate(int id,String parameter){
        String sql = "update to_do_items set priority = ? where id = ?";
        return  jdbc.update(sql,parameter,id);
    }



    // delete Items
    public int deleteItem(int id){
        String sql = "delete from to_do_items where id = ?";
        return jdbc.update(sql,id);
    }
}

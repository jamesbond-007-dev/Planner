package com.example.planner.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class ItemsConfigurations {

    @Value("${planner.fetch.all.query}")
    private String fetchAll;




    public String getFetchAll() {
        return fetchAll;
    }

    public void setFetchAll(String fetchAll) {
        this.fetchAll = fetchAll;
    }
}

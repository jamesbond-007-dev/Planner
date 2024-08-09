package com.example.planner.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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

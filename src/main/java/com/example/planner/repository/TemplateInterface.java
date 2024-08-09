package com.example.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.planner.model.Templates;

@Repository
public interface TemplateInterface extends JpaRepository<Templates,Integer> {


}

package com.example.codeclan.employeeservice.controllers;


import com.example.codeclan.employeeservice.models.Project;
import com.example.codeclan.employeeservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(value = "/projects")

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(value = "/employees/{id}")
    public Optional<Project> getPirateById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }
}

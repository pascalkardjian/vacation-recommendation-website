package com.example.cms.controller;


import com.example.cms.controller.exceptions.ClassroomNotFoundException;
import com.example.cms.model.entity.Classroom;
import com.example.cms.model.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ClassroomController {
    @Autowired
    private final ClassroomRepository repository;

    public ClassroomController(ClassroomRepository repository){
        this.repository = repository;
    }

    @GetMapping("/classrooms")
    List<Classroom> retrieveAllClassrooms(){
        return repository.findAll();
    }

    @GetMapping("/classrooms/{code}")
    Classroom retrieveStudent(@PathVariable("code") String code){
        return repository.findById(code).orElseThrow(
                () -> new ClassroomNotFoundException(code)
        );
    }
}

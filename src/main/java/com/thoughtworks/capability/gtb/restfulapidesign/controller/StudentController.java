package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.DivideStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/handler")
public class StudentController {
    private final DivideStudentService divideStudentService;

    public StudentController(DivideStudentService divideStudentService) {
        this.divideStudentService = divideStudentService;
        divideStudentService.initData();
    }

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return divideStudentService.getStudentList();
    }

    @GetMapping("/Sequence")
    public List<ArrayList> getOneSequenceStudent(){
        return divideStudentService.getSequenceList();
    }

    @PostMapping("/divideStudent")
    public void divideStudent(){
        divideStudentService.divideStudent();
    }

    @PostMapping("/addStudent/{studentName}")
    public void addStudent(@PathVariable String studentName){
        divideStudentService.addStudent(studentName);
    }
}


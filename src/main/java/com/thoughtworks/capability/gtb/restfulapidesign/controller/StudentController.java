package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/handler")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        studentService.initData();
    }

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getStudentList();
    }

    @GetMapping("/sequence")
    public List<ArrayList> getOneSequenceStudent(){
        return studentService.getSequenceList();
    }

    @PostMapping("/divideStudent")
    public void divideStudent(){
        studentService.divideStudent();
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentName}")
    public void deleteStudent(@PathVariable String studentName){

    }
}


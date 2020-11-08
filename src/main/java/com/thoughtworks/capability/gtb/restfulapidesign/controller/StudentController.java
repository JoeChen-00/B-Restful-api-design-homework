package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Sequence;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{studentName}")
    public void deleteStudent(@PathVariable String studentName){

    }

    @GetMapping("/queryStudents")
    public List<Student> getStudents(@RequestParam(required = false, name = "gender") String gender){
        return studentService.getStudentList();
    }

    @GetMapping("/queryStudent/{studentName}")
    public Student getStudent(@PathVariable String studentName){
        return new Student();
    }

    @PatchMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){

    }

    @PostMapping("/divideStudent")
    public void divideStudent(){
        studentService.divideStudent();
    }

    @PatchMapping("/updateSequenceName/{sequenceId}/{sequenceNewName}")
    public void updateSequenceName(@PathVariable int sequenceId, @PathVariable String sequenceNewName){

    }

    @GetMapping("/sequence")
    public List<Sequence> getOneSequenceStudent(){
        return studentService.getSequenceList();
    }
}


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

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/queryStudents")
    public List<Student> getStudents(@RequestParam(required = false, name = "gender") String gender){
        return studentService.getStudentList(gender);
    }

    @GetMapping("/queryStudent/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return studentService.getStudent(studentId);
    }

    @PatchMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @PostMapping("/divideStudent")
    public void divideStudent(){
        studentService.divideStudent();
    }

    @PatchMapping("/updateSequenceName/{sequenceId}/{sequenceNewName}")
    public void updateSequenceName(@PathVariable int sequenceId, @PathVariable String sequenceNewName){
        studentService.updateSequenceName(sequenceId,sequenceNewName);
    }

    @GetMapping("/sequence")
    public List<Sequence> getOneSequenceStudent(){
        return studentService.getSequenceList();
    }
}


package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Sequence;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
  static private List<Student> studentList;
  static private List<Sequence> sequenceList;

  public void initData(){
    sequenceList = new ArrayList<>();
    studentList = new ArrayList<>(Arrays.asList(
      new Student(1,"成吉思汗","男","null"),
      new Student(2,"鲁班七号","女","null"),
      new Student(3,"太乙真人","男","null"),
      new Student(4,"钟无艳","女","null"),
      new Student(5,"花木兰","女","null"),
      new Student(6,"雅典娜","女","null"),
      new Student(7,"芈月","女","null"),
      new Student(8,"白起","男","null"),
      new Student(9,"刘禅","男","null"),
      new Student(10,"庄周","男","null"),
      new Student(11,"马超","男","null"),
      new Student(12,"刘备","男","null"),
      new Student(13,"哪吒","男","null"),
      new Student(14,"大乔","女","null"),
      new Student(15,"蔡文姬","女","null")
    ));
  }

  public List<Student> getStudentList(String gender) {
    if(gender.isEmpty())
      return studentList;
    else{
      List<Student> queryStudent = studentList.stream()
              .filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
      return queryStudent;
    }
  }

  public List<Sequence> getSequenceList() {
    return sequenceList;
  }

  public void divideStudent(){
    int length = studentList.size();
    List<Student> studentListClone = new ArrayList<>();
    studentListClone.addAll(studentList);
    Collections.shuffle(studentListClone);
    sequenceList.clear();
    for(int iter_i = 0;iter_i < 6; ++iter_i){
      Sequence sequence = new Sequence();
      for(int iter_j = iter_i * 2 + Math.min(iter_i,length%6);
          iter_j < (iter_i + 1) * 2 + Math.min(iter_i + 1,length%6); ++iter_j){
        sequence.getStudentList().add(studentListClone.get(iter_j));
      }
      sequence.setId(iter_i + 1);
      sequenceList.add(sequence);
    }
  }

  public void addStudent(Student student){
    int length = studentList.size();
    student.setNumber(length + 1);
    studentList.add(student);
  }

  public void deleteStudent(int studentId) {
    List<Student> queryStudent = studentList.stream()
            .filter(student -> student.getNumber() == studentId).collect(Collectors.toList());
    if(queryStudent.size() == 0)
      throw new NoSuchElementException();
    else
      studentList.remove(queryStudent.get(0));
  }

  public Student getStudent(int studentId) {
    List<Student> queryStudent = studentList.stream()
            .filter(student -> student.getNumber() == studentId).collect(Collectors.toList());
    if(queryStudent.size() == 0)
      throw new NoSuchElementException();
    else
      return queryStudent.get(0);
  }

  public void updateStudent(Student student) {
  }

  public void updateSequenceName(int sequenceId, String sequenceNewName) {
  }
}

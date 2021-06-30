package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        String[] interests = {"Skiing", "Holidays"};
        Student john = new Student("John", "Doe", 50, "London", interests);
        students.add(john);
        String[] interest = {"Tennis", "Cooking"};
        Student esmee = new Student("Esmee", "Barr", 22, "Warwickshire", interests);
        students.add(esmee);
    }

    @GetMapping("/students")
    //get students
    public List<Student> getStudents() {
        return this.students;
    }

    //get single student by id
    @GetMapping("/students/{studentId}")
    @ResponseBody
    public Student getStudent(@PathVariable String studentId, @RequestParam String key) {
        int idAsInt = Integer.parseInt(studentId);
        return this.students.get(idAsInt);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        //....how do we create a student?
        System.out.println("the name is" + student.getFirstName());
        this.students.add(student);
        return student;
    }

// delete a student by id as well
@DeleteMapping("/students/delete")
public Student deleteStudent(@PathVariable String studentId) {
    int idAsInt = Integer.parseInt(studentId);
    return this.students.remove(idAsInt);
}
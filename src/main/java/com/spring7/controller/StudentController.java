package com.spring7.controller;

import com.spring7.model.Student;
import com.spring7.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/get")
    public List<Student> viewStudents(){
        return studentService.findAll();
    }

    @GetMapping("/delete/{id}")
    public void deleteStudents(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @PostMapping("/update")
    @ResponseBody
    public void studentSubmit(@RequestParam Long id, @RequestParam String name, @RequestParam Integer age) {
        if (id == 0){
            studentService.addNewStudent(name, age);
        } else {
            studentService.update(id,name,age);
        }

    }
}

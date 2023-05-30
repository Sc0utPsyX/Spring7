package com.spring7.service;

import com.spring7.model.Student;
import com.spring7.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findByName(String name){
        return studentRepository.findByName(name);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public void addNewStudent(String name, Integer age){
        studentRepository.save(new Student(name, age));
    }

    public void update(Long id, String name, Integer age){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setAge(age);
        student.setName(name);
        studentRepository.save(student);
    }
}

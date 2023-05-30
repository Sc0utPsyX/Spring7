package com.spring7.model;

import com.spring7.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentGenerator {
    private final StudentRepository studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generateOnStartup(){
        studentRepository.save(new Student("Vasya", 10));
        studentRepository.save(new Student("Vasya1", 12));
        studentRepository.save(new Student("Vasya3", 11));
        studentRepository.save(new Student("Vasya2", 14));
        studentRepository.findAll().stream().forEach(System.out::println);
    }
}

package com.gremwell.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gremwell.demo.persistence.model.Student;
import com.gremwell.demo.persistence.repo.StudentRepository;

import com.gremwell.demo.persistence.model.VulnData;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/fname/{firstName}")
    public List<Student> findByFList(@PathVariable String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable String id) {
        return studentRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        Student student1 = studentRepository.save(student);
        return student1;
    }

    @PostMapping("/vuln")
    public List<Student> vuln(@RequestBody VulnData data) {
        return studentRepository.findByFirstName(data.getValue());
        //return studentRepository.findById(data.getValue());
    }
}

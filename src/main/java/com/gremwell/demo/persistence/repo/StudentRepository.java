package com.gremwell.demo.persistence.repo;

import java.util.List;
import java.util.Optional;

import com.gremwell.demo.persistence.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.couchbase.core.query.QueryCriteria;

@Repository
public class StudentRepository {
    @Autowired
    private CouchbaseTemplate template;

    public Student findById(String id) {
        return template.findById(Student.class).one(id);
    }

    public Iterable<Student> findAll() {
        return template.findByQuery(Student.class).all();
    }

    public List<Student> findByFirstName(String firstName) {
        return template.findByQuery(Student.class).matching(QueryCriteria.where("firstName").like(firstName)).all();
    }

    public Student save(Student student) {
        return template.upsertById(Student.class).one(student);
    }
}

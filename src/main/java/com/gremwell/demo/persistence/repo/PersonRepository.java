package com.gremwell.demo.persistence.repo;

import java.util.List;
import java.util.Optional;

import com.gremwell.demo.persistence.model.Person;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CouchbaseRepository<Person, String> {
    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    //@Query("#{#n1ql.selectEntity} WHERE firstName = $1")
    //@Query("#{#n1ql.selectEntity} USE KEYS $id")
    //List<Person> vulnFind(@Param("id") String id);
    @Query("#{#n1ql.selectEntity} WHERE #{#n1ql.filter} AND #{[0]} = '#{[1]}'")
    List<Person> vulnFind(String field, String val);
}

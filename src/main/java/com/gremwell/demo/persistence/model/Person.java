package com.gremwell.demo.persistence.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        if (id != null) {
            hash = hash * 31 + id.hashCode();
        }
        if (firstName != null) {
            hash = hash * 31 + firstName.hashCode();
        }
        if (lastName != null) {
            hash = hash * 31 + lastName.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass()))
            return false;
        if (obj == this)
            return true;
        Person other = (Person) obj;
        return this.hashCode() == other.hashCode();
    }
}

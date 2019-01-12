package io.zipcoder.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
Create a `Person` class with fields for first name, last name, and an id number.

 */

@Entity
public class Person {
     @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

     private Integer id;
     private String firstname;
     private String lastname;
    
     public String getFirstname(){

         return firstname;
    }

    public void setFirstname(String firstname) {

         this.firstname = firstname;
    }

    public String getLastname() {

         return lastname;
    }

    public void setLastname(String lastname) {

         this.lastname = lastname;
    }

    public int getId() {

         return id;
    }

     public void setId(int id) {

         this.id = id;
     }
     @Override
    public String toString() {
         return "Person{" +
                 "id=" + id +
                 ", firstname='" + firstname + '\'' +
                 ", lastname='" + lastname + '\'' +
                 '}';
     }



}

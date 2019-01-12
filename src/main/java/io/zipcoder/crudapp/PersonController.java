package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
Create a `PersonController` class with `Person createPerson(Person p)`, `
Person getPerson(int id)`, `List<Person> getPersonList()`, `Person updatePerson(Person p)`,
 and `void DeletePerson(int id)` methods, and let it track a list of Person objects.

Add the `@RestController` annotation to your `PersonController`
class, and using the "Endpoints" list in the Reference section below,
add the appropriate `@RequestMapping` annotations to each of your methods.
Endpoints should be at `/people` and `/people/{id}` as appropriate.
You will have to use `@PathVariable` for id numbers in the URI and `@RequestBody`
for Person objects sent in the requests.

 */
@RestController
public class PersonController {


    @Autowired
   PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.POST )

   public  ResponseEntity <?> createPerson(@RequestBody Person p){

       URI newPollUri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(p .getId())
               .toUri();
       return new ResponseEntity<> (null, HttpStatus.CREATED) ;

    }

    @RequestMapping(value = "/person{id}", method = RequestMethod.GET)

   public  ResponseEntity<?> getPerson(@PathVariable Integer id){

        Person person=personRepository.findOne(id);

        return new ResponseEntity<>(person ,HttpStatus.OK ) ;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<Iterable  <Person > >getPersonList( ){
        Iterable<Person> person = personRepository .findAll();

        Iterable<Person > personIterable = StreamSupport.stream(person .spliterator(),false)

            .collect(Collectors.toList() );
        return new ResponseEntity<>(personIterable  , HttpStatus.OK ) ;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updatePerson(@RequestBody Person person,@PathVariable Integer id){
        Person p=personRepository.save(person ) ;
       return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/person{id}", method = RequestMethod.DELETE )
    public void deletePerson( @PathVariable Integer id){
        personRepository .delete(id);

    }

}

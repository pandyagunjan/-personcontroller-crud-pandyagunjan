package io.zipcoder.crudapp.repositories;

import io.zipcoder.crudapp.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    Person findPersonById(Long id);
//    List<Person> findAll();
//   // Person save(Person person);
//    void deleteById(Long id);
//    //update use save
}

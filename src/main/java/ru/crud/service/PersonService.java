package ru.crud.service;

import ru.crud.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> index();
    Person show (int id);
    void save(Person person);
    void update(int id, Person updatedPerson);
    void delete(int id);

}

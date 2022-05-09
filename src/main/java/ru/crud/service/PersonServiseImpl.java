package ru.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crud.dao.PersonDAO;
import ru.crud.models.Person;

import java.util.List;

@Service
public class PersonServiseImpl implements PersonService {

    private PersonDAO personDAO;

    @Transactional
    @Autowired
    public void  setPersonDAO (PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Transactional
    @Override
    public List<Person> index() {
        return personDAO.index();
    }

    @Transactional
    @Override
    public Person show(int id) {
        return personDAO.show(id);
    }

    @Transactional
    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Transactional
    @Override
    public void update(int id, Person updatedPerson) {
        personDAO.update(id, updatedPerson);///////////////???
    }

    @Transactional
    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }
}

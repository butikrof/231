package ru.crud.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.crud.dao.PersonDAO;
import ru.crud.dao.PersonDAOImpl;
import ru.crud.models.Person;

import java.util.List;

@Component
public class Starter {
   PersonDAOImpl personDAO;
   public Starter(@Autowired PersonDAOImpl personDAO){
       this.personDAO = personDAO;
   }

   @Bean
   public void init(){
       //    personDAO.delete(8);
       System.out.println("init start");
    }








}

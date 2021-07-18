package com.example.htctest.service;

import com.example.htctest.entity.Person;
import com.example.htctest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<Person> personList = personRepository.findAll();

        for (Person p : personList) {
            String date = p.getDate();
            String[] arrayDate = date.split("\\-");
            LocalDate birthDate = LocalDate.of(Integer.parseInt(arrayDate[0]), Integer.parseInt(arrayDate[1]), Integer.parseInt(arrayDate[2]));
            LocalDate currentDate = LocalDate.now();
            p.setDate(String.valueOf(Period.between(birthDate, currentDate).getYears()));
        }

        return personList;
    }
}

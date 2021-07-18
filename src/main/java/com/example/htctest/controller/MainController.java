package com.example.htctest.controller;

import com.example.htctest.entity.Document;
import com.example.htctest.entity.Person;
import com.example.htctest.entity.TypeDocument;
import com.example.htctest.model.*;
import com.example.htctest.service.DocumentService;
import com.example.htctest.service.PersonService;
import com.example.htctest.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private final DocumentService documentService;
    private final PersonService personService;
    private final TypeDocumentService typeDocumentService;

    public MainController(@Autowired DocumentService documentService,
                          @Autowired PersonService personService,
                          @Autowired TypeDocumentService typeDocumentService) {
        this.documentService = documentService;
        this.personService = personService;
        this.typeDocumentService = typeDocumentService;
    }

    @GetMapping("/people")
    public String findAll(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("people", personList);
        return "people";
    }

    @GetMapping("/create")
    public String createFormPerson(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("passport", new Passport());
        model.addAttribute("snils", new Snils());
        model.addAttribute("inn", new Inn());
        model.addAttribute("driverLicense", new DriverLicense());
        model.addAttribute("militaryId", new MilitaryId());
        return "create";
    }

    @PostMapping("/create")
    public String saveFormPerson(@ModelAttribute("person") @Valid Person person,
                                 BindingResult bindingResultPerson,
                                 @ModelAttribute("passport") @Valid Passport passport,
                                 BindingResult bindingResultPassport,
                                 @ModelAttribute("snils") Snils snils,
                                 @ModelAttribute("inn") Inn inn,
                                 @ModelAttribute("driverLicense") DriverLicense driverLicense,
                                 @ModelAttribute("militaryId") MilitaryId militaryId,
                                 @RequestParam(value = "sex") String sex) {

        if (bindingResultPerson.hasErrors() || bindingResultPassport.hasErrors()) {
            return "create";
        }

        person.setSex(sex);

        if (sex.equals("M")) {
            savePersonMale(person, passport, snils, inn, driverLicense, militaryId);
        } else {
            savePersonFemale(person, passport, snils, inn, driverLicense);
        }

        return "index";
    }

    public void savePersonMale(Person person, Passport passport, Snils snils, Inn inn, DriverLicense driverLicense, MilitaryId militaryId) {
        TypeDocument passportType = typeDocumentService.findById(1L);
        TypeDocument snilsType = typeDocumentService.findById(2L);
        TypeDocument innType = typeDocumentService.findById(3L);
        TypeDocument driverLicenseType = typeDocumentService.findById(4L);
        TypeDocument militaryIdType = typeDocumentService.findById(5L);

        Document passportDocument = new Document(passport, passportType, person);
        Document snilsDocument = new Document(snils, snilsType, person);
        Document innDocument = new Document(inn, innType, person);
        Document driverLicenseDocument = new Document(driverLicense, driverLicenseType, person);
        Document militaryIdDocument = new Document(militaryId, militaryIdType, person);

        documentService.saveDocument(passportDocument);
        documentService.saveDocument(snilsDocument);
        documentService.saveDocument(innDocument);
        documentService.saveDocument(driverLicenseDocument);
        documentService.saveDocument(militaryIdDocument);
    }

    public void savePersonFemale(Person person, Passport passport, Snils snils, Inn inn, DriverLicense driverLicense) {
        TypeDocument passportType = typeDocumentService.findById(1L);
        TypeDocument snilsType = typeDocumentService.findById(2L);
        TypeDocument innType = typeDocumentService.findById(3L);
        TypeDocument driverLicenseType = typeDocumentService.findById(4L);

        Document passportDocument = new Document(passport, passportType, person);
        Document snilsDocument = new Document(snils, snilsType, person);
        Document innDocument = new Document(inn, innType, person);
        Document driverLicenseDocument = new Document(driverLicense, driverLicenseType, person);

        documentService.saveDocument(passportDocument);
        documentService.saveDocument(snilsDocument);
        documentService.saveDocument(innDocument);
        documentService.saveDocument(driverLicenseDocument);
    }
}

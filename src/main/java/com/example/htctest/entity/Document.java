package com.example.htctest.entity;

import com.example.htctest.model.*;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @Column(name = "id", columnDefinition = "INTEGER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeDocument typeDocument;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "series")
    private Integer series;

    @Column(name = "number")
    private Integer number;

    @Column(name = "date")
    private String date;

    public Document() {
    }

    public Document(Passport passport, TypeDocument passportType, Person person) {
        this.series = passport.getSeriesPassport();
        this.number = passport.getNumberPassport();
        this.date = passport.getDatePassport();
        this.typeDocument = passportType;
        this.person = person;
    }

    public Document(Snils snils, TypeDocument snilsType, Person person) {
        this.number = snils.getNumberSnils();
        this.date = snils.getDateSnils();
        this.typeDocument = snilsType;
        this.person = person;
    }

    public Document(Inn inn, TypeDocument innType, Person person) {
        this.number = inn.getNumberInn();
        this.date = inn.getDateInn();
        this.typeDocument = innType;
        this.person = person;
    }

    public Document(DriverLicense driverLicense, TypeDocument driverLicenseType, Person person) {
        this.number = driverLicense.getNumberDriverLicense();
        this.date = driverLicense.getDateDriverLicense();
        this.typeDocument = driverLicenseType;
        this.person = person;
    }

    public Document(MilitaryId militaryId, TypeDocument militaryIdType, Person person) {
        this.number = militaryId.getNumberMilitaryId();
        this.date = militaryId.getDateMilitaryId();
        this.typeDocument = militaryIdType;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

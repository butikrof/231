package ru.crud.models;


import javax.persistence.*;

@Entity
@Table(name = "prisoners")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dateOfBirth")
    private double dateOfBirth;

    @Column(name = "article")
    private double article;

    @Column(name = "arrivalDate")
    private double arrivalDate;

    @Column(name = "appointedTime")
    private double appointedTime;

    @Column(name = "demeanor")
    private String demeanor;


    public Person() {
    }

    public Person(int id, String name, String surname, double dateOfBirth, double article, double arrivalDate, double appointedTime, String demeanor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.article = article;
        this.arrivalDate = arrivalDate;
        this.appointedTime = appointedTime;
        this.demeanor = demeanor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(double dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getArticle() {
        return article;
    }

    public void setArticle(double article) {
        this.article = article;
    }

    public double getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(double arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(double appointedTime) {
        this.appointedTime = appointedTime;
    }

    public String getDemeanor() {
        return demeanor;
    }

    public void setDemeanor(String demeanor) {
        this.demeanor = demeanor;
    }
}

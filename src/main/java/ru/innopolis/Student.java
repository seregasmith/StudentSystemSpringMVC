package ru.innopolis;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Smith on 31.10.2016.
 */
@Entity
@Table(name= "studentz")
public class Student {


    public enum Sex{MALE,FEMALE}
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name= "name", length=16)
    private String name;
    @Column(name= "surname", length=16)
    private String surname;
    @Column(name= "sex")
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    @Column(name= "dob")
    @Temporal(value=TemporalType.DATE)
    private Date dateOfBirth;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

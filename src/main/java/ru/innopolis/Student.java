package ru.innopolis;

import java.util.Date;

/**
 * Created by Smith on 31.10.2016.
 */
public class Student {


    public enum Sex{MALE,FEMALE;}
    private int db_id;

    private String name;
    private String surname;
    private Sex sex;
    private Date dateOfBirth;

    public int getDbId() {
        return db_id;
    }

    public void setDbId(int db_id) {
        this.db_id = db_id;
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

package ru.innopolis;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Smith on 31.10.2016.
 */
@Entity
@Table(name= "studentz")
public class Student {




    public enum Sex{MALE,FEMALE;}
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
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

    public void setSex(String sex) {
        if("MALE".equals(sex.toUpperCase())) {
            this.sex = Sex.MALE;
            return;
        }
        if("FEMALE".equals(sex.toUpperCase())) {
            this.sex = Sex.FEMALE;
            return;
        }
        throw new IllegalArgumentException(new StringBuilder("Sex cannot be \"").append(sex).append("\"").toString());
    }

    public void setDateOfBirth(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOfBirth = sdf.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

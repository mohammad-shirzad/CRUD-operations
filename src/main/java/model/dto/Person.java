package model.dto;

import java.util.Date;

public class Person {
    public int id;
    public String nationalId;
    public String firstName;
    public String lastName;
    public java.sql.Date birthDate;
    public String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Person(String nationalId, String firstName, String lastName, java.sql.Date birthDate, String major) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.major=major;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }
}

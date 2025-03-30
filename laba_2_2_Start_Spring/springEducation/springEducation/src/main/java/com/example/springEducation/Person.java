package com.example.springEducation;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person(String firstName, String lastName,  String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = converter(birthDate);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = converter(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public static LocalDate converter (String date) {
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy, MM, dd");
        return  LocalDate.parse(date, formatter);
    }
}

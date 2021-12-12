package com.Mujo;

import java.time.LocalDate;

public abstract class Person {
    private String firstName, lastName;
    private LocalDate birthday;

    public static final LocalDate MAXIMUM_BIRTHDAY = LocalDate.now();

    public Person() {
        firstName = "";
        lastName = "";
        birthday = LocalDate.now();
    }

    private boolean validateBirthday(LocalDate date){
        if(date.compareTo(MAXIMUM_BIRTHDAY) > 0)
        {
            return false;
        }
        return true;
    }

    public  String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (validateFirstName(firstName)){
            this.firstName = firstName;

        }else{
            throw new IllegalArgumentException("first name can not be null");
        }

    }

    private boolean validateFirstName(String firstName) {
        if (firstName == null){
            return false;
        }
        return true;
    }

    public  String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (validateLastName(lastName)) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Last name can not be null");
        }
    }

    private boolean validateLastName(String lastName) {
        if (lastName == null){
            return false;
        }
        return true;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate ld) {
        if (validateBirthday(birthday)) {
            this.birthday = ld;
        }else{
            throw new IllegalArgumentException("Data of birth not valid");
        }
    }
}

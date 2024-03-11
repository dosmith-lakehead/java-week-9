package com.example.sqltest;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName, lastName, address;
    private LocalDate birthday;

    public Person(String firstName, String lastName, String address, LocalDate birthday) {
        setfirstName(firstName);
        setlastName(lastName);
        this.address = address;
        setBirthday(birthday);
    }

    /**
     * Format Names to remove leading and trailing white spaces and Capitalize the first letter
     * @return
     */
    private String formatName(String name){
        name = name.trim();
        if (name.length()>1){
            return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        }
        return name.substring(0,1).toUpperCase();
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        firstName = formatName((firstName));
        if (firstName.length()>=2){
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("names must be two or more chars");
        }
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        lastName = formatName((lastName));
        if (lastName.length()>=2){
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("names must be two or more chars");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Birthday cannot be in the future");
        }
        this.birthday = birthday;
    }

    /**
     * Returns the age of the person in years
     */
    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String toString(){
        return String.format("%s %s is %d years old", firstName, lastName, getAge());
    }
}

package com.example.sqltest;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {
    private int studentNum;
    private ArrayList<Grade> grades;

    public Student(String firstName, String lastName, String address, LocalDate birthday, int studentNum, ArrayList<Grade> grades) {
        super(firstName, lastName, address, birthday);
        setStudentNum(studentNum);
        this.grades = grades;
    }

    /**
     * This constructor is said to be "overloaded" meaning there are 2 constructors,
     * but they have different arguments.
     */
    public Student(String firstName, String lastName, String address, LocalDate birthday, int studentNum) {
        super(firstName, lastName, address, birthday);
        setStudentNum(studentNum);
        this.grades = new ArrayList<Grade>();
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        if (studentNum >= 100000000 && studentNum <= 999999999){
            this.studentNum = studentNum;
        }
        else {
            throw new IllegalArgumentException("Student number must be a 9 digit number");
        }
    }

    public String toString(){
        return String.format("%s %s, student number %d", getfirstName(), getlastName(), studentNum );
    }

    public double getAvgGrade(){
        if (grades.isEmpty()){
            return -1;
        }
        double total = 0;
        for (Grade grade : grades){
            total += grade.getGrade();
        }
        return total / grades.size();
    }
}

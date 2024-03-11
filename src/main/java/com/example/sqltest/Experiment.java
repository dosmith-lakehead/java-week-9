package com.example.sqltest;

import java.util.ArrayList;

public class Experiment {


    public static void main(String[] args){
        ArrayList<Course> courses = DBUtility.getCoursesFromDB();
        for (Course course: courses){
            System.out.printf("%d %s\n", course.getCrn(), course.getCourseName());
        }
        ArrayList<Student> students = DBUtility.getStudentsFromDB();
        for (Student student: students){
            System.out.println(student + " Avg Grade: " + student.getAvgGrade());
        }
    }
}

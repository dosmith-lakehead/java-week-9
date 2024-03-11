package com.example.sqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "";
    //jdbc:mysql - driver
    //localhost:3307 - MySQL server address and port
    //edmuse2024 - database name
    private static String connectUrl = "jdbc:mysql://localhost:3307/edmuse2024";

    // To connect to MySQL server:
    //1. Update pom.xml file with the dependency
    //2. Update module.info file with java.sql
    //3. Define the connection as above

    public static ArrayList<Course> getCoursesFromDB(){
        ArrayList<Course> courses = new ArrayList<>();

        try (
            Connection conn = DriverManager.getConnection(connectUrl, user, password);
            Statement statement =  conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
        ){
            while (resultSet.next()){
                int crn = resultSet.getInt("crn");
                String courseCode = resultSet.getString("courseCode");
                String courseName = resultSet.getString("courseName");

                courses.add(new Course(crn, courseCode, courseName));
            }
            return courses;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Student> getStudentsFromDB() {
        ArrayList<Student> students = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        ) {
            while (resultSet.next()) {
                int studentNum = resultSet.getInt("studentNum");
                ArrayList<Grade> grades = getGradesFromDB(studentNum);
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                students.add(new Student(firstName, lastName, address, birthday, studentNum, grades));
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<Grade> getGradesFromDB(int studentNum) {
        ArrayList<Grade> grades = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM grades RIGHT OUTER JOIN students on students.studentNum = grades.studentNum WHERE grades.studentNum = " + studentNum);
        ) {
            while (resultSet.next()) {
                int crn = resultSet.getInt("crn");
                int grade = resultSet.getInt("grade");
                grades.add(new Grade(studentNum,crn,grade ));
            }
            return grades;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

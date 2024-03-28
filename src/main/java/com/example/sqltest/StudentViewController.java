package com.example.sqltest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private Label ageDisplay;

    @FXML
    private Label firstNameDisplay;

    @FXML
    private Label lastNameDisplay;

    @FXML
    private ListView<Student> listView;

    @FXML
    private Label numberOfStudents;

    @FXML
    void exportToCSV(ActionEvent event) {
        try (
            Formatter formatter = new Formatter("students.csv");
        ){
            formatter.format("Student Number, First Name, Last Name, Age%n");
            for (Student student : listView.getItems()){
                formatter.format("%d, %s, %s, %d%n",
                        student.getStudentNum(),
                        student.getfirstName(),
                        student.getlastName(),
                        student.getAge());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Student> students = DBUtility.getStudentsFromDB();
        listView.getItems().addAll(students);

        // add click listener for listView
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, studentSelected) -> {
                    firstNameDisplay.setText(studentSelected.getfirstName());
                    lastNameDisplay.setText(studentSelected.getlastName());
                    ageDisplay.setText(String.valueOf(studentSelected.getAge()));
                });

    }
}
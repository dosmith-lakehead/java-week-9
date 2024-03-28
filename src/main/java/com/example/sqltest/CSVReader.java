package com.example.sqltest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) {
        Scanner scanner;

        {
            try {
                scanner = new Scanner(new File("students.csv"));
                while (scanner.hasNext()){
                    String[] student = scanner.nextLine().split(",");
                    System.out.printf("%s %s%n", student[1], student[2]);
                }
            }catch (FileNotFoundException e){
                throw new RuntimeException();
            }
        }
    }
}

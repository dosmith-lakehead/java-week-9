package com.example.sqltest;

public class Course {
    private int crn;
    private String courseCode, courseName;

    public Course(int crn, String courseCode, String courseName) {
        setCrn(crn);
        setCourseCode(courseCode);
        setCourseName(courseName);
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Typical course codes: COMP 1008, MGMT 2008, etc.
     *
     * Regular Expressions to define a pattern
     * @return
     */
    public void setCourseCode(String courseCode) {
        String courseCodePattern = "[A-Z]{4}\\s[0-9]{4}";
        courseCode = courseCode.toUpperCase();

        if (courseCode.matches(courseCodePattern)){
            this.courseCode = courseCode;
        }
        else {
            throw new IllegalArgumentException("Course code must follow the pattern: ABCD 1234");
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

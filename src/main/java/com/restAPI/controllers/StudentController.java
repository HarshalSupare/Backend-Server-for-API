package com.restAPI.controllers;

import com.restAPI.Services.StudentData;

import java.util.HashMap;

public class StudentController {
    public static Integer studentCount;
    public static HashMap<Integer, StudentData> students = new HashMap<>();

    public static Integer addStudent(StudentData studentData) {
        if (students.isEmpty()){
            studentCount = 1;
            students.put(studentCount, studentData);
        }else {
            students.put(studentCount++, studentData);
        }

        return studentCount;
    }

    public static StudentData getStudent(Integer studentId){
        return students.get(studentId);
    }
}

package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String, ArrayList<String>> teacherStudentDb = new HashMap<>();

    public void addStudent(Student student) {
        studentDb.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherDb.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        ArrayList<String> students = teacherStudentDb.getOrDefault(teacher,new ArrayList<>());
        students.add(student);
        teacherStudentDb.put(teacher,students);
    }

    public Student getStudentByName(String name) {
        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
       return teacherStudentDb.getOrDefault(teacher,new ArrayList<>());
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentDb.keySet());
    }

    public void deleteTeacherByName(String teacher) {
        teacherDb.remove(teacher);
        teacherStudentDb.remove(teacher);
    }

    public void deleteStudent(String stu) {
        studentDb.remove(stu);
    }

    public List<String> getAllTeacher() {
        return new ArrayList<>(teacherDb.keySet());
    }
}

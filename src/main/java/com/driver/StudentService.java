package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher) {
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String student, String teacher) {
        return studentRepository.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String student_name){
        return studentRepository.getStudentByName(student_name);
    }

    public Teacher getTeacherByName(String teacher_name){
        return studentRepository.getTeacherByName(teacher_name);
    }

    public List<String> getStudentsByTeacherName(String teacher_name){
        return studentRepository.getStudentsByTeacherName(teacher_name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher_name){
        studentRepository.deleteTeacherByName(teacher_name);
    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }
}

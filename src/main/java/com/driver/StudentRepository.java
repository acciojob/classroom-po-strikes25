package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> student_database; // Key - Student Name : Value - Student Data
    HashMap<String, Teacher> teacher_database; // Key - Teacher Name : Value - Teacher Data
    HashMap<String, ArrayList<String>> teacher_student_database; // Key - Teacher Name : Value - List of Students

    public StudentRepository() {
        this.student_database = new HashMap<>();
        this.teacher_database = new HashMap<>();
        this.teacher_student_database = new HashMap<>();
    }

    public String addStudent(Student student){
        student_database.put(student.getName(), student);
        return "Student added";
    }

    public String addTeacher(Teacher teacher){
        teacher_database.put(teacher.getName(), teacher);
        return "Teacher added";
    }

    public String addStudentTeacherPair(String student, String teacher){
        if(!teacher_student_database.containsKey(teacher)){
            // Crucial step !!! Always remember this !
            teacher_student_database.put(teacher, new ArrayList<String>());
        }
        teacher_student_database.get(teacher).add(student);
        return "Pair added";
    }

    public Student getStudentByName(String student_name){
        return student_database.get(student_name);
    }

    public Teacher getTeacherByName(String teacher_name){
        for(String stud : teacher_database.keySet()){
            Teacher teacher_details = teacher_database.get(stud);
            if(teacher_details.getName().equals(teacher_name))
                return teacher_details;
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher_name){
        if(teacher_student_database.containsKey(teacher_name))
            return new ArrayList<>(teacher_student_database.get(teacher_name));
        return new ArrayList<>();
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(student_database.keySet());
    }

    public void deleteTeacherByName(String teacher_name) throws NullPointerException {
        if(teacher_database.containsKey(teacher_name))
            teacher_database.remove(teacher_name);
        if(teacher_student_database.containsKey(teacher_name))
            teacher_student_database.remove(teacher_name);
    }

    public String deleteAllTeachers() throws NullPointerException {
        teacher_student_database.clear();
        teacher_database.clear();
        return "All Teachers Deleted";
    }

}

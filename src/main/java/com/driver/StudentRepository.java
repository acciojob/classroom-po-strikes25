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
        for(String stud : student_database.keySet()){
            Student student_details = student_database.get(stud);
            if(student_details.getName().equals(student_name))
                return student_details;
        }
        return null;
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
        for(String teach : teacher_student_database.keySet()){
            List<String> students = teacher_student_database.get(teach);
            return students;
        }
        return null;
    }

    public List<String> getAllStudents(){
        List<String> all_students = null;
        for(String stud : student_database.keySet()) {
            Student student_details = student_database.get(stud);
            all_students.add(student_details.getName());
        }
        return all_students;
    }

    public void deleteTeacherByName(String teacher_name) {
        for(String teach : teacher_database.keySet()) {
            if(teach.equals(teacher_name)) {
                teacher_database.remove(teach);
                if(teacher_student_database.containsKey(teacher_name))
                    teacher_student_database.remove(teach);
            }
        }
    }

    public String deleteAllTeachers(){
        teacher_student_database.clear();
        teacher_database.clear();
        return "All Teachers Deleted";
    }

}

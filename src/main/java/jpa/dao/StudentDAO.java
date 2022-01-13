package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {

    List<Student>  getAllStudents();

    Student getStudentByEmail(String sEmail);

    boolean validateStudent(String sEmail, String sPassword);

    void registerStudentToCourse(String sEmail, int cID);

    List<Course> getStudentCourses(String sEmail);
    /*These do not return errors, but I'm not sure the return type is supposed to be included
    List<Student> getAllStudents();
    Student getStudentByEmail();
    boolean validateStudent();
    void registerStudentToCourse();
    getStudentCourses();*/



}

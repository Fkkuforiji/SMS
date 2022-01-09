package jpa.dao;

import java.util.List;

public interface StudentDAO {

    getAllStudents(){
        return List<Student>;
    }
    getStudentByEmail(String sEmail){
        return Student;
    }
    validateStudent(String sEmail, String sPassword) {
        return boolean;
    }
    registerStudentToCourse(String sEmail, int cID){
        return void;
    }
    getStudentCourses;
    }
}

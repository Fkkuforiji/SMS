package jpa.Service;

import java.util.List;

import jpa.dao.StudentDAO;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import javax.persistence.*;
import java.sql.*;


public class StudentService implements StudentDAO {




    @Override
    public List<Student> getAllStudents() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
            String sql = "SELECT s FROM Student s";
            // set this to use the correct entity
            TypedQuery<Student> query = em.createQuery(sql, Student.class);
            List<Student> Students = query.getResultList();
            return Students;
        } catch (Exception e) {
            return null;
        }
        finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
//            String sql = "SELECT s FROM Student s WHERE Email = :Email";
//            //SQL QUERY GOAL: select a student using their email
//            TypedQuery<Student> query = em.createQuery(sql, Student.class);
//            // ^^set this to use the correct entity
//            query.setParameter("Email", sEmail);
//            Student StudentEmail = query.getSingleResult();
            Student StudentEmail = em.find(Student.class, sEmail);
            return StudentEmail;

        } catch (Exception e) {
            System.out.println("findByEmail : " + e.getMessage());
            return null;
        }finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
            String sql = "SELECT s FROM Student s WHERE s.sEmail= :Email and s.sPassword = :Password";
            //SQL QUERY GOAL: to select a student using their connected email and password
            // set this to use the correct entity
            TypedQuery<Student> query = em.createQuery(sql, Student.class);
            query.setParameter("Email", sEmail);
            query.setParameter("Password", sPassword);

            List<Student> ValidStudent = query.getResultList();
            return true; //Instruction: Return whether or not student was found. What should this be returning if not 'boolean' or validStudent?
        } catch (Exception e) {
            return false;//Instruction: Return whether or not student was found. Thought: Both should return true?
        }finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public void registerStudentToCourse(String sEmail, int cID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
            //String sql = "SELECT sc.email, sc.courseID FROM Student_Courses sc where sc.sEmail = :Email and sc.cID = :cID";
            String  sql = "SELECT s FROM Student_Courses WHERE s.Student_ID = :email and s.c_ID = :ID";
            //^^ Is this the correct Select statement? Maybe create a joined table in SQL and test and joined queries?
            //SQL QUERY GOAL: To find out if a student with the selected email is in a course using the courses ID
            TypedQuery<Student> query = em.createQuery(sql, Student.class);
            // ^^ set this to use the correct entity, Student
            query.setParameter("email", sEmail);
            query.setParameter("ID", cID);
            List<Student> CoursesAttending = query.getResultList();
            //There should not be a return according to error. Am I just getting the result and should remove the return?
            // What about the exception block?
        } catch (Exception e) {
            //empty catch
        }finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
            String sql = "SELECT sc FROM Student s JOIN s.Courses sc WHERE s.sEmail= :Email";
            //SQL QUERY GOAL: select the courses a student in registered for using student email
            //Does this query provide the select statement give the needed result?

            TypedQuery<Course> query = em.createQuery(sql, Course.class);
            // set this to use the correct entity, Course
            query.setParameter("Email", sEmail);
            List<Course> studentCourses = query.getResultList();
           return studentCourses;//<< states return is redundant. Instruction: Return whether or not student was found. What should this be returning if not 'boolean' or validStudent?
        } catch (Exception e) {
            return null;
        }finally {
            em.close();
            emf.close();
        }

    }
}
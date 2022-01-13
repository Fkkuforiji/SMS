package jpa.Service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.*;
import java.util.List;

public class CourseService implements CourseDAO {

    //private EntityManager em;

    public CourseService() {
        // set this to use the correct persistence unit from persistence.xml
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
      //  em = emf.createEntityManager();
    }

    @Override//https://www.baeldung.com/java-avoid-null-check keep from getting null pointer exception < maybe?
    public List<Course> getAllCourses() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SMS");
        EntityManager em = emf.createEntityManager();
        try {
            String sql = "SELECT c FROM Course c";
            //Is this going to give me the course names?
            //SQL QUERY GOAL: To return all the courses names
           // TypedQuery<Course> query = em.createQuery(sql, Course.class);
            Query query = em.createQuery(sql);
            // set this to use the correct entity, Course
            List<Course> Courses = query.getResultList();
            return Courses; //Courses keep returning to null instead of giving courses. Debugging says courses are not mapped???
        } catch (Exception e) {
            return null;
        }
        finally{
            em.close();
            emf.close();
        }
    }
}



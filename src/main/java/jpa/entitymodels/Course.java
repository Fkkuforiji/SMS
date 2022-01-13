package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "course")
//@GeneratedValue(strategy = GenerationType.IDENTITY) -- What is this???
public class Course {
    @Id
    @Column(name = "ID")
    private int cID;
    @Column(name = "Name")
    private String cName;
    @Column(name = "Instructor")
    private String cInstructorName;


@ManyToMany(mappedBy = "Courses")
List<Student> Students = new ArrayList<>(); //how to join this with student many to many

    public List<Student> getStudents() {

        return Students;
    }

    public void setStudents(List<Student> students) {
        Students = students;
    }


    public Course(int cID, String cName, String cInstructorName) {
        this.cID = cID;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcID() {
        return cID;
    } //Ask why it says method is never used

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {

        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }


    //hash and equal
}

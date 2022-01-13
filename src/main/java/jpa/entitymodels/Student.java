package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "Email")
    private String sEmail;
    @Column(name = "Name")
    private String sName;
    @Column(name = "Password")
    private String sPassword;



    @ManyToMany
    @JoinTable(name = "Student_Courses",
    joinColumns = @JoinColumn(name = "Student_ID", referencedColumnName = "email"),//student isn't a column, name it student or student_id or email?
    inverseJoinColumns = @JoinColumn(name = "c_ID", referencedColumnName = "ID"))//courses isn't a column, name it course or course_id?
    List<Course> Courses = new ArrayList<>();


    public Student(){

    }
    public List<Course> getCourses() {
        return Courses;
    }

    //-- How to join two tables with nothing in common. -- ^^ is this correct? Learning Source: https://www.baeldung.com/jpa-many-to-many

    public Student(String sEmail, String sName, String sPassword, List Courses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPassword = sPassword;
        this.Courses = Courses;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public void setCourses(List Courses) {
        this.Courses = Courses;
    }
}

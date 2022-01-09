package jpa.entitymodels;

import java.util.List;

public class Student {
    private String sEmail;
    private String sName;
    private String sPassword;
    private List sCourses;

    public Student(String sEmail, String sName, String sPassword, List sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPassword = sPassword;
        this.sCourses = sCourses;
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

    public List getsCourses() {
        return sCourses;
    }

    public void setsCourses(List sCourses) {
        this.sCourses = sCourses;
    }
}

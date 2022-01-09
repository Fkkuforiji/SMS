package jpa.entitymodels;

public class Course {
    private Integer cID;
    private String cName;
    private String cInstructorName;


    public Course(Integer cID, String cName, String cInstructorName) {
        this.cID = cID;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public Integer getID() {
        return cID;
    }

    public void setID(Integer cID) {
        this.cID = cID;
    }

    public String getName() {
        return cName;
    }

    public void setName(String cName) {
        this.cName = cName;
    }

    public String getInstructorName() {
        return cInstructorName;
    }

    public void setInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}

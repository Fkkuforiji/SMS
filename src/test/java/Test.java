import jpa.Service.StudentService;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void validateStudentIsCorrect(){
        StudentService studentService = new StudentService();
        boolean expectedoutput = studentService.validateStudent("cjaulme9@bing.com", "FnVklVgC6r6");
        Assert.assertTrue(expectedoutput);
    }
}

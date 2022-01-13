
package jpa.mainrunner;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.Service.CourseService;
import jpa.Service.StudentService;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;




/**1
 *
 * @author Harry
 *
 */
public class SMSRunner {

    private Scanner sin;
    private StringBuilder sb;

    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner() {
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
    }


    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run()  {
        // Login or quit
        switch (menu1()) {
            case 1:
                if (studentLogin()) {
                    registerMenu();
                }
                break;
            case 2:
                out.println("Goodbye!");
                break;

            default:

        }
    }

    private int menu1() {
        sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        return sin.nextInt();
    }

    private boolean studentLogin() {
        boolean retValue = false;
        out.print("Enter your email address: ");
        String email = sin.next();
        out.print("Enter your password: ");
        String password = sin.next();

        Student students = studentService.getStudentByEmail(email);
        if (students != null) {
            currentStudent = students;
        }

        if (currentStudent != null && currentStudent.getsPassword().equals(password)) {
            List<Course> Courses = studentService.getStudentCourses(email);
            out.println("MyClasses");
            for (Course course : Courses) {
                out.println(course);
            }
            retValue = true;
        } else {
            out.println("User Validation failed. GoodBye!");
        }
        return retValue;
    }

    private void registerMenu() {
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        out.print(sb.toString());
        sb.delete(0, sb.length());

        switch (sin.nextInt()) {
            case 1:
                List<Course> Courses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getsEmail());
                Courses.removeAll(studentCourses);
                out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                for (Course course : Courses) {
                    out.println(course);
                }
                out.println();
                out.print("Enter Course Number: ");
                int number = sin.nextInt();
                Course newCourse = courseService.getAllCourses().get(number);
                //What was before= courseService.GetCourseById(number).get(0);
                if (newCourse != null) {
                    studentService.registerStudentToCourse(currentStudent.getsEmail(), newCourse.getcID());
                    Student temp = studentService.getStudentByEmail(currentStudent.getsEmail());


                    out.println("MyClasses");
                    for (Course course : studentCourses) {
                        out.println(course);
                    }
                }
                break;
            case 2:
            default:
                out.println("Goodbye!");
        }
    }
}

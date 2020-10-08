package gradebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import student.Student;

class GradebookTest {
    @Test
    public void testGradebookCreation() {
        // create a new gradebook
        //   with a course name
        // add an assignment to the gradebook
        // add a student to the gradebook
        Gradebook gradebook = new Gradebook("COP3330");
        assertEquals("COP3330", gradebook.getCourseName());
    }

    /*
    @Test
    public void testAddAssignmentToGradebook() {
        // Given
        Gradebook gradebook = new Gradebook("COP3330");
        Assignment assignment1 = new Assignment("Assignment 1", "Oct 10, 2020", 0.1, 100);

        // when
        gradebook.addAssignment(assignment1);

        // then
        Assignment a = gradebook.getAssignmentByName("Assignment 1");
        assertEquals("Assignment 1", a.getName());
    }

    @Test
    public void testAddStudentToGradebook() {
        // given that I have a gradebook and a student
        Gradebook gradebook = new Gradebook("COP3330");
        Student student1 = new Student("a12345678", "Aaron Anderson");

        // when I add the student to the gradebook
        gradebook.addStudent(student1);

        // then I should be able to find the student by studentId
        Student s = gradebook.getStudentById("a12345678");
        assertEquals("a12345678", s.getId());
    }

    @Test
    public void testAssignmentCreation() {
        // Given an assignment object
        Assignment assignment1;

        // when that object is initialized
        assignment1 = new Assignment("Assignment 1", "Oct 10, 2020", 0.1, 100);

        // then
        assertEquals("Assignment 1", assignment1.getName());
        assertEquals("Oct 10, 2020", assignment1.getDueDate());
        assertEquals(0.1, assignment1.getWeight());
        assertEquals(100, assignment1.getMaxScore());

        assertEquals("Assignment Object with [Name: Assignment 1; Due Date: Oct 10, 2020; Weight: 0.1; Max Score: 100]", assignment1.toString());
    }



*/
    @Test
    public void testAssignmentCreationNameIsCorrect() {
        Assignment assignment1  = new Assignment("Assignment 1", "Oct 10, 2020", 0.1, 100);
        assertEquals("Assignment 1", assignment1.getName());
    }

    @Test
    public void testAssignmentCreationDueDateIsCorrect() {
        Assignment assignment1  = new Assignment("Assignment 1", "Oct 10, 2020", 0.1, 100);
        assertEquals("Oct 10, 2020", assignment1.getDueDate());
    }

    @Test
    public void testStudentCreation() {
        Student student1 = new Student("a12345678", "Aaron Anderson");
        assertEquals("a12345678", student1.getId());
        assertEquals("Aaron Anderson", student1.getName());
    }

}
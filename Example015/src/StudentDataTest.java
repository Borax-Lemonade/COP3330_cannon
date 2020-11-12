import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataTest {
    @Test
    public void creatingStudentDataWithValidNameAndGradeSucceeds() {
        StudentData sd = new StudentData("bob", "A");

        assertEquals("bob", sd.getName());
        assertEquals("A", sd.getGrade());
    }

    @Test
    public void creatingStudentDataWithValidNameAndAGradeSucceeds() {
        StudentData sd = new StudentData("bob", "A");
        assertEquals("A", sd.getGrade());
    }

    @Test
    public void creatingStudentDataWithValidNameAndBGradeSucceeds() {
        StudentData sd = new StudentData("bob", "B");
        assertEquals("A", sd.getGrade());
    }

   @Test
    public void creatingStudentDataFailsWithValidNameAndInvalidGrade() {
        assertThrows(InvalidGradeException.class, () -> new StudentData("bob", "Z"));
    }

    @Test
    public void creatingStudentDataFailsWithInvalidNameAndInvalidGrade() {
        assertThrows(InvalidNameException.class, () -> new StudentData("", ""));
    }

    @Test
    public void creatingStudentDataFailsWhenNameIsShort() {
        assertThrows(InvalidNameException.class, () -> new StudentData("", "A"));
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataTest {
    @Test
    public void creatingStudentDataWithValidNameAndGradeSucceeds() {
        assertDoesNotThrow(() -> new StudentData("bob", "A"));
    }

    @Test
    public void creatingStudentDataWithValidNameAndAGradeSucceeds() {
        assertDoesNotThrow(() -> new StudentData("bob", "A"));
    }

    @Test
    public void creatingStudentDataWithValidNameAndBGradeSucceeds() {
        assertDoesNotThrow(() -> new StudentData("bob", "B"));
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
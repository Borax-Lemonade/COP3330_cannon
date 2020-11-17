package COP3330_cannon.cannon_p4;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static class TaskItem{String, String, String, Boolean};
public class TaskListTest{

    public TaskListTest() {
        listOfTasks = new ArrayList<>();
    }
    TaskItem test = new TaskItem("title", "descriptiontest", "2020-12-18", false);

    List<TaskItem> listOfTasks;

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(DateTimeException.class, () -> new TaskItem("title","descriptiontest", "f", false));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "descriptiontest", "2020-12-12", false));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem("title", "descriptiontest", "2020-12-18", false));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem("title", "descriptiontest", "2020-12-18", false));
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertThrows(DateTimeException.class, () -> test.setDate("2021"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow(() ->test.setDate("2021-03-09"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        assertThrows(InvalidTitleException.class, () -> test.setTitle(""));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> test.setTitle("FRICKING POG"));
    }
}

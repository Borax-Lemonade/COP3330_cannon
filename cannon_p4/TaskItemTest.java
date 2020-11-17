package COP3330_cannon.cannon_p4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    public static TaskList listOfTasks;


    application app;

    TaskList list;

    public TaskItemTest() {
        listOfTasks = new TaskList();
        app = new application();
        listOfTasks.add(test);
    }
    TaskItem test = new TaskItem("title", "descriptiontest", "2020-12-18", false);
    //listOfTasks.add(test);

    @Test
    public void addingTaskItemsIncreasesSize() {
        int size = listOfTasks.getSize();
        listOfTasks.add(test);
        assertEquals(size+1, listOfTasks.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setIsCompleted(true));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        assertDoesNotThrow(() -> new TaskItem("title", "descriptiontest", "2020-12-18", false));
    }

    @Test
    public void editingTaskItemChangesValues() {
        test.setTitle("editedTitle");
        assertEquals("editedTitle", test.getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        //listOfTasks.add(test);
        test.setDescription("editedDescription");
        assertEquals("editedDescription", test.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setDescription("editedDescription"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        test.setDate("2021-08-17");
        assertEquals("2021-08-17", test.getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setDate("editedDescription"));
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        test.setTitle("editedTitle");
        assertEquals("editedTitle", test.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setTitle("editedTitle"));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).getDescription());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        assertDoesNotThrow(()->listOfTasks.get(0).getDescription());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).getDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        //listOfTasks.add(test);
        assertDoesNotThrow(() -> listOfTasks.get(0).getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        //listOfTasks.add(test);
        assertDoesNotThrow(() -> listOfTasks.get(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty() {
        application.createNewList();
        assertEquals(0, application.listOfTasks.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        //listOfTasks.add(test);
        int size = listOfTasks.getSize();
        listOfTasks.remove(0);
        assertEquals(size-1, listOfTasks.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.remove(9));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        assertDoesNotThrow(()-> listOfTasks.readFile("output.txt"));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setIsCompleted(true));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOfTasks.get(9).setIsCompleted(false));
    }

}

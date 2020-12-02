package COP3330_cannon.cannon_p5;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskAppTest {

    //TaskItem test = new TaskItem("title", "descriptiontest", "2020-12-18", false);

    List<TaskItem> listOfTasks;

    @Test
    public void creatingTaskListSucceeds(){
        assertDoesNotThrow( () -> listOfTasks = new ArrayList<TaskItem>());
    }
}

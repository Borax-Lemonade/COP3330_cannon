package COP3330_cannon.cannon_p5;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    public static TaskList listOfTasks;


    TaskApp app;

    TaskList list;

    public TaskItemTest() {
        listOfTasks = new TaskList();
        app = new TaskApp();
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
        TaskApp.createNewList();
        assertEquals(0, app.listOfTasks.getSize());
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

    public static class TaskList extends TaskApp {
        List<TaskItem> listOfTasks;

        public TaskList() {
            listOfTasks = new ArrayList<>();
        }


        protected static TaskItem getTaskItem() {

            TaskItem data;// = new TaskItem(null, null, null, null);
            while(true) {
                try {
                    String title = getTaskTitle();
                    String description = getTaskDescription();
                    String date = getTaskDate();
                    Boolean isCompleted = getTaskIsCompleted();

                    data = new TaskItem(title, description, date, isCompleted);
                    break;
                } catch (InvalidTitleException ex) {
                    System.out.println("Warning: task not created: Title must be at least one character ");
                }catch (PhoneNumberException ex) {
                    System.out.println("Warning: task not created: date must be in yyyy-mm-dd format");
                }
            }
            return data;
            //return data = new TaskItem(title, description, date, isCompleted);
        }

        protected static void processTaskItems() {
            //input.nextLine();
            TaskItem data = getTaskItem();

            storeTaskData(data);
        }
        protected static void storeTaskData(TaskItem data) {TaskApp.listOfTasks.add(data);}

        public void add(TaskItem data) {listOfTasks.add(data);}

        public void remove(int index) {listOfTasks.remove(index);}

        public void changeStatusToTrue(int index) {
            if(get(index).getIsCompleted() == false)
                listOfTasks.get(index).setIsCompleted(true);
            else
                throw new IllegalArgumentException();
        }
        public void changeStatusToFalse(int index) {
            if(get(index).getIsCompleted() == true)
                listOfTasks.get(index).setIsCompleted(false);
            else
                throw new IllegalArgumentException();
        }

        public TaskItem get(int index) {
            return listOfTasks.get(index);
        }
        public int getSize() {
            return listOfTasks.size();
        }

        public void readFile(String filename)  {
            TaskItem data;
            String temp[];
            try (Scanner fileInput = new Scanner(Paths.get(filename))){
                int i = 0;

                while(fileInput.hasNextLine()) {
                   temp = fileInput.nextLine().split(",", 4);

                   data = new TaskItem(temp[2], temp[1], temp[0], Boolean.parseBoolean(temp[3]));

                    if(temp[3].contains("true"))
                        data.setIsCompleted(true);
                    else
                        data.setIsCompleted(false);

                   listOfTasks.add(data);
               }
            } catch (IOException | NoSuchElementException |
                    IllegalStateException e) {
                System.out.println("Error reading file.");
            }

        }

        /*public void createFile(String filename) {
            try {
                File output = new File(filename);
                if (output.createNewFile()) {
                    System.out.println("File created: " + output.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }*/
        public void writeToFile(String filename) {
            try(Formatter output = new Formatter(filename)) {
                File fileOutput = new File(filename);
                fileOutput.createNewFile();

                for(int i = 0; i < listOfTasks.size(); i++) {
                    TaskItem data = listOfTasks.get(i);
                    output.format("%s, %s, %s, %s\n", data.getDate(), data.getTitle(), data.getDescription(), data.getIsCompleted());
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Unable to find the file...");
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }
        public void writeToConsole() {
            System.out.println("Current Tasks");
            for(int i = 0; i < listOfTasks.size(); i++) {
                TaskItem data = listOfTasks.get(i);
                if(data.getIsCompleted() == true) {
                    System.out.print("*** ");
                }
                System.out.printf("%d) [%s] %s:  %s\n", i, data.getDate(), data.getTitle(), data.getDescription());
            }
        }
        public void writeToConsoleCompletedTasks() {
            System.out.println("Completed Tasks");
            for(int i = 0; i < listOfTasks.size(); i++) {
                TaskItem data = listOfTasks.get(i);
                if(data.getIsCompleted()) {
                    System.out.print("*** ");
                    System.out.printf("%d) [%s] %s:  %s\n", i, data.getDate(), data.getTitle(), data.getDescription());
                }
            }
        }
        public void writeToConsoleUncompletedTasks() {
            System.out.println("Uncompleted Tasks");
            for(int i = 0; i < listOfTasks.size(); i++) {
                TaskItem data = listOfTasks.get(i);
                if(!data.getIsCompleted()) {
                    System.out.printf("%d) [%s] %s:  %s\n", i, data.getDate(), data.getTitle(), data.getDescription());
                }
            }
        }
    }
}

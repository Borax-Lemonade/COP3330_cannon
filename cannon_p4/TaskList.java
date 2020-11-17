package COP3330_cannon.cannon_p4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TaskList extends application{
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
            } catch (InvalidDescriptionException ex) {
                System.out.println("Warning: task not created: Description must be at least one character");
            }catch (DateTimeException ex) {
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
    protected static void storeTaskData(TaskItem data) {application.listOfTasks.add(data);}

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

package COP3330_cannon.cannon_p5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;


public class TaskItem {
    private String title;
    private String description;
    private String date;
    private Boolean isCompleted;

    public TaskItem(String title, String description, String date, Boolean isCompleted) {
        if (isTitleValid(title)) {
            this.title = title;
        } else {
            //throw new IllegalArgumentException();
            throw new InvalidTitleException("title is not valid; must be at least 1 character long");
        }

        this.description = description;

        if(isDateValid(date)) {
            this.date = date;
        } else {
            //throw new IllegalArgumentException();
            throw new PhoneNumberException("Please enter a valid yyyy-mm-dd date");
        }
        this.isCompleted = false;
    }
    TaskApp app = new TaskApp();


    public boolean isTitleValid(String title) {

        return title.length() > 0;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");

    public boolean isDateValid(String date) {
        //return LocalDate.parse(date, DateTimeFormatter.ofPattern("uuu-M-d").withResolverStyle(ResolverStyle.STRICT));
        try {
            LocalDate
                    .parse(date, DateTimeFormatter.ofPattern("uuuu-M-d")
                            .withResolverStyle(ResolverStyle.STRICT))
                    .isBefore(LocalDate.now());
            return true;
        }
        catch (DateTimeParseException | PhoneNumberException e) {
            System.out.println("Enter a valid date");
            return false;
        }
    }



    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        if(isTitleValid(title))
            this.title = title;
        else {
            throw new InvalidTitleException("title is not valid; must be at least 1 character long");
        }
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description)  {
        this.description = description;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        if (isDateValid(date))
            this.date = date;
        else
            throw new PhoneNumberException("broski");
    }

    public Boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean complete) {
        this.isCompleted = complete;
    }
}

class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
}

class DateTimeException extends IllegalArgumentException {
    public DateTimeException(String msg) { super(msg);}
}

class InvalidIndex extends IllegalArgumentException {
    public InvalidIndex(String msg) {
        super(msg);
    }
}
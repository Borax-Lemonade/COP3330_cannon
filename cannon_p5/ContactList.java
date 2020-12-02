package COP3330_cannon.cannon_p5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static COP3330_cannon.cannon_p5.ContactApp.*;

public class ContactList {
    static List<ContactItem> listOfContacts;

    public ContactList() {
        listOfContacts = new ArrayList<>();
    }


    protected static ContactItem getContactItem() {

        ContactItem data = null;
            try {
                String firstName = getContactFirstName();
                String lastName = getContactLastName();
                String number = getContactNumber();
                String email = getContactEmail();

                if (firstName.equals("") && lastName.equals("") && number.equals("") && email.equals("")) {
                    System.out.println("All fields cannot be null; contact not created");
                    data = null;
                    throw new InvalidItemException("brushsdf");
                }
                else
                    data = new ContactItem(firstName, lastName, number, email);

            } catch (InvalidItemException ex) {
                System.out.println("All fields cannot be null");
            }
        return data;
    }

    public static void processTaskItems() {
        //input.nextLine();
        ContactItem data = getContactItem();

        add(data);
    }

    public static boolean editItem(String fname, String lname, String pNumber, String email) throws InvalidItemException {
        if(fname.equals("") && lname.equals("") && pNumber.equals("") && email.equals(""))
            throw new InvalidItemException("I-");
        else
            return true;
    }
    public static void add(ContactItem data) {listOfContacts.add(data);}

    public void remove(int index) {listOfContacts.remove(index);}

    public ContactItem get(int index) {
        return listOfContacts.get(index);
    }
    public int getSize() {
        return listOfContacts.size();
    }

    public void readFile(String filename)  {
        ContactItem data;
        String temp[];
        try (Scanner fileInput = new Scanner(Paths.get(filename))){
            int i = 0;

            while(fileInput.hasNextLine()) {
                temp = fileInput.nextLine().split(",", 4);

                data = new ContactItem(temp[0], temp[1], temp[2], temp[3]);

                add(data);
            }
        } catch (IOException | NoSuchElementException | IllegalStateException | InvalidItemException e) {
            System.out.println("Error reading file.");
        }

    }

    public void writeToFile(String filename) {
        try(Formatter output = new Formatter(filename)) {
            File fileOutput = new File(filename);
            fileOutput.createNewFile();

            for(int i = 0; i < listOfContacts.size(); i++) {
                ContactItem data = listOfContacts.get(i);
                output.format(data.toString());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
    public void writeToConsole() {
        System.out.println("Current Tasks");
        for(int i = 0; i < listOfContacts.size(); i++) {
            ContactItem data = listOfContacts.get(i);
            System.out.printf("%d) Name: %s %s%nPhone: %s%nEmail: %s\n", i, data.getFirstName(), data.getLastName(), data.getPhoneNumber(), data.getEmail());
        }
    }
}

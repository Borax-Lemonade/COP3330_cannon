package COP3330_cannon.cannon_p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    public ContactList listOfContacts = new ContactList();

    //listOfContacts = new ArrayList<ContactItem>();

    //List<ContactItem> listOfContacts;

    ContactItem test = new ContactItem("rebecca", "cannon", "321-321-3211", "rebeccacan@gmail.com");

    public ContactListTest() throws InvalidItemException {
    }


    @Test
    public void addingItemsIncreasesSize() {
        //int size = listOfContacts.getSize();
        int size = listOfContacts.getSize();
        listOfContacts.add(test);
        size+=1;
        assertEquals(size, listOfContacts.getSize());
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        assertThrows(InvalidItemException.class, ()->listOfContacts.editItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> listOfContacts.editItem("rebecca", "cannons", "321-321-3211", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> listOfContacts.editItem("", "cannon", "321-321-3211", "rebeccacan@gmail.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> listOfContacts.editItem("rebecca", "", "321-321-3211", "rebeccacan@gmail.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> listOfContacts.editItem("rebecca", "cannon", "", "rebeccacan@gmail.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> listOfContacts.editItem("rebeccca", "cannon", "321-321-3211", "rebeccacan@gmail.com"));
    }
    @Test
    public void newListIsEmpty() {
        ContactList testOfContacts = new ContactList();
        assertEquals(0,testOfContacts.getSize());
    }

    @Test
    public void removingItemsDecreasesSize() {
        int size;
        listOfContacts.add(test);
        size = listOfContacts.getSize();
        listOfContacts.remove(0);
        size-=1;
        assertEquals(size, listOfContacts.getSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        assertThrows(InvalidIndex.class, () -> listOfContacts.remove(9));
    }

    @Test
    public void savedContactListCanBeLoaded() {
        listOfContacts.writeToFile("contacts.txt");
        assertDoesNotThrow(() -> listOfContacts.readFile("contacts.txt"));
    }
}

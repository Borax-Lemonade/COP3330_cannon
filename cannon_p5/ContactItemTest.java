package COP3330_cannon.cannon_p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    public static ContactList listOfContacts;

    ContactItem test = new ContactItem("Rebecca", "Cannon", "321-321-3211", "rebeccacan@gmail.com");

    public ContactItemTest() throws InvalidItemException {

    }

    @Test
    public void creationFailsWithAllBlankValues() {
        //test = new ContactItem("", "", "", "");
        assertThrows(InvalidItemException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        //test = new ContactItem("rebecca", "cannon", "321-321-3211", "");
        assertDoesNotThrow(() -> new ContactItem("rebecca", "cannon", "321-321-3212", ""));
        //assertNotNull(test);
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("", "cannon", "321-321-3211", "rebeccacan@gmail.com"));
    }
    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("rebecca", "", "321-321-3211", "rebeccacan@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow(() -> new ContactItem("rebecca", "cannon", "", "rebeccacan@gmail.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("rebecca", "cannon", "321-321-3211", "rebeccacan@gmail.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        assertThrows(InvalidItemException.class, ()->listOfContacts.editItem("", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> listOfContacts.editItem("rebecca", "cannon", "321-321-3211", ""));
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
    public void testToString() {
        assertEquals("Rebecca,Cannon,321-321-3211,rebeccacan@gmail.com", test.toString());
    }
}

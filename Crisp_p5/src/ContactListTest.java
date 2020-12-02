import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactItem item = new ContactItem("", "", "", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertTrue(contacts.getListSize() > 0);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertThrows(IllegalArgumentException.class, ()->contacts.editContactItem(0, "","",
                                                                                    "",""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()->contacts.editContactItem(1, "","",
                "",""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertDoesNotThrow(()->contacts.editContactItem(0, "","Kyle",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem("", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertDoesNotThrow(()->contacts.editContactItem(0, "bat@at.at","",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertDoesNotThrow(()->contacts.editContactItem(0, "bat@at.at","Kyle",
                "","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertDoesNotThrow(()->contacts.editContactItem(0, "bat@at.at","Kyle",
                "Crisp",""));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertDoesNotThrow(()->contacts.editContactItem(0, "bat@at.at","Kyle",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithExpectedEmail(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        contacts.editContactItem(0, "bat@at.at","",
                "","");

        assertEquals(contacts.getContactItem(0).getEmail(), "bat@at.at");
    }

    @Test
    public void editingSucceedsWithExpectedFirstName(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        contacts.editContactItem(0, "","Kyle",
                "","");

        assertEquals(contacts.getContactItem(0).getFirstName(), "Kyle");
    }

    @Test
    public void editingSucceedsWithExpectedLastName(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        contacts.editContactItem(0, "","",
                "Crisp","");

        assertEquals(contacts.getContactItem(0).getLastName(), "Crisp");
    }

    @Test
    public void editingSucceedsWithExpectedPhone(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        contacts.editContactItem(0, "","",
                "","222-222-2222");

        assertEquals(contacts.getContactItem(0).getPhoneNumber(), "222-222-2222");
    }

    @Test
    public void newListIsEmpty(){
        ContactList contacts = new ContactList();

        assertTrue(contacts.getListSize() == 0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);
        contacts.add(item);

        contacts.remove(0);

        assertTrue(contacts.getListSize() == 1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactItem item = new ContactItem("First", "Last", "111-111-1111", "at@at.at");
        ContactList contacts = new ContactList();

        contacts.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()->contacts.remove(1));

    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contacts = new ContactList();
        ContactApp app = new ContactApp();

        contacts = app.loadDataFromFile("contact.txt");

        ContactItem contact = contacts.getContactItem(0);

        assertEquals(contact.getFirstName(), "Kyle");
        assertEquals(contact.getLastName(), "Crisp");
        assertEquals(contact.getPhoneNumber(), "111-111-1111");
        assertEquals(contact.getEmail(), "at@at.at");

    }
}

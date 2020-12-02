import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, () ->new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(() ->new ContactItem("First", "Last", "phone", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(() ->new ContactItem("", "Last", "phone", "at@at.at"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(() ->new ContactItem("First", "", "phone", "at@at.at"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(() ->new ContactItem("First", "Last", "", "at@at.at"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(() ->new ContactItem("First", "Last", "phone", "at@at.at"));
    }

    @Test
    public void creationSucceedsWithExpectedEmail(){
        ContactItem contact = new ContactItem("", "", "", "at@at.at");

        assertEquals(contact.getEmail(), "at@at.at");
    }

    @Test
    public void creationSucceedsWithExpectedFirstName(){
        ContactItem contact = new ContactItem("First", "", "", "");

        assertEquals(contact.getFirstName(), "First");
    }

    @Test
    public void creationSucceedsWithExpectedLastName(){
        ContactItem contact = new ContactItem("", "Last", "", "");

        assertEquals(contact.getLastName(), "Last");
    }

    @Test
    public void creationSucceedsWithExpectedPhone(){
        ContactItem contact = new ContactItem("", "", "111-111-1111", "");

        assertEquals(contact.getPhoneNumber(), "111-111-1111");
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertThrows(IllegalArgumentException.class, ()->contact.editContact("", "",
                                                                        "",""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertDoesNotThrow(()->contact.editContact("", "Kyle",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertDoesNotThrow(()->contact.editContact("bat@at.at", "",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertDoesNotThrow(()->contact.editContact("bat@at.at", "Kyle",
                "","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertDoesNotThrow(()->contact.editContact("bat@at.at", "Kyle",
                "Crisp",""));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertDoesNotThrow(()->contact.editContact("bat@at.at", "Kyle",
                "Crisp","222-222-2222"));
    }

    @Test
    public void editingSucceedsWithExpectedEmail(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        contact.editContact("bat@at.at", "", "","");

        assertEquals(contact.getEmail(), "bat@at.at");
    }

    @Test
    public void editingSucceedsWithExpectedFirstName(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        contact.editContact("", "Kyle", "","");

        assertEquals(contact.getFirstName(), "Kyle");
    }

    @Test
    public void editingSucceedsWithExpectedLastName(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        contact.editContact("", "", "Crisp","");

        assertEquals(contact.getLastName(), "Crisp");
    }

    @Test
    public void editingSucceedsWithExpectedPhone(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        contact.editContact("", "", "","222-222-2222");

        assertEquals(contact.getPhoneNumber(), "222-222-2222");
    }

    @Test
    public void testToString(){
        ContactItem contact = new ContactItem("First", "Last", "111-111-1111", "at@at.at"
        );

        assertEquals(contact.toString(), "First name: First\n" +
                                                "Last name: Last\n" +
                                                "Email: at@at.at\n" +
                                                "Phone number: 111-111-1111");
    }


}

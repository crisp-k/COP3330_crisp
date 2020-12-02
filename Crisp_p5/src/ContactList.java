import java.util.ArrayList;
import java.util.List;

public class ContactList {
    List<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void add(ContactItem item){
        contacts.add(item);
    }

    public int getListSize(){
        return contacts.size();
    }

    public void editContactItem(int index, String firstName, String lastName, String phoneNumber, String email){
        contacts.get(index).editContact(email, firstName, lastName, phoneNumber);
    }

    public ContactItem getContactItem(int index){
        return contacts.get(index);
    }

    public void remove(int index){
        contacts.remove(index);
    }

}

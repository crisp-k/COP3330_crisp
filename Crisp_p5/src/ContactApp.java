import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);

    private int displayMainMenu(){
        System.out.println("Contact Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n");

        return input.nextInt();
    }

    private int displayOperationMenu(){
        System.out.println("\nList Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n");

        return input.nextInt();
    }

    private void displayContactList(ContactList contacts) {
        System.out.println("Current Contacts\n" +
                "-------------\n");

        int listSize = contacts.getListSize();

        if (listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                String contactInfo = contacts.getContactItem(i).toString();
                System.out.printf("%d) %s\n", i, contactInfo);
            }
        } else {
            System.out.println("No tasks to display");
        }
    }

    private ContactItem createContact(){
        ContactItem contact = null;
        try{
            String firstName = getString("First name: ");
            String lastName = getString("Last name: ");
            String phoneNumber = getString("Phone number (xxx-xxx-xxxx): ");
            String email = getString("Email address (x@y.z): ");

            contact = new ContactItem(firstName, lastName, phoneNumber, email);
        }
        catch(IllegalArgumentException exception){
            System.out.println("Invalid Title entered, please try again");
        }
        catch(DateTimeException exception){
            System.out.println("Invalid Due Date entered, please try again");
        }

        return contact;
    }

    private void editContact(ContactList contacts){
        System.out.print("Which task will you edit? ");
        int index = input.nextInt();
        input.nextLine();

        try {
            String firstName = getEditedString("Enter a new first name: ", index);
            String lastName = getEditedString("Enter a new last name: ",index);
            String phoneNumber = getEditedString("Enter a new phone number (xxx-xxx-xxxx): ", index);
            String email = getEditedString("Enter a new email address (x@y.z): ", index);
            input.nextLine();

            contacts.editContactItem(index, firstName, lastName, phoneNumber, email);
        }
        catch(IllegalArgumentException exception){
            System.out.println("Invalid title, please try again");
        }
        catch(DateTimeException exception){
            System.out.println("Invalid Due Date, please try again");
        }
    }

    private String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private String getEditedString(String prompt, int value){
        System.out.printf(prompt, value);
        return input.nextLine();
    }

    private void deleteContact(ContactList contacts){
        System.out.print("Which contact will you delete? ");
        int index = input.nextInt();
        input.nextLine();

        try {
            contacts.remove(index);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Please enter a valid contact list number");
        }
    }

    private void saveToFile(ContactList contacts){
        String fileName = getString("Enter name of file to save to [include extension]: ");
        try {
            Formatter output = new Formatter(fileName);
            for(int i = 0; i < contacts.getListSize(); i++){
                ContactItem contact = contacts.getContactItem(i);
                output.format("%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                        contact.getPhoneNumber(), contact.getEmail());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
    }

    protected ContactList loadDataFromFile(String fileName){

        ContactList contacts = new ContactList();

        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(fileName));
            String fileLine = inFile.readLine();

            while(fileLine != null) {
                String[] lineData = fileLine.split(";");

                ContactItem contact = new ContactItem(lineData[0], lineData[1], lineData[2], lineData[3]);

                contacts.add(contact);

                fileLine = inFile.readLine();
            }

            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }

        return contacts;
    }

    private void operationMenu(ContactList contacts){
        boolean returnToMain = false;

        do{
            try {
                int operationChoice = displayOperationMenu();
                input.nextLine();

                switch (operationChoice) {
                    case 1 -> displayContactList(contacts);
                    case 2 -> {
                        ContactItem newContact = createContact();
                        if(newContact != null)
                            contacts.add(newContact);
                    }
                    case 3 -> editContact(contacts);
                    case 4 -> deleteContact(contacts);
                    case 5 -> saveToFile(contacts);
                    case 6 -> returnToMain = true;
                    default -> throw new IllegalArgumentException();
                }
            }
            catch(InputMismatchException exception){
                System.out.println("Please enter an integer value");
                input.nextLine();
            }
            catch(IllegalArgumentException exception){
                System.out.println("Invalid menu choice, please try again");
                input.nextLine();
            }

        }while(!returnToMain);

    }

    protected void mainContactMenu(){
        boolean runApp = true;

        do{
            try{
                int menuChoice = displayMainMenu();
                input.nextLine();
                ContactList contacts = new ContactList();

                switch(menuChoice){
                    case 1 -> operationMenu(contacts);
                    case 2 ->{
                        String fileName = getString("Enter name of file to load from [include extension]: ");
                        contacts = loadDataFromFile(fileName);
                        operationMenu(contacts);
                    }
                    case 3 -> runApp = false;
                    default -> throw new IllegalArgumentException();
                }
            }
            catch(InputMismatchException exception){
                System.out.println("Please enter an integer value");
                input.nextLine();
            }
            catch(IllegalArgumentException exception){
                System.out.println("Invalid menu choice, please try again");
                input.nextLine();
            }

        }while(runApp);
    }
}

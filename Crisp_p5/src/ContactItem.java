public class ContactItem {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    public ContactItem(String firstName, String lastName, String phoneNumber, String email){
        if(email.length() <= 0 && firstName.length() <= 0 && lastName.length() <= 0 && phoneNumber.length() <= 0){
            throw new IllegalArgumentException("At least one argument must be given.");
        }
        else{
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void editContact(String email, String firstName, String lastName, String phoneNumber){
        if(email.length() <= 0 && firstName.length() <= 0 && lastName.length() <= 0 && phoneNumber.length() <= 0){
            throw new IllegalArgumentException("At least one argument must be given.");
        }
        else{
            if(email.length() > 0) setEmail(email);
            if(firstName.length() > 0) setFirstName(firstName);
            if(lastName.length() > 0) setLastName(lastName);
            if(phoneNumber.length() > 0) setPhoneNumber(phoneNumber);
        }
    }

    @Override
    public String toString(){
        return String.format("First name: " + firstName + "\nLast name: " + lastName + "\nEmail: " + email +
                              "\nPhone number: " + phoneNumber);
    }
}

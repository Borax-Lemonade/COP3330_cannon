package COP3330_cannon.cannon_p5;

import java.util.regex.Pattern;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        if (isNameValid(firstName)) {
            this.firstName = firstName;
        } else {
            //throw new IllegalArgumentException();
            throw new InvalidTitleException("firstNames is not valid; must be at least 1 character long");
        }

        if (isNameValid(lastName)) {
            this.lastName = lastName;
        } else {
            //throw new IllegalArgumentException();
            throw new InvalidTitleException("last name is not valid; must be at least 1 character long");
        }


        if(isNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            //throw new IllegalArgumentException();
            throw new PhoneNumberException("Please enter a valid yyyy-mm-dd phoneNumber");
        }
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("last name is not valid; must be at least 1 character long");
        }
    }
    ContactApp app = new ContactApp();


    public boolean isNameValid(String name) {

        return name.length() > 0;
    }

    public boolean isNumberValid(String number) {
        try {
            final String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
            if (!Pattern.matches(regexStr, number)) {
                throw new PhoneNumberException(number);
                //return false;
            }

        }
        catch (PhoneNumberException e) {
            System.out.println("Enter a valid date");
            return false;
        }
        return true;
    }
    public boolean isEmailValid(String email) {
        return email.length() > 0;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        if(isNameValid(firstName))
            this.firstName = firstName;
        else {
            this.firstName = null;
            throw new InvalidTitleException("name is not valid; must be at least 1 character long");
        }
    }

    public String getLastName() {
        return this.firstName;
    }
    public void setLastName(String firstName) {
        if(isNameValid(firstName))
            this.lastName = lastName;
        else {
            this.lastName = null;
            throw new InvalidNameException("name is not valid; must be at least 1 character long");
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isNumberValid(phoneNumber))
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = null;
            throw new PhoneNumberException("broski");
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
        else
            this.email = null;
            throw new InvalidEmailException("bruh");
    }

}
class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String msg) {
        super(msg);
    }
}

class PhoneNumberException extends IllegalArgumentException {
    public PhoneNumberException(String msg) { super(msg);}
}

class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}



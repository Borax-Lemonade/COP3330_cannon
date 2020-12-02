package COP3330_cannon.cannon_p5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email) throws InvalidItemException {

        if(firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals("")) {
            throw new InvalidItemException("fuckers");
        }
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);


    }
    ContactApp app = new ContactApp();

    public boolean isNameValid(String name) {
        if(name.length() > 0) {
            return true;
        }
        else {
            throw new InvalidNameException("fucker");
        }
    }
    public boolean isNumberValid(String number) {
        boolean value;
        Pattern pattern = Pattern.compile("^(\\d{3}[-]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(number);

        if(number.equals(""))
            return true;
        return matcher.matches();

    }
    public boolean isEmailValid(String email) {
        final String regexStr = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        if(!Pattern.matches(regexStr, email)) {
            throw new InvalidEmailException("fucker");
        }
        else
            return true;
        /*return email.length() > 0;*/

    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        try {
            if(isNameValid(firstName))
                this.firstName = firstName;
        } catch (InvalidNameException ex) {
            this.firstName = "";
        }
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        try {
            if(isNameValid(lastName))
                this.lastName = lastName;
        } catch (InvalidNameException ex) {
            this.lastName = "";
        }
        /*if(isNameValid(lastName))
            this.lastName = lastName;
        else {
            this.lastName = null;
            //throw new InvalidNameException("name is not valid; must be at least 1 character long");
        }*/
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            if(isNumberValid(phoneNumber))
                this.phoneNumber = phoneNumber;
            else {
                this.phoneNumber = "";
                throw new PhoneNumberException("idek anymore");
            }
        } catch (PhoneNumberException ex) {
            this.phoneNumber = "";
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        try {
            if(isEmailValid(email))
                this.email = email;
            else
                this.email = "";
        } catch (InvalidEmailException ex) {
            this.email = "";
        }
    }

    @Override
    public String toString() {
        return (firstName + "," + lastName + "," + phoneNumber + "," + email);
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

class InvalidItemException extends Throwable {
    public InvalidItemException(String msg) {
    }
}



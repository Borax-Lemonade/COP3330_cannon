import java.util.Scanner;

public class Main {
    private static Scanner scnr = new Scanner(System.in);

    private int x;
    private int y;

    private static boolean isStringNumeric(String str) {
        for(Character ch : str.toCharArray()) {
            if(ch <= '9' && ch >= '0') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private void readX() {
        System.out.println("Enter a number: ");
        String xStr = scnr.next();
        if(!isStringNumeric(xStr)) {
            System.out.println("you did not enter a number");
            return;
        }
        this.x = Integer.parseInt(xStr);
    }

    private void readY() {
        System.out.println("Enter a number: ");
        String xStr = scnr.next();
        if(!isStringNumeric(xStr)) {
            System.out.println("you did not enter a number");
            return;
        }
        this.y = Integer.parseInt(xStr);
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scnr = new Scanner(System.in);

        m.readX();
        m.readY();

        if(m.y != 0) {
            System.out.println(m.x / m.y);
        } else {
            System.out.println("Please enter a non-0 number.");
        }

    }
}

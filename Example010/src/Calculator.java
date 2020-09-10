public class Calculator {
    public long add(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(2, 2));
        System.out.println(c.add(6, -2));
        System.out.println(c.add(-2, -2));
        System.out.println("c.add(" + Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ") = " + c.add(Integer.MAX_VALUE, Integer.MAX_VALUE) + " expected value is " + -2);
    }




}

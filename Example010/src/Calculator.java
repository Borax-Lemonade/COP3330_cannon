import java.util.Random;

public class Calculator {
    public double add(double val1, double val2) {
        return val1 + val2;
    }

    public double sub(double val1, double val2) {
        return val1 - val2;
    }

    public static void f() {
        int[] xs = new int[10];

        // init the array
        for(int i = 0; i < xs.length; i++) {
            xs[i] = 2;
        }

        // to grow the array....

        // copy the array
        int[] ys = new int[xs.length];
        for(int i = 0; i < xs.length; i++) {
            ys[i] = xs[i];
        }

        xs = new int[xs.length * 2];
        for(int i = 0; i < ys.length; i++) {
            xs[i] = ys[i];
        }

        // add element
        xs[10] = 3;

        // print the array
        for(int i = 0; i < xs.length; i++) {
            System.out.print(xs[i] + " ");
        }
    }

    public static void main(String[] args) {
        f();
    }
}

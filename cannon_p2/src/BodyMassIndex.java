public class BodyMassIndex {
    //public static boolean bmiInput;
    public static double bmiInput;
    public static String bmiCategory = "default";

    public BodyMassIndex(double height, double weight) {
       calculateBMI(height, weight);
       determineCategory();
    }

    public static void calculateBMI(double height, double weight) {
        bmiInput = (703*weight)/(Math.pow(height,2));
        bmiInput = Math.round(bmiInput*10);
        bmiInput /= 10;
    }
    public static void determineCategory() {
        if (bmiInput < 18.5)
            bmiCategory = "Underweight";
        if (bmiInput >= 18.5 && bmiInput < 24.9)
            bmiCategory = "Normal";
        if (bmiInput >= 25 && bmiInput < 29.9)
            bmiCategory = "Overweight";
        if (bmiInput >= 30)
            bmiCategory = "Obesity";
    }

}

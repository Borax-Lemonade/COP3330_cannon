package COP3330_cannon.cannon_p1.src;

//import Encrypter;

public class Decrypter {
    Application app = new Application();
    Encrypter commonMethods = new Encrypter();

    public String decrypt(String str) {
        int[] digits = commonMethods.StringToDigitArray(str);
        digits = commonMethods.SwapOneThreeAndTwoFour(digits);
        digits = StepTwoDecrypt(digits);
        str = commonMethods.DigitArrayToString(digits);

        return (str);
    }
    public int[] StepTwoDecrypt(int [] digitsStepOne) {
        for(int i = 0; i < 4; i++) {
            digitsStepOne[i] = ((digitsStepOne[i] + 10)-7)%10;
        }
        return digitsStepOne;
    }
}

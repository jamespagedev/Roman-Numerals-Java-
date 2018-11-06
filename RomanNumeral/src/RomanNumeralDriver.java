import java.util.Scanner;

/**
 * Created by Vako on 10/30/2016.
 */
public class RomanNumeralDriver {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Input integer to get roman numeral: ");
        int num = stdIn.nextInt();

        System.out.println("The roman numeral for " + num + " is: " + RomanNumeral.convertFromInteger(num));
    }
}

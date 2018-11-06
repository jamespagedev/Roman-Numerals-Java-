/**
 * Created by Vako on 10/26/2016.
 */
public class RomanNumeral {
    private static int num;

    private static String extractRomanNumeralsBelowOneMillion (int minNum, int maxNum, int borderNum, String romanNum, String borderRomanNum) {
        String romanNumFound = "";

        while (num >= 1000000) { // adds one or more of "M\u0305" for every million in the integer
            romanNumFound += "M\u0305";
            num -= 1000000;
        }

        while (num <= maxNum && num >= minNum) {
            if (num >= borderNum) {
                romanNumFound += borderRomanNum;
                num -= borderNum;
            } else {
                romanNumFound += romanNum;
                num -= minNum;
            }
        }
        return romanNumFound;
    }

    public static String convertFromInteger (int inputNum) {

        /* Roman Numeral Chart
            1 - I    | 50 - L
            2 - II   | 100 - C
            3 - III  | 500 - D
            4 - IV   | 1000 - M
            5 - V    | 5000 - V\u0305
            6 - VI   | 10000 - X\u0305
            7 - VII  | 50000 - L\u0305
            8 - VIII | 100000 - C\u0305
            9 - IX   | 500000 - D\u0305
            10 - X   | 1000000 - M\u0305
         */

        // Pre-requisite not met, exit method...
        if (inputNum <= 0) {
            return "The number " + inputNum + " cannot be converted into a roman numeral";
        }

        num = inputNum;
        String romanNumeral = "";
        Object RomanNumeralRanges[][] = {
                {500000, 999999, 900000, "D\u0305", "C\u0305M\u0305"},
                {100000, 499999, 400000, "C\u0305", "C\u0305D\u0305"},
                {50000, 99999, 90000, "L\u0305", "X\u0305C\u0305"},
                {10000, 49999, 40000, "X\u0305", "X\u0305L\u0305"},
                {5000, 9999, 9000, "V\u0305", "MX\u0305"},
                {1000, 4999, 4000, "M", "MV\u0305"},
                {500, 999, 900, "D", "CM"},
                {100, 499, 400, "C", "CD"},
                {50, 99, 90, "L", "XC"},
                {10, 49, 40, "X", "XL"}
        };

        for (Object rnRange[]: RomanNumeralRanges) {
            romanNumeral += extractRomanNumeralsBelowOneMillion((int)rnRange[0], (int)rnRange[1], (int)rnRange[2], rnRange[3].toString(), rnRange[4].toString());
        }

        // Extract and add the last value between 1-9 (if 1-9 is left in the integer)
        String baseTenRomanNum[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        romanNumeral += baseTenRomanNum[num];

        return romanNumeral;
    }
}
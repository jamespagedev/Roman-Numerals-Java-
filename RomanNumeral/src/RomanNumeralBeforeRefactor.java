/**
 * Created by Vako on 10/28/2016.
 */
public class RomanNumeralBeforeRefactor {
    public static String convertIntegerToRomanNumeral (int num) {

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

        String baseTenRomanNum[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String romanNumeral = "";

        if (num <= 0) {
            return "The number " + num + " cannot be converted into a roman numeral";
        }

        while (num >= 1000000) { // adds one or more of "M\u0305"
            romanNumeral += "M\u0305";
            num -= 1000000;
        }

        while (num < 1000000 && num >= 500000) { // adds ("C\u0305M\u0305") or (one or more of "D\u0305")
            if (num >= 900000) {
                romanNumeral += "C\u0305M\u0305";
                num -= 900000;
            } else {
                romanNumeral += "D\u0305";
                num -= 500000;
            }
        }

        while (num < 500000 && num >= 100000) { // adds ("C\u0305D\u0305") or (one or more of "C\u0305")
            if (num >= 400000) {
                romanNumeral += "C\u0305D\u0305";
                num -= 400000;
            } else {
                romanNumeral += "C\u0305";
                num -= 100000;
            }
        }

        while (num < 100000 && num >= 50000) { // adds ("X\u0305C\u0305") or (one or more of "L\u0305")
            if (num >= 90000) {
                romanNumeral += "X\u0305C\u0305";
                num -= 90000;
            } else {
                romanNumeral += "L\u0305";
                num -= 50000;
            }
        }

        while (num < 50000 && num >= 10000) { // adds ("X\u0305L\u0305") or (one or more of "X\u0305")
            if (num >= 40000) {
                romanNumeral += "X\u0305L\u0305";
                num -= 40000;
            } else {
                romanNumeral += "X\u0305";
                num -= 10000;
            }
        }

        while (num < 10000 && num >= 5000) { // adds ("MX\u0305") or (one or more of "V\u0305")
            if (num >= 9000) {
                romanNumeral += "MX\u0305";
                num -= 9000;
            } else {
                romanNumeral += "V\u0305";
                num -= 5000;
            }
        }

        while (num < 5000 && num >= 1000) { // adds ("MV\u0305") or (one or more of "M")
            if (num >= 4000) {
                romanNumeral += "MV\u0305";
                num -= 4000;
            } else {
                romanNumeral += "M";
                num -= 1000;
            }
        }

        while (num < 1000 && num >= 500) { // adds ("CM") or (one or more of "D")
            if (num >= 900) {
                romanNumeral += "CM";
                num -= 900;
            } else {
                romanNumeral += "D";
                num -= 500;
            }
        }

        while (num < 500 && num >= 100) { // adds ("CD") or (one or more of "C")
            if (num >= 400) {
                romanNumeral += "CD";
                num -= 400;
            } else {
                romanNumeral += "C";
                num -= 100;
            }
        }

        while (num < 100 && num >= 50) { // adds ("XC") or (one or more of "L")
            if (num >= 90) {
                romanNumeral += "XC";
                num -= 90;
            } else {
                romanNumeral += "L";
                num -= 50;
            }
        }

        while (num < 50 && num > 10) { // adds ("XL") or (one or more of "X")
            if (num >= 40) {
                romanNumeral += "XL";
                num -= 40;
            } else {
                romanNumeral += "X";
                num -= 10;
            }
        }

        switch (num) {
            case 1:
                romanNumeral += baseTenRomanNum[0]; break;
            case 2:
                romanNumeral += baseTenRomanNum[1]; break;
            case 3:
                romanNumeral += baseTenRomanNum[2]; break;
            case 4:
                romanNumeral += baseTenRomanNum[3]; break;
            case 5:
                romanNumeral += baseTenRomanNum[4]; break;
            case 6:
                romanNumeral += baseTenRomanNum[5]; break;
            case 7:
                romanNumeral += baseTenRomanNum[6]; break;
            case 8:
                romanNumeral += baseTenRomanNum[7]; break;
            case 9:
                romanNumeral += baseTenRomanNum[8]; break;
            case 10:
                romanNumeral += baseTenRomanNum[9]; break;
            default: romanNumeral += "";
        }
        return romanNumeral;
    }
}
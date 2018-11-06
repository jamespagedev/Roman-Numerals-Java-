/**
 * Created by Vako on 10/26/2016.
 */
public class RomanNumeralTestCases {
    private final String setStringColorReset = "\u001B[0m";
    private final String setStringColorGreenBold = "\u001B[1;32m";
    private final String setStringColorRedBold = "\u001B[1;31m";
    private int totalTestCases;
    private int testCasesPassed;
    private int testCasesFailed;
    private String testResult;
    private String passResult;
    private String failResultTemplate = this.setStringColorRedBold + "Fail" + "\n\tExpected output:\n";
    private String failResult;

    // *********************************************************************************************************

    RomanNumeralTestCases () {} // constructor

    // *********************************************************************************************************

    private void setTestResultTemplate (String testCaseName) {
        this.testResult = "Test Case - " + testCaseName + ": ";
    }

    // *********************************************************************************************************

    private void setTestCasePassResult (String testCaseName) {
        setTestResultTemplate(testCaseName);
        this.passResult = this.testResult + this.setStringColorGreenBold + "Pass" + this.setStringColorReset;
    }

    // *************************** setTestCaseFailResultTemplate method overloading ****************************
    private void setTestCaseFailResultTemplate (String testCaseName, String expectedOutput) {
        setTestResultTemplate(testCaseName);
        this.failResult = this.testResult + this.failResultTemplate + expectedOutput + this.setStringColorReset;
    }

    private void setTestCaseFailResultTemplate (String testCaseName, boolean expectedOutput) {
        setTestResultTemplate(testCaseName);
        this.failResult = this.testResult + this.failResultTemplate + expectedOutput + this.setStringColorReset;
    }
    private void setTestCaseFailResultTemplate (String testCaseName, int expectedOutput) {
        setTestResultTemplate(testCaseName);
        this.failResult = this.testResult + this.failResultTemplate + expectedOutput + this.setStringColorReset;
    }

    private void setTestCaseFailResultTemplate (String testCaseName, double expectedOutput) {
        setTestResultTemplate(testCaseName);
        this.failResult = this.testResult + this.failResultTemplate + expectedOutput + this.setStringColorReset;
    }

    // *************************************** ioTest method overloading ***************************************
    public String ioTest (String testCaseName, String input, String expectedOutput) {
        // passes
        if (input.equals(expectedOutput)) {
            this.testCasesPassed++;
            this.totalTestCases++;
            setTestCasePassResult(testCaseName);
            return this.passResult;
        }

        // fails
        this.testCasesFailed++;
        this.totalTestCases++;
        setTestCaseFailResultTemplate(testCaseName, expectedOutput);
        return this.failResult;
    }

    public String ioTest (String testCaseName, boolean input, boolean expectedOutput) {
        // passes
        if (input == expectedOutput) {
            this.testCasesPassed++;
            this.totalTestCases++;
            setTestCasePassResult(testCaseName);
            return this.passResult;
        }

        // fails
        this.testCasesFailed++;
        this.totalTestCases++;
        setTestCaseFailResultTemplate(testCaseName, expectedOutput);
        return this.failResult;
    }

    public String ioTest (String testCaseName, int input, int expectedOutput) {
        // passes
        if (input == expectedOutput) {
            this.testCasesPassed++;
            this.totalTestCases++;
            setTestCasePassResult(testCaseName);
            return this.passResult;
        }

        // fails
        this.testCasesFailed++;
        this.totalTestCases++;
        setTestCaseFailResultTemplate(testCaseName, expectedOutput);
        return this.failResult;
    }

    public String ioTest (String testCaseName, double input, double expectedOutput) {
        // passes
        if (input == expectedOutput) {
            this.testCasesPassed++;
            this.totalTestCases++;
            setTestCasePassResult(testCaseName);
            return this.passResult;
        }

        // fails
        this.testCasesFailed++;
        this.totalTestCases++;
        setTestCaseFailResultTemplate(testCaseName, expectedOutput);
        return this.failResult;
    }

    // *********************************************************************************************************
    public String displayTestResults () {
        return "Total Testcases Run " + this.totalTestCases + ":: " + this.testCasesPassed + this.setStringColorGreenBold + "Pass" + setStringColorReset + ": " + this.testCasesFailed + setStringColorRedBold + "Fall" + this.setStringColorReset;
    }

    // ************************************* Main code starts to run here **************************************

    public static void main(String[] args) {
        RomanNumeralTestCases tester = new RomanNumeralTestCases();

        // variables array index names and the array
        int testCaseName = 0;
        int testCaseInput = 1;
        int testCaseExpectedOutput = 2;
        String testSet[][] = {
                // [Testcase name, input, expected output]
                {"negativeOne", RomanNumeral.convertFromInteger(-1), "The number -1 cannot be converted into a roman numeral"},
                {"zero", RomanNumeral.convertFromInteger(0), "The number 0 cannot be converted into a roman numeral"},
                {"one", RomanNumeral.convertFromInteger(1), "I"},
                {"two", RomanNumeral.convertFromInteger(2), "II"},
                {"three", RomanNumeral.convertFromInteger(3), "III"},
                {"four", RomanNumeral.convertFromInteger(4), "IV"},
                {"five", RomanNumeral.convertFromInteger(5), "V"},
                {"six", RomanNumeral.convertFromInteger(6), "VI"},
                {"seven", RomanNumeral.convertFromInteger(7), "VII"},
                {"eight", RomanNumeral.convertFromInteger(8), "VIII"},
                {"nine", RomanNumeral.convertFromInteger(9), "IX"},
                {"ten", RomanNumeral.convertFromInteger(10), "X"},
                {"eleven", RomanNumeral.convertFromInteger(11), "XI"},
                {"nineteen", RomanNumeral.convertFromInteger(19), "XIX"},
                {"twenty", RomanNumeral.convertFromInteger(20), "XX"},
                {"twentyOne", RomanNumeral.convertFromInteger(21), "XXI"},
                {"twentyNine", RomanNumeral.convertFromInteger(29), "XXIX"},
                {"thirty", RomanNumeral.convertFromInteger(30), "XXX"},
                {"thirtyOne", RomanNumeral.convertFromInteger(31), "XXXI"},
                {"thirtyNine", RomanNumeral.convertFromInteger(39), "XXXIX"},
                {"forty", RomanNumeral.convertFromInteger(40), "XL"},
                {"fortyOne", RomanNumeral.convertFromInteger(41), "XLI"},
                {"fortyNine", RomanNumeral.convertFromInteger(49), "XLIX"},
                {"fifty", RomanNumeral.convertFromInteger(50), "L"},
                {"fiftyOne", RomanNumeral.convertFromInteger(51), "LI"},
                {"fiftyNine", RomanNumeral.convertFromInteger(59), "LIX"},
                {"sixty", RomanNumeral.convertFromInteger(60), "LX"},
                {"sixtyOne", RomanNumeral.convertFromInteger(61), "LXI"},
                {"eightyNine", RomanNumeral.convertFromInteger(89), "LXXXIX"},
                {"ninety", RomanNumeral.convertFromInteger(90), "XC"},
                {"ninetyOne", RomanNumeral.convertFromInteger(91), "XCI"},
                {"ninetyNine", RomanNumeral.convertFromInteger(99), "XCIX"},
                {"oneHundred", RomanNumeral.convertFromInteger(100), "C"},
                {"oneHundredOne", RomanNumeral.convertFromInteger(101), "CI"},
                {"oneHundredFortyNine", RomanNumeral.convertFromInteger(149), "CXLIX"},
                {"oneHundredFifty", RomanNumeral.convertFromInteger(150), "CL"},
                {"oneHundredFiftyOne", RomanNumeral.convertFromInteger(151), "CLI"},
                {"oneHundredEightyNine", RomanNumeral.convertFromInteger(189), "CLXXXIX"},
                {"oneHundredNinety", RomanNumeral.convertFromInteger(190), "CXC"},
                {"oneHundredNinetyOne", RomanNumeral.convertFromInteger(191), "CXCI"},
                {"threeHundred", RomanNumeral.convertFromInteger(300), "CCC"},
                {"threeHundredNinety", RomanNumeral.convertFromInteger(390), "CCCXC"},
                {"threeHundredNinetyOne", RomanNumeral.convertFromInteger(391), "CCCXCI"},
                {"threeHundredNinetyNine", RomanNumeral.convertFromInteger(399), "CCCXCIX"},
                {"fourHundred", RomanNumeral.convertFromInteger(400), "CD"},
                {"fourHundredOne", RomanNumeral.convertFromInteger(401), "CDI"},
                {"fourHundredFortyNine", RomanNumeral.convertFromInteger(449), "CDXLIX"},
                {"fourHundredFifty", RomanNumeral.convertFromInteger(450), "CDL"},
                {"fourHundredFiftyOne", RomanNumeral.convertFromInteger(451), "CDLI"},
                {"fourHundredNinetyNine", RomanNumeral.convertFromInteger(499), "CDXCIX"},
                {"fiveHundred", RomanNumeral.convertFromInteger(500), "D"},
                {"fiveHundredOne", RomanNumeral.convertFromInteger(501), "DI"},
                {"sevenHundredFortyNine", RomanNumeral.convertFromInteger(749), "DCCXLIX"},
                {"sevenHundredFifty", RomanNumeral.convertFromInteger(750), "DCCL"},
                {"sevenHundredFiftyOne", RomanNumeral.convertFromInteger(751), "DCCLI"},
                {"eightHundredNinetyNine", RomanNumeral.convertFromInteger(899), "DCCCXCIX"},
                {"nineHundred", RomanNumeral.convertFromInteger(900), "CM"},
                {"nineHundredOne", RomanNumeral.convertFromInteger(901), "CMI"},
                {"nineHundredNinetyNine", RomanNumeral.convertFromInteger(999), "CMXCIX"},
                {"oneThousand", RomanNumeral.convertFromInteger(1000), "M"},
                {"oneThousandOne", RomanNumeral.convertFromInteger(1001), "MI"},
                {"twoThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(2999), "MMCMXCIX"},
                {"threeThousand", RomanNumeral.convertFromInteger(3000), "MMM"},
                {"threeThousandOne", RomanNumeral.convertFromInteger(3001), "MMMI"},
                {"threeThousandNinetyNine", RomanNumeral.convertFromInteger(3099), "MMMXCIX"},
                {"fourThousand", RomanNumeral.convertFromInteger(4000), "MV\u0305"},
                {"fourThousandOne", RomanNumeral.convertFromInteger(4001), "MV\u0305I"},
                {"fourThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(4999), "MV\u0305CMXCIX"},
                {"fiveThousand", RomanNumeral.convertFromInteger(5000), "V\u0305"},
                {"fiveThousandOne", RomanNumeral.convertFromInteger(5001), "V\u0305I"},
                {"sevenThousandFourHundredNinetyNine", RomanNumeral.convertFromInteger(7499), "V\u0305MMCDXCIX"},
                {"sevenThousandFiveHundred", RomanNumeral.convertFromInteger(7500), "V\u0305MMD"},
                {"sevenThousandFiveHundredOne", RomanNumeral.convertFromInteger(7501), "V\u0305MMDI"},
                {"eightThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(8999), "V\u0305MMMCMXCIX"},
                {"nineThousand", RomanNumeral.convertFromInteger(9000), "MX\u0305"},
                {"nineThousandOne", RomanNumeral.convertFromInteger(9001), "MX\u0305I"},
                {"nineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(9999), "MX\u0305CMXCIX"},
                {"tenThousand", RomanNumeral.convertFromInteger(10000), "X\u0305"},
                {"tenThousandOne", RomanNumeral.convertFromInteger(10001), "X\u0305I"},
                {"twentyFourThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(24999), "X\u0305X\u0305MV\u0305CMXCIX"},
                {"twentyFiveThousand", RomanNumeral.convertFromInteger(25000), "X\u0305X\u0305V\u0305"},
                {"twentyFiveThousandOne", RomanNumeral.convertFromInteger(25001), "X\u0305X\u0305V\u0305I"},
                {"fortyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(49999), "X\u0305L\u0305MX\u0305CMXCIX"},
                {"fiftyThousand", RomanNumeral.convertFromInteger(50000), "L\u0305"},
                {"fiftyThousandOne", RomanNumeral.convertFromInteger(50001), "L\u0305I"},
                {"seventyFourThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(74999), "L\u0305X\u0305X\u0305MV\u0305CMXCIX"},
                {"seventyFiveThousand", RomanNumeral.convertFromInteger(75000), "L\u0305X\u0305X\u0305V\u0305"},
                {"seventyFiveThousandOne", RomanNumeral.convertFromInteger(75001), "L\u0305X\u0305X\u0305V\u0305I"},
                {"eightyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(89999), "L\u0305X\u0305X\u0305X\u0305MX\u0305CMXCIX"},
                {"ninetyThousand", RomanNumeral.convertFromInteger(90000), "X\u0305C\u0305"},
                {"ninetyThousandOne", RomanNumeral.convertFromInteger(90001), "X\u0305C\u0305I"},
                {"ninetyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(99999), "X\u0305C\u0305MX\u0305CMXCIX"},
                {"oneHundredThousand", RomanNumeral.convertFromInteger(100000), "C\u0305"},
                {"oneHundredThousandOne", RomanNumeral.convertFromInteger(100001), "C\u0305I"},
                {"twoHundredFortyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(249999), "C\u0305C\u0305X\u0305L\u0305MX\u0305CMXCIX"},
                {"twoHundredFiftyThousand", RomanNumeral.convertFromInteger(250000), "C\u0305C\u0305L\u0305"},
                {"twoHundredFiftyThousandOne", RomanNumeral.convertFromInteger(250001), "C\u0305C\u0305L\u0305I"},
                {"fourHundredNinetyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(499999), "C\u0305D\u0305X\u0305C\u0305MX\u0305CMXCIX"},
                {"fiveHundredThousand", RomanNumeral.convertFromInteger(500000), "D\u0305"},
                {"fiveHundredThousandOne", RomanNumeral.convertFromInteger(500001), "D\u0305I"},
                {"sevenHundredFortyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(749999), "D\u0305C\u0305C\u0305X\u0305L\u0305MX\u0305CMXCIX"},
                {"sevenHundredFiftyThousand", RomanNumeral.convertFromInteger(750000), "D\u0305C\u0305C\u0305L\u0305"},
                {"sevenHundredFiftyThousandOne", RomanNumeral.convertFromInteger(750001), "D\u0305C\u0305C\u0305L\u0305I"},
                {"eightHundredNinetyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(899999), "D\u0305C\u0305C\u0305C\u0305X\u0305C\u0305MX\u0305CMXCIX"},
                {"nineHundredThousand", RomanNumeral.convertFromInteger(900000), "C\u0305M\u0305"},
                {"nineHundredThousandOne", RomanNumeral.convertFromInteger(900001), "C\u0305M\u0305I"},
                {"nineHundredNinetyNineThousandNineHundredNinetyNine", RomanNumeral.convertFromInteger(999999), "C\u0305M\u0305X\u0305C\u0305MX\u0305CMXCIX"},
                {"oneMillion", RomanNumeral.convertFromInteger(1000000), "M\u0305"},
                {"oneMillionOne", RomanNumeral.convertFromInteger(1000001), "M\u0305I"},
                {"oneMillionEleven", RomanNumeral.convertFromInteger(1000011), "M\u0305XI"},
                {"oneMillionOneHundredEleven", RomanNumeral.convertFromInteger(1000111), "M\u0305CXI"},
                {"oneMillionOneThousandOneHundredEleven", RomanNumeral.convertFromInteger(1001111), "M\u0305MCXI"},
                {"oneMillionElevenThousandOneHundredEleven", RomanNumeral.convertFromInteger(1011111), "M\u0305X\u0305MCXI"},
                {"oneMillionOneHundredElevenThousandOneHundredEleven", RomanNumeral.convertFromInteger(1111111), "M\u0305C\u0305X\u0305MCXI"}
        };

        for (String testCase[]: testSet) {
            System.out.println(tester.ioTest(testCase[testCaseName], testCase[testCaseInput], testCase[testCaseExpectedOutput]));
        }
        System.out.println();

        System.out.println(tester.displayTestResults());
    }
}
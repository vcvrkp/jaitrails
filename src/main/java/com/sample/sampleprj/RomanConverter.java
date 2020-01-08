package com.sample.sampleprj;

public class RomanConverter {

    public int convert(String string) throws Exception {
        int number = 0;
        if (string != null) {
            char[] digits = string.toCharArray();
            if (digits.length == 1) {
                return getNumber(digits[0]);
            }
        }
        return number;
    }

    public int getNumber(char c) throws Exception {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        throw new Exception("Invalid Number Symbol passed");
    }
}

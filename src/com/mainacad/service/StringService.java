package com.mainacad.service;

import static java.lang.Integer.max;

public class StringService {
    public static String getStringMultiplication(int multiplierOne, int multiplierTwo) {
        if (multiplierOne < multiplierTwo) {
            int substTemp = multiplierTwo;
            multiplierTwo = multiplierOne;
            multiplierOne = substTemp;
        }

        StringBuilder result = new StringBuilder();
        int multiplicationResult = multiplierOne*multiplierTwo;
        String multiplicationResultString = Integer.toString(multiplicationResult);
        String multiplierStringOne = Integer.toString(multiplierOne);
        String multiplierStringTwo = Integer.toString(multiplierTwo);
        char[] multiplierStringTwoSymbols = multiplierStringTwo.toCharArray();
        int multiplicationResultStringLength = multiplicationResultString.length();

        result.append("\n");
        result.append(getStringWithFrontSpaces(multiplierStringOne, multiplicationResultStringLength));
        result.append("\n");
        result.append(getStringWithFrontSpaces(multiplierStringTwo, multiplicationResultStringLength));
        result.append("\n");
        result.append(getStringWithFrontSpaces(getUnderscoreString(multiplierStringOne.length()), multiplicationResultStringLength));
        result.append("\n");
        for (int i = 1; i<=multiplierStringTwo.length(); i++){
            int nextSymbol = Character.digit(multiplierStringTwoSymbols[(multiplierStringTwoSymbols.length) - i], 10);
            int multiplicationResultStage = multiplierOne*nextSymbol;
            String appendedString = Integer.toString(multiplicationResultStage);
            appendedString = getStringWithFrontSpaces(appendedString, multiplicationResultStringLength - i+1);
            result.append(appendedString);
            result.append("\n");
        }
        result.append(getUnderscoreString(multiplicationResultStringLength));
        result.append("\n");
        result.append(multiplicationResultString);
        return result.toString();
    }

    public static String getStringWithFrontSpaces(String string, int totalStringSize) {
        int numberFrontSpaces = totalStringSize - string.length();
        String insertStringWithSpaces = new String(new char[numberFrontSpaces]).replace('\0', ' ');
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.insert(0, insertStringWithSpaces).toString();
    }

    public static String getUnderscoreString(int size) {
        return new String(new char[size]).replace('\0', '_');
    }


}

package com.mainacad.service;

import static java.lang.Integer.max;

import org.apache.commons.lang3.StringUtils;

public class StringService {
    public static String getStringMultiplication(int multiplierOne, int multiplierTwo) {
        if (multiplierOne < multiplierTwo) {
            int substTemp = multiplierTwo;
            multiplierTwo = multiplierOne;
            multiplierOne = substTemp;
        }

        StringBuilder result = new StringBuilder();
        int multiplicationResult = multiplierOne * multiplierTwo;
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
        for (int i = 1; i <= multiplierStringTwo.length(); i++) {
            int nextSymbol = Character.digit(multiplierStringTwoSymbols[(multiplierStringTwoSymbols.length) - i], 10);
            int multiplicationResultStage = multiplierOne * nextSymbol;
            String appendedString = Integer.toString(multiplicationResultStage);
            appendedString = getStringWithFrontSpaces(appendedString, multiplicationResultStringLength - i + 1);
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

    public static String reverseOnlyLetters(String string) {
        char[] symbols = string.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder part = new StringBuilder();
        StringBuilder partFull = new StringBuilder();

        int endStringMarker = 0;
        for (Character symbol : symbols) {
            endStringMarker++;
            partFull.append(symbol);
            if (Character.isLetter(symbol)) {
                part.append(symbol);
            }
            if ((symbol == ' ') || (symbols.length == endStringMarker)) {
                String reversePart = StringUtils.reverse(part.toString());
                char[] reversePartSymbols = reversePart.toCharArray();
                char[] partFullSymbols = partFull.toString().toCharArray();
                int k = 0;
                for (Character s : partFullSymbols) {
                    if (Character.isLetter(s)) {
                        result.append(reversePartSymbols[k]);
                        k++;
                    } else result.append(s);
                }
                part.setLength(0);
                partFull.setLength(0);
                continue;
            }
        }
        return result.toString();
    }

    public static int getMaxAnagrammaMultiplication(int startNumber, int endNumber) {
        int max = 0;
        int multiplierOne = startNumber;
        int multiplierTwo = startNumber;
        String stringCheck;

        for (int i = 0; i <= (endNumber - startNumber + 1); i++)
            for (int j = 0; j <= (endNumber - startNumber + 1); j++) {
                int multiplication = (multiplierOne + i) * (multiplierTwo + j);
                stringCheck = Integer.toString(multiplication);
                if (stringCheck.equals(StringUtils.reverse(stringCheck)) && (multiplication > max)) {
                    max = multiplication;
                }
            }
        return max;
    }
}

package com.mainacad;

import com.mainacad.service.StringService;

import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        // test string multiplication
        int intOne = 11111;
        int intTwo = 999;
        LOGGER.info(String.format("Test result: for %d * %d = %d", intOne, intTwo, intOne * intTwo));
        LOGGER.info(StringService.getStringMultiplication(intOne, intTwo));

        // test revers for letters
        String str = "ab1c d2 fg4 5 89 90jk6";
        String strReverse = StringService.reverseOnlyLetters(str);
        LOGGER.info(String.format("Test reverse: for \"%s\" = \"%s\"", str, strReverse));

        // test anagramma
        int startNumber = 1000;
        int endNumber = 9999;
        int maxAnagramma = StringService.getMaxAnagrammaMultiplication(startNumber, endNumber);
        LOGGER.info(String.format("Test max anagramma in [%d, %d] = %d", startNumber, endNumber, maxAnagramma));

    }
}

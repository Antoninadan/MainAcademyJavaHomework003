package com.mainacad;

import com.mainacad.service.StringService;

import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        int intOne = 11111;
        int intTwo = 989;
        LOGGER.info(String.format("Test result: for %d * %d = %d", intOne, intTwo, intOne * intTwo));
        LOGGER.info(StringService.getStringMultiplication(intOne, intTwo));

    }
}

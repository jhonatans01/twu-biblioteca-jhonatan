package com.twu.biblioteca.util;

import java.util.Scanner;

public class InputOutputUtil {

    public static String getInvalidOptionErrorMessage() {
        return "Please select a valid option!";
    }

    public static Integer readOption() {
        Scanner reader = new Scanner(System.in);
        String option = reader.nextLine();
        int intOption;
        try {
            intOption = Integer.parseInt(option);
        } catch (NumberFormatException numberException) {
            System.out.println(getInvalidOptionErrorMessage());
            return null;
        }
        return intOption;
    }

}

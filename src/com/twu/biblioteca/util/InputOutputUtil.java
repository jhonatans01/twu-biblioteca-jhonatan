package com.twu.biblioteca.util;

import java.util.Scanner;

public class InputOutputUtil {

    private static Scanner reader = new Scanner(System.in);

    public static String getInvalidOptionErrorMessage() {
        return "Please select a valid option!";
    }

    public static Integer readOption() {
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

    public static String readString() {
        return reader.nextLine();
    }

}

package com.company.main;

import java.util.InputMismatchException;

public class PhoneNumber {

    final static int ACCEPTABLE_NUMBER_LENGTH = 18; // Граница числа Long

    public static void main(String[] args) {
        runTestCases();
    }

    /**
     * Конвертация из буквенного номера телефона в числовой.
     * @param phoneNumber Номер телефона в буквенном или обычном представлении.
     * @return Возвращает номер телефона в обычном представлении - числовом.
     * Возвращает -1 если длина переданного номера больше допустимого
     */
    public static Long parsePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new InputMismatchException("Invalid input. Your input is empty.");
        }
        final int size = phoneNumber.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            switch (phoneNumber.charAt(i)) {
                case '1': result.append('1'); break;
                case '0': result.append('0'); break;
                case 'A': case 'B': case 'C': case '2': result.append('2'); break;
                case 'D': case 'E': case 'F': case '3': result.append('3'); break;
                case 'G': case 'H': case 'I': case '4': result.append('4'); break;
                case 'J': case 'K': case 'L': case '5': result.append('5'); break;
                case 'M': case 'N': case 'O': case '6': result.append('6'); break;
                case 'P': case 'Q': case 'R': case 'S': case '7': result.append('7'); break;
                case 'T': case 'U': case 'V': case '8': result.append('8'); break;
                case 'W': case 'X': case 'Y': case 'Z': case '9': result.append('9'); break;
                case '-': case ' ': case '+': break;
                default: {
                    throw new NumberFormatException("Invalid symbol was found -> '" + phoneNumber.charAt(i) + "'");
                }
            }
        }
        if (result.length() > ACCEPTABLE_NUMBER_LENGTH) {
            return -1L;
        } else {
            return Long.parseLong(result.toString());
        }
    }

    /**
     * Unit tests for @parsePhoneNumber function
     */
    private static void runTestCases() {
        // Test 1
        if (parsePhoneNumber("CALL-ME") == 2255_63L) {
            System.out.println("test1 -> \"CALL-ME\" ✅");
        } else {
            System.out.println("test1 -> parsePhoneNumber(\"CALL-ME\") ❌");
        }
        // Test 2
        if (parsePhoneNumber("CALL-1-ME") == 2255_1_63L) {
            System.out.println("test2 -> \"CALL-1-ME\" ✅");
        } else {
            System.out.println("test2 -> parsePhoneNumber(\"CALL-1-ME\") ❌");
        }
        // Test 3
        if (parsePhoneNumber("7-926-FLOWERS") == 7_926_3569377L) {
            System.out.println("test3 -> \"7-926-FLOWERS\" ✅");
        } else {
            System.out.println("test3 -> parsePhoneNumber(\"+7-926-FLOWERS\") ❌");
        }
        // Test 4
        try {
            parsePhoneNumber("");
            System.out.println("test4 -> parsePhoneNumber(\"\") ❌");
        } catch (InputMismatchException e) {
            System.out.println("test4 -> \"\" ✅");
        }
        // Test 5
        try {
            parsePhoneNumber(null);
            System.out.println("test5 -> parsePhoneNumber(null) ❌");
        } catch (InputMismatchException e) {
            System.out.println("test5 -> null ✅");
        }
        // Test 6
        try {
            parsePhoneNumber("123123-ADSDASD-+-?.?.");
            System.out.println("test6 -> parsePhoneNumber(\"123123-ADSDASD-+-?.?.\") ❌");
        } catch (NumberFormatException e) {
            System.out.println("test6 -> \"123123-ADSDASD-+-?.?.\" ✅");
        }
        // Test 7
        if (parsePhoneNumber("1") == 1L) {
            System.out.println("test7 -> \"1\" ✅");
        } else {
            System.out.println("test7 -> parsePhoneNumber(\"1\") ❌");
        }
        // Test 8
        if (parsePhoneNumber("-1") == 1L) {
            System.out.println("test8 -> \"-1\" ✅");
        } else {
            System.out.println("test8 -> parsePhoneNumber(\"-1\") ❌");
        }
        // Test 9
        if (parsePhoneNumber("-10") == 10L) {
            System.out.println("test9 -> \"-10\" ✅");
        } else {
            System.out.println("test9 -> parsePhoneNumber(\"-10\") ❌");
        }
        // Test 10
        if (parsePhoneNumber("-1-0-1") == 101L) {
            System.out.println("test10 -> \"-1-0-1\" ✅");
        } else {
            System.out.println("test10 -> parsePhoneNumber(\"-1-0-1\") ❌");
        }
        // Test 11
        if (parsePhoneNumber("999-999-999-999-999-999-9") == -1L) {
            System.out.println("test11 -> \"999-999-999-999-999-999-9\" ✅");
        } else {
            System.out.println("test11 -> parsePhoneNumber(\"999-999-999-999-999-999-9\") ❌");
        }
        // Test 12
        if (parsePhoneNumber("999-999-999-999-999-999") == 999_999_999_999_999_999L) {
            System.out.println("test12 -> \"999-999-999-999-999-999\" ✅");
        } else {
            System.out.println("test12 -> parsePhoneNumber(\"999-999-999-999-999-999\") ❌");
        }
    }
}
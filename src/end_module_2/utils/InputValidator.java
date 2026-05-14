package end_module_2.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String getValidRegex(String message, String regex, String error) {
        while (true) {
            String input = getString(message);
            if (input.matches(regex)) return input;
            System.out.println(error);
        }
    }

    public static LocalDate getLocalDate(String message) {
        while (true) {
            String input = getString(message + " (dd/MM/yyyy): ");
            try {
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không đúng (dd/MM/yyyy)!");
            }
        }
    }

    public static double getDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(getString(message));
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập số thực không hợp lệ!");
            }
        }
    }

    public static int getInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(getString(message));
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Nhập số nguyên không hợp lệ!");
            }
        }
    }
}
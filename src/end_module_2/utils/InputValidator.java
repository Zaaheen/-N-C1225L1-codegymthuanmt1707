//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner;
    private static final DateTimeFormatter DATE_FORMATTER;

    public static String getString(String var0) {
        System.out.print(var0);
        return scanner.nextLine();
    }

    public static String getValidRegex(String var0, String var1, String var2) {
        while(true) {
            String var3 = getString(var0);
            if (var3.matches(var1)) {
                return var3;
            }

            System.out.println(var2);
        }
    }

    public static LocalDate getLocalDate(String var0) {
        while(true) {
            String var1 = getString(var0 + " (dd/MM/yyyy): ");

            try {
                return LocalDate.parse(var1, DATE_FORMATTER);
            } catch (DateTimeParseException var3) {
                System.out.println("Lỗi: Định dạng ngày không đúng (dd/MM/yyyy)!");
            }
        }
    }

    public static double getDouble(String var0) {
        while(true) {
            try {
                return Double.parseDouble(getString(var0));
            } catch (NumberFormatException var2) {
                System.out.println("Lỗi: Nhập số thực không hợp lệ!");
            }
        }
    }

    public static int getInt(String var0) {
        while(true) {
            try {
                return Integer.parseInt(getString(var0));
            } catch (NumberFormatException var2) {
                System.out.println("Lỗi: Nhập số nguyên không hợp lệ!");
            }
        }
    }

    static {
        scanner = new Scanner(System.in);
        DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}

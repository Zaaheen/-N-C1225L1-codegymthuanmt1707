package ss1_introduction_to_java;

import java.util.Scanner;

public class ung_dung_doc_so_thanh_chu {

    private static final String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số (từ 0-9999): ");
        int num = scanner.nextInt();

        if (num < 0 || num > 9999 ){
            System.out.println("Nằm ngoài phạm vi.");
        } else if (num < 10) {
            System.out.println(readSingleDigit(num));
        } else if (num < 100) {
            System.out.println(readTwoDigits(num));
        } else if (num < 1000){
            System.out.println(readThreeDigits(num));
        } else {
            System.out.println(readFourDigits(num));
        }
    }

    private static String readSingleDigit(int n) {
        return units[n];
    }

    private static String readTwoDigits(int n) {
        if (n < 10) return readSingleDigit(n);
        if (n < 20) return teens[n - 10];

        int tenDigit = n / 10;
        int unitDigit = n % 10;

        if (unitDigit == 0) {
            return tens[tenDigit];
        } else {
            // Lồng hàm readSingleDigit vào đây
            return tens[tenDigit] + " " + readSingleDigit(unitDigit);
        }
    }

    private static String readThreeDigits(int n){
        int hundredDigit = n / 100;
        int remaining = n % 100;

        String result = units[hundredDigit] + " hundred";
        if (remaining > 0){
            result += " and " + readTwoDigits(remaining);
        }
        return result;
    }

    private static String readFourDigits(int n){
        int thousandDigit = n / 1000;
        int remaining = n % 1000;

        String result = units[thousandDigit] + " thousand";
        if (remaining >= 100){
            result += " " + readThreeDigits(remaining);
        } else {
            result += " and " + readTwoDigits(remaining);
        }
        return result;
    }
}

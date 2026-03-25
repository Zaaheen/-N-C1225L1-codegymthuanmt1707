package ss3_method;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.println("Enter a character to count: ");
        char searchChar = scanner.nextLine().charAt(0);

        int count = countChar(inputString, searchChar);
        System.out.println("The character '" + searchChar + "' appears " + count + " times in the string.");
    }
    public static int countChar(String str, char c){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}

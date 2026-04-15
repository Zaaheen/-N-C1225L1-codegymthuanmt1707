package ss11_DSA_stack_and_queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_Stack {
    
    public static void main(String[] args) {
        int[] array = inputArray();
        String string = inputString();

        System.out.println("Mảng ban đầu: " + Arrays.toString(array));
        System.out.println("Chuỗi ban đầu: " + string);

        reverseNumber(array);
        string = reverseString(string);

        System.out.println("Mảng sau khi đảo ngược: " + Arrays.toString(array));
        System.out.println("Chuỗi sau khi đảo ngược: " + string);
    }

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        return array;
    }
    public static String inputString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        return scanner.nextLine();
    }

    public static void reverseNumber(int[] array){
        Stack<Integer> stack = new Stack<>();

        for (int value : array){
            stack.push(value);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
    public static String reverseString(String input){
        Stack<String> wStack = new Stack<>();
        String[] words = input.split("\\s+");

        for (String mWord : words){
            wStack.push(mWord);
        }
        StringBuilder out = new StringBuilder();
        while (!wStack.isEmpty()){
            String mWord = wStack.pop();
            out.append(mWord);
            if (!wStack.isEmpty()){
                out.append(" ");
            }
        }
        return out.toString();
    }
}

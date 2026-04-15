package ss11_DSA_stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Nhập: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập cơ sô muốn chuyển: ");
        int base = Integer.parseInt(scanner.nextLine());
        convert(n, base, stack);
        String result = display(stack);
        System.out.println("Kết quả: " + result);
    }

    public static void convert(int n, int base, Stack<Integer> stack) {
        while (n > 0){
            int remainder = n % base;
            stack.push(remainder);
            n = n / base;
        }
    }
    public static String display(Stack<Integer> stack){
        if (stack.isEmpty()) return "0";
        StringBuilder out = new StringBuilder();
        String digits = "0123456789ABCDEF";

        while (!stack.isEmpty()){
            int value = stack.pop();
            out.append(digits.charAt(value));
        }
        return out.toString();
    }

}

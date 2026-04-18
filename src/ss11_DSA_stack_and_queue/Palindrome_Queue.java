package ss11_DSA_stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.println("Nhập vào chuỗi: ");
        String input = scanner.nextLine().toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);
            queue.add(c);
        }
        boolean isPalindrome = isPalindrome(stack, queue);
        if (isPalindrome) {
            System.out.println("Chuỗi '" + input + "' là chuỗi Palindrome");
        } else {
            System.out.println("Chuỗi '" + input + "' không là chuỗi Palindrome");
        }
    }

    public static boolean isPalindrome(Stack<Character> stack, Queue<Character> queue) {
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}

package ss11_DSA_stack_and_queue;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCountMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String input = scanner.nextLine();
        Map<String, Integer> treeMap = new TreeMap<>();
        String[] words = input.toLowerCase().split("\\s+");
        for (String word: words){
            if (treeMap.containsKey(word)){
                int count = treeMap.get(word);
                treeMap.put(word, count + 1);
            } else {
                treeMap.put(word, 1);
            }
        }
        System.out.println("Kết quả đếm từ: ");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

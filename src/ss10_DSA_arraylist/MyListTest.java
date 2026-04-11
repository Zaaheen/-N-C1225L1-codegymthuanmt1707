package ss10_DSA_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        System.out.println("--- KIỂM TRA ADD & SIZE ---");
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");
        list.add("C++");
        System.out.println("Kích thước sau khi add 4 phần tử: " + list.size());

        System.out.println("\n--- KIỂM TRA ADD(INDEX, ELEMENT) ---");
        list.add(2, "PHP");
        System.out.println("Phần tử tại vị trí 2: " + list.get(2));
        System.out.println("Danh sách hiện tại: ");
        printList(list);

        System.out.println("\n--- KIỂM TRA CONTAINS & INDEXOF ---");
        System.out.println("Có chứa 'Java' không? " + list.contains("Java"));
        System.out.println("Vị trí của 'Python': " + list.indexOf("Python"));

        System.out.println("\n--- KIỂM TRA CLONE ---");
        MyList<String> cloneList = list.clone();
        System.out.println("Kích thước bản sao: " + cloneList.size());
        System.out.println("Bản sao có 'PHP' không? " + cloneList.contains("PHP"));

        System.out.println("\n--- KIỂM TRA REMOVE ---");
        String removedElement = list.remove(1);
        System.out.println("Đã xóa: " + removedElement);
        System.out.println("Kích thước sau khi xóa: " + list.size());
        printList(list);

        System.out.println("\n--- KIỂM TRA ENSURECAPACITY ---");
        for (int i = 0; i < 10; i++) {
            list.add("Item " + i);
        }
        System.out.println("Kích thước sau khi add thêm 10 phần tử: " + list.size());

        System.out.println("\n--- KIỂM TRA CLEAR ---");
        list.clear();
        System.out.println("Kích thước sau khi clear: " + list.size());
    }


    public static void printList(MyList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " | ");
        }
        System.out.println();
    }
}
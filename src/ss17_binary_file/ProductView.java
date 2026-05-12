package ss17_binary_file;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static ProductRepository productRepository = new ProductRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Product> products = productRepository.findAll();
                    displayProducts(products);
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 4.");
            }
        }
    }

    private static void findProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();
        List<Product> searchResults = productRepository.findByName(searchName);
        if (!searchResults.isEmpty()) {
            System.out.println("\n✅ Kết quả tìm kiếm cho: '" + searchName + "'");
            displayProducts(searchResults);
        } else {
            System.out.println("❌ Không tìm thấy sản phẩm nào chứa tên: " + searchName);
        }
    }

    private static void addProduct() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập hãng sản phẩm: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();
        productRepository.add(new Product(id, name, price, manufacturer, description));
        System.out.println("Thêm thành công");
    }

    private static void displayProducts(List<Product> products) {
        if (products == null || products.isEmpty()){
            System.out.println("❌ Không tồn tại dữ liệu sản phẩm.");
            return;
        }
        String line = "+------+---------------------------+--------------+--------------+-----------------+";

        System.out.println(line);
        System.out.printf("| %-4s | %-25s | %-12s | %-12s | %-15s |\n",
                "ID", "Tên", "Giá", "Hãng", "Mô tả");
        System.out.println(line);

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println(line);
    }
}

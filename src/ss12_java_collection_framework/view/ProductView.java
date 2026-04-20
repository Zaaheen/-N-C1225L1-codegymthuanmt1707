package ss12_java_collection_framework.view;

import ss12_java_collection_framework.controller.ProductController;
import ss12_java_collection_framework.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static ProductController productController = new ProductController();
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm theo giá giảm dần");
            System.out.println("7. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("8. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Product> products = productController.getAll();
                    displayProduct(products);
                    break;
                case 2:
                    System.out.print("Nhập id sản phẩm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    productController.add(new Product(id, name, price));
                    System.out.println("Thêm thành công");
                    break;
                case 3:
                    System.out.print("Nhập id sản phẩm cần xoá: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    productController.delete(delId);
                    System.out.println("Xoá sản phẩm thành công");
                    break;
                case 4:
                    System.out.print("Nhập id sản phẩm cần cập nhật: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Product existingProduct = productController.getById(updateId);
                    if (existingProduct == null){
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println("Id hiện tại: " + existingProduct);
                        System.out.println("Nhập tên sản phẩm mới: ");
                        String updateName = scanner.nextLine();
                        System.out.println("Nhập giá mới: ");
                        double updatePrice = Double.parseDouble(scanner.nextLine());
                        productController.update(updateId, new Product(updateId, updateName, updatePrice));
                        System.out.println("Cập nhật thành công");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm cần tìm cần tìm: ");
                    String findName = scanner.nextLine();
                    List<Product> result = productController.getByName(findName);
                    displayProduct(result);
                    break;
                case 6:
                    productController.sortByPrice(false);
                    System.out.println("Sắp xếp giamr dần thành công");
                    displayProduct(productController.getAll());
                    break;
                case 7:
                    productController.sortByPrice(true);
                    System.out.println("Sắp xếp tăng dần thành công");
                    displayProduct(productController.getAll());
                    break;
                case 8:
                    return;
            }
        }
    }

    public static void displayProduct(List<Product> products) {
        if (products.isEmpty()){
            System.out.println("Không tồn tại");
            return;
        }
        System.out.println("+----+----------------------+------------+");
        System.out.printf("| %-2s | %-20s | %-10s |\n",
                "ID", "Tên sản phẩm", "Giá");
        System.out.println("+----+----------------------+------------+");
        for (Product product : products){
            System.out.println(product);
        }
        System.out.println("+----+----------------------+------------+");
    }
}

package HumanResources;

import HumanResources.utils.InputValidator;
import HumanResources.view.DepartmentView;
import HumanResources.view.EmployeeView;
import HumanResources.view.ProjectView;


public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÂN SỰ CODEGYM ---");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý phòng ban");
            System.out.println("3. Quản lý dự án");
            System.out.println("4. Thoát");

            int choice = InputValidator.getInt("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    EmployeeView.mainMenu();
                    break;
                case 2:
                    DepartmentView.mainMenu();
                    break;
                case 3:
                    ProjectView.mainMenu();
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ, vui lòng chọn từ 1 đến 4.");
            }
        }
    }
}
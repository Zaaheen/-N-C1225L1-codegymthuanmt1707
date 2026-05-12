package HumanResources.view;

import HumanResources.controller.DepartmentController;
import HumanResources.controller.EmployeeController;
import HumanResources.entity.Department;
import HumanResources.entity.Employee;
import HumanResources.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

import static HumanResources.view.EmployeeView.displayEmployees;

public class DepartmentView {
    private static DepartmentController departmentController = new DepartmentController();
    private static EmployeeController employeeController = new EmployeeController();
    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHÒNG BAN ---");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Danh sách nhân viên của phòng ban");
            System.out.println("3. Thêm phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Chỉnh sửa thông tin phòng ban");
            System.out.println("6. Quay lại");

            int choice = InputValidator.getInt("Chọn chức năng: ");
            switch (choice) {
                case 1:
                    List<Department> departments = departmentController.getAll();
                    displayDepartment(departments);
                    break;
                case 2:
                    displayEmployeesByDepartment();
                    break;
                case 3:
                    addDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    updateDepartment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void displayEmployeesByDepartment() {
        int deptId = InputValidator.getInt("Nhập ID của phòng ban: ");
        Department dept = departmentController.findById(deptId);

        if (dept == null) {
            System.out.println("❌ Phòng ban không tồn tại!");
            return;
        }

        List<Employee> employees = employeeController.getEmployeesByDepartment(deptId);
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN PHÒNG: " + dept.getName().toUpperCase() + " ---");

        if (employees.isEmpty()) {
            System.out.println("➡ Hiện tại phòng ban này chưa có nhân viên.");
        } else {
            displayEmployees(employees);
        }
    }

    private static void updateDepartment() {
        int updateId = InputValidator.getInt("Nhập ID phòng ban cần chỉnh sửa: ");
        Department existingDept = departmentController.findById(updateId);

        if (existingDept == null) {
            System.out.println("❌ Không tìm thấy phòng ban có ID: " + updateId);
            return;
        }

        System.out.println("\n--- NHẬP THÔNG TIN MỚI ---");
        System.out.print("Nhập tên mới: ");
        String updateName = scanner.nextLine();

        Department newDepartmentInfo = new Department(updateId, updateName);
        if (departmentController.update(updateId, newDepartmentInfo)) {
            System.out.println("✅ Cập nhật thành công phòng ban ID: " + updateId);
        } else {
            System.out.println("❌ Cập nhật thất bại. Vui lòng kiểm tra lại hệ thống lưu trữ!");
        }
    }

    private static void deleteDepartment() {
        int idToDelete = InputValidator.getInt("Nhập ID phòng ban cần xoá: ");

        Department dept = departmentController.findById(idToDelete);
        if (dept == null) {
            System.out.println("❌ Không tìm thấy phòng ban có ID: " + idToDelete);
            return;
        }

        System.out.printf("⚠ Bạn có chắc chắn muốn xoá phòng ban [%s] không? (Y/N): ", dept.getName());
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            if (departmentController.delete(idToDelete)) {
                System.out.println("✅ Đã xoá thành công phòng ban.");
            } else {
                System.out.println("❌ Xoá thất bại. Vui lòng kiểm tra lại!");
            }
        } else {
            System.out.println("➡ Đã hủy thao tác xoá.");
        }
    }

    private static void addDepartment() {
        int id = InputValidator.getInt("Nhập ID phòng ban: ");
        System.out.print("Nhập tên phòng ban: ");
        String name = scanner.nextLine();

        Department newDept = new Department(id, name);
        if (departmentController.add(newDept)) {
            System.out.println("✅ Thêm phòng ban mới thành công!");
        } else {
            System.out.println("❌ Thêm thất bại! ID [" + id + "] đã tồn tại.");
        }
    }

    public static void displayDepartment(List<Department> departments) {
        if (departments == null || departments.isEmpty()) {
            System.out.println("📭 Không tồn tại dữ liệu phòng ban.");
            return;
        }

        String line = "+----+------------------------------------------+";
        System.out.println("\n--- DANH SÁCH PHÒNG BAN ---");
        System.out.println(line);
        System.out.printf("| %-2s | %-40s |\n", "ID", "Tên Phòng Ban");
        System.out.println(line);

        for (Department department : departments) {
            System.out.println(department);
        }
        System.out.println(line);
    }
}
package HumanResources.view;

import HumanResources.controller.EmployeeController;
import HumanResources.entity.Department;
import HumanResources.entity.Employee;
import HumanResources.utils.InputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();
    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Chỉnh sửa nhân viên");
            System.out.println("5. Quay lại");

            // Sử dụng Validator cho menu để tránh nhập chữ bị crash
            int choice = InputValidator.getInt("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    List<Employee> employees = employeeController.getAll();
                    displayEmployees(employees);
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void deleteEmployee() {
        int idToDelete = InputValidator.getInt("Nhập ID nhân viên cần xoá: ");

        Employee employee = employeeController.findById(idToDelete);
        if (employee == null) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + idToDelete);
            return;
        }

        System.out.printf("⚠ Bạn có chắc chắn muốn xoá nhân viên [%s] (ID: %d) không? (Y/N): ",
                employee.getName(), idToDelete);
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            if (employeeController.delete(idToDelete)) {
                System.out.println("✅ Đã xoá thành công nhân viên.");
            } else {
                System.out.println("❌ Có lỗi xảy ra, không thể xoá.");
            }
        } else {
            System.out.println("➡ Đã hủy thao tác xoá.");
        }
    }

    private static void addNewEmployee() {
        int id = InputValidator.getInt("Nhập ID nhân viên: ");
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        LocalDate dob = InputValidator.getLocalDate("Nhập ngày sinh");
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        double salary = InputValidator.getDouble("Nhập lương: ");
        int deptId = InputValidator.getInt("Nhập ID phòng ban: ");

        Department dept = employeeController.findDeptById(deptId);
        if (dept == null) {
            System.out.println("❌ Thêm thất bại: Phòng ban " + deptId + " không tồn tại!");
            return;
        }

        if (employeeController.add(new Employee(id, name, dob, address, salary, dept))) {
            System.out.println("✅ Thêm thành công!");
        } else {
            System.out.println("❌ Thêm thất bại: ID " + id + " đã tồn tại!");
        }
    }

    private static void updateEmployee() {
        int updateId = InputValidator.getInt("Nhập ID nhân viên cần cập nhật: ");
        Employee existingEmp = employeeController.findById(updateId);

        if (existingEmp == null) {
            System.out.println("❌ Không tìm thấy nhân viên có ID: " + updateId);
            return;
        }

        System.out.println("\n--- NHẬP THÔNG TIN MỚI ---");
        System.out.print("Nhập tên mới: ");
        String updateName = scanner.nextLine();

        // Dùng Validator cho ngày sinh, lương và ID phòng ban
        LocalDate updateDob = InputValidator.getLocalDate("Nhập ngày sinh mới");

        System.out.print("Nhập địa chỉ mới: ");
        String updateAddress = scanner.nextLine();

        double updateSalary = InputValidator.getDouble("Nhập lương mới: ");

        int updateDeptId = InputValidator.getInt("Nhập ID phòng ban mới: ");

        Department updateDept = employeeController.findDeptById(updateDeptId);
        if (updateDept == null) {
            System.out.println("❌ ID phòng ban không tồn tại. Cập nhật thất bại!");
            return;
        }

        Employee newEmployeeInfo = new Employee(updateId, updateName, updateDob, updateAddress, updateSalary, updateDept);
        if (employeeController.update(updateId, newEmployeeInfo)) {
            System.out.println("✅ Cập nhật thành công nhân viên ID: " + updateId);
        } else {
            System.out.println("❌ Cập nhật thất bại. Có lỗi xảy ra!");
        }
    }

    public static void displayEmployees(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            System.out.println("📭 Danh sách nhân viên trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH NHÂN VIÊN ---");
        System.out.format("+-------+------------+------------+------------+--------------+----------------------+%n");
        System.out.format("| %-5s | %-10s | %-10s | %-10s | %-12s | %-20s |%n",
                "ID", "Tên", "Ngày sinh", "Địa chỉ", "Lương", "Phòng ban");
        System.out.format("+-------+------------+------------+------------+--------------+----------------------+%n");
        String deptName;
        for (Employee emp : employeeList) {
            if (emp.getDepartment() != null) {
                deptName = emp.getDepartment().getName();
            } else {
                deptName = "N/A";
            }
            System.out.format("| %-5d | %-10s | %-10s | %-10s | %-12.2f | %-20s |%n",
                    emp.getId(), emp.getName(), emp.getDob(), emp.getAddress(), emp.getSalary(), deptName);
        }
        System.out.format("+-------+------------+------------+------------+--------------+----------------------+%n");
    }
}
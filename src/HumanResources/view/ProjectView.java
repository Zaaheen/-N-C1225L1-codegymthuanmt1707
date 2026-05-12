package HumanResources.view;

import HumanResources.controller.ProjectController;
import HumanResources.entity.Project;
import HumanResources.utils.InputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProjectView {
    private static ProjectController projectController = new ProjectController();
    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DỰ ÁN ---");
            System.out.println("1. Danh sách dự án");
            System.out.println("2. Thêm dự án");
            System.out.println("3. Xóa dự án");
            System.out.println("4. Chỉnh sửa thông tin dự án");
            System.out.println("5. Quay lại");

            int choice = InputValidator.getInt("Chọn chức năng: ");
            switch (choice) {
                case 1:
                    List<Project> projects = projectController.getAll();
                    displayProjects(projects);
                    break;
                case 2:
                    addProject();
                    break;
                case 3:
                    deleteProject();
                    break;
                case 4:
                    updateProject();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void updateProject() {
        int updateId = InputValidator.getInt("Nhập ID dự án cần chỉnh sửa: ");
        Project existingProject = projectController.findById(updateId);

        if (existingProject == null) {
            System.out.println("❌ Không tìm thấy dự án có ID: " + updateId);
            return;
        }

        System.out.println("\n--- NHẬP THÔNG TIN MỚI ---");
        System.out.print("Nhập tên mới: ");
        String updateName = scanner.nextLine();

        LocalDate updateStartDate = InputValidator.getLocalDate("Nhập ngày bắt đầu mới");
        LocalDate updateEndDate = InputValidator.getLocalDate("Nhập ngày kết thúc mới");

        System.out.print("Nhập trạng thái mới: ");
        String updateStatus = scanner.nextLine();

        Project newProjectInfo = new Project(updateId, updateName, updateStartDate, updateEndDate, updateStatus);
        if (projectController.update(updateId, newProjectInfo)) {
            System.out.println("✅ Cập nhật thành công dự án ID: " + updateId);
        } else {
            System.out.println("❌ Cập nhật thất bại. Vui lòng kiểm tra lại dữ liệu file!");
        }
    }

    private static void deleteProject() {
        int delId = InputValidator.getInt("Nhập ID dự án cần xoá: ");

        // 1. Kiểm tra tồn tại
        Project project = projectController.findById(delId);
        if (project == null) {
            System.out.println("❌ Không tìm thấy dự án có ID: " + delId);
            return;
        }

        // 2. Xác nhận trước khi xóa
        System.out.printf("⚠ Bạn có chắc chắn muốn xoá dự án [%s] không? (Y/N): ", project.getName());
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            if (projectController.delete(delId)) {
                System.out.println("✅ Đã xoá thành công dự án.");
            } else {
                System.out.println("❌ Xoá thất bại!");
            }
        } else {
            System.out.println("➡ Đã hủy thao tác xoá.");
        }
    }

    private static void addProject() {
        int id = InputValidator.getInt("Nhập ID dự án: ");
        System.out.print("Nhập tên dự án: ");
        String name = scanner.nextLine();

        LocalDate startDate = InputValidator.getLocalDate("Nhập ngày bắt đầu");
        LocalDate endDate = InputValidator.getLocalDate("Nhập ngày kết thúc");

        System.out.print("Nhập trạng thái của dự án: ");
        String status = scanner.nextLine();

        if (projectController.add(new Project(id, name, startDate, endDate, status))) {
            System.out.println("✅ Thêm dự án thành công!");
        } else {
            System.out.println("❌ Thêm thất bại! ID [" + id + "] đã tồn tại.");
        }
    }

    public static void displayProjects(List<Project> projects) {
        if (projects == null || projects.isEmpty()) {
            System.out.println("❌ Không tồn tại dữ liệu dự án.");
            return;
        }

        String line = "+------+---------------------------+--------------+--------------+------------+";

        System.out.println(line);
        System.out.printf("| %-4s | %-25s | %-12s | %-12s | %-10s |\n",
                "ID", "Project Name", "Start Date", "End Date", "Status");
        System.out.println(line);

        for (Project project : projects) {
            System.out.println(project);
        }

        System.out.println(line);
    }
}
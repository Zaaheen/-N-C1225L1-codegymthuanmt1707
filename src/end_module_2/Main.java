package end_module_2;

import end_module_2.utils.InputValidator;
import end_module_2.view.MedicalRecordView;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
        MedicalRecordView service = new MedicalRecordView();

        while (true) {
            System.out.println("\n-- QUẢN LÝ BỆNH ÁN --");
            System.out.println("1. Thêm mới | 2. Xóa | 3. Xem danh sách | 4. Thoát");
            int choice = InputValidator.getInt("Chọn: ");

            switch (choice) {
                case 1:
                    int type = InputValidator.getInt("1. Thường | 2. VIP: ");
                    service.addRecord(type);
                    break;
                case 2:
                    service.removeRecord();
                    break;
                case 3:
                    service.displayAll();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}

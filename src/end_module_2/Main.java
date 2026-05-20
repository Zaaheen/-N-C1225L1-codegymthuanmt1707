package end_module_2;

import end_module_2.utils.InputValidator;
import end_module_2.view.MedicalRecordView;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dataDir = new File("src/end_module_2/data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        MedicalRecordView service = new MedicalRecordView();

        while (true) {
            System.out.println("\n-- QUẢN LÝ BỆNH ÁN --");
            System.out.println("1. Thêm mới | 2. Xóa | 3. Xem danh sách | 4. Thoát");
            int choice = InputValidator.getInt("Chọn: ");

            switch (choice) {
                case 1:
                    int type;
                    while (true) {
                        type = InputValidator.getInt("Chọn loại bệnh án (1. Thường | 2. VIP): ");
                        if (type == 1 || type == 2) {
                            break;
                        }
                        System.out.println("Lỗi: Lựa chọn không hợp lệ! Vui lòng nhập 1 hoặc 2. (P6)");
                    }
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

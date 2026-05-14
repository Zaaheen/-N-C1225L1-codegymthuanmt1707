package end_module_2.view;

import end_module_2.utils.InputValidator;
import end_module_2.entity.MedicalRecord;
import end_module_2.entity.NormalRecord;
import end_module_2.entity.VipRecord;
import end_module_2.repository.MedicalRecordRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MedicalRecordView {
    private final MedicalRecordRepository repository = new MedicalRecordRepository();
    private static final DateTimeFormatter VIEW_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void displayAll() {
        List<MedicalRecord> list = repository.findAll();
        if (list.isEmpty()) {
            System.out.println("Danh sách bệnh án hiện đang trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH BỆNH ÁN ---");
        System.out.printf("%-5s | %-10s | %-20s | %-12s | %-12s | %-20s%n",
                "STT", "Mã BA", "Tên BN", "Nhập viện", "Ra viện", "Thông tin riêng");
        System.out.println("-".repeat(90));

        for (MedicalRecord r : list) {
            System.out.printf("%-5d | %-10s | %-20s | %-12s | %-12s | %-20s%n",
                    r.getOrderNumber(),
                    r.getRecordCode(),
                    r.getPatientName(),
                    r.getAdmissionDate().format(VIEW_FORMAT),
                    r.getDischargeDate().format(VIEW_FORMAT),
                    r.getSpecificInfo());
        }
    }

    public void addRecord(int type) {
        String recordCode;
        // Kiểm tra trùng lặp mã bệnh án ngay tại View bằng cách hỏi Repository
        while (true) {
            recordCode = InputValidator.getValidRegex("Nhập mã bệnh án (BA-XXX): ", "BA-\\d{3}", "Lỗi: Mã BA phải có dạng BA-XXX (X là số)!");
            if (repository.isRecordCodeExists(recordCode)) {
                System.out.println("Lỗi: Mã bệnh án này đã tồn tại trên hệ thống! Vui lòng nhập mã khác.");
            } else {
                break;
            }
        }

        String patientCode = InputValidator.getValidRegex("Nhập mã bệnh nhân (BN-XXX): ", "BN-\\d{3}", "Lỗi: Mã BN phải có dạng BN-XXX (X là số)!");
        String name = InputValidator.getString("Nhập tên bệnh nhân: ");

        LocalDate admission = InputValidator.getLocalDate("Ngày nhập viện");
        LocalDate discharge = InputValidator.getLocalDate("Ngày ra viện");

        // Ràng buộc: Ngày nhập viện <= Ngày ra viện
        while (admission.isAfter(discharge)) {
            System.out.println("Lỗi: Ngày nhập viện không được sau ngày ra viện!");
            discharge = InputValidator.getLocalDate("Nhập lại ngày ra viện");
        }

        String reason = InputValidator.getString("Lý do nhập viện: ");
        MedicalRecord newRecord;

        if (type == 1) {
            double fee = InputValidator.getDouble("Phí nằm viện: ");
            // Khởi tạo tạm STT là 0, Repository sẽ tự động ghi đè lại STT chuẩn trước khi lưu
            newRecord = new NormalRecord(0, recordCode, patientCode, name, admission, discharge, reason, fee);
        } else {
            String vipType = InputValidator.getValidRegex("Loại VIP (VIP I, VIP II, VIP III): ", "VIP (I|II|III)", "Lỗi: Chỉ chấp nhận VIP I, II hoặc III!");
            LocalDate duration = InputValidator.getLocalDate("Thời hạn VIP");
            newRecord = new VipRecord(0, recordCode, patientCode, name, admission, discharge, reason, vipType, duration);
        }

        // Gọi Repository xử lý thêm và hứng kết quả boolean
        boolean isSuccess = repository.add(newRecord);
        if (isSuccess) {
            System.out.println("Thêm mới bệnh án thành công!");
        } else {
            System.out.println("Thêm mới thất bại do lỗi hệ thống.");
        }
    }

    public void removeRecord() {
        String code = InputValidator.getString("Nhập mã bệnh án cần xóa: ");

        // Kiểm tra xem mã có tồn tại không trước khi hỏi xác nhận xóa
        if (!repository.isRecordCodeExists(code)) {
            System.out.println("Lỗi: Mã bệnh án [" + code + "] không tồn tại trong hệ thống.");
            return;
        }

        String confirm = InputValidator.getString("Xác nhận xóa bệnh án " + code + "? (Yes/No): ");
        if (confirm.equalsIgnoreCase("Yes")) {
            // Gọi Repository xử lý xóa và hứng kết quả boolean
            boolean isDeleted = repository.delete(code);
            if (isDeleted) {
                System.out.println("Xóa thành công.");
                displayAll();
            } else {
                System.out.println("Xóa thất bại do lỗi hệ thống.");
            }
        } else {
            System.out.println("Hủy bỏ thao tác xóa.");
        }
    }
}
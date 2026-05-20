//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.view;

import end_module_2.entity.MedicalRecord;
import end_module_2.entity.NormalRecord;
import end_module_2.entity.VipRecord;
import end_module_2.repository.MedicalRecordRepository;
import end_module_2.utils.InputValidator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MedicalRecordView {
    private final MedicalRecordRepository repository = new MedicalRecordRepository();
    private static final DateTimeFormatter VIEW_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void displayAll() {
        List<MedicalRecord> var1 = this.repository.findAll();
        if (var1.isEmpty()) {
            System.out.println("Danh sách bệnh án hiện đang trống.");
        } else {
            System.out.println("\n--- DANH SÁCH BỆNH ÁN ---");
            System.out.printf("%-5s | %-10s | %-20s | %-12s | %-12s | %-20s%n", "STT", "Mã BA", "Tên BN", "Nhập viện", "Ra viện", "Thông tin riêng");
            System.out.println("-".repeat(90));

            for(MedicalRecord var3 : var1) {
                System.out.printf("%-5d | %-10s | %-20s | %-12s | %-12s | %-20s%n", var3.getOrderNumber(), var3.getRecordCode(), var3.getPatientName(), var3.getAdmissionDate().format(VIEW_FORMAT), var3.getDischargeDate().format(VIEW_FORMAT), var3.getSpecificInfo());
            }

        }
    }

    public void addRecord(int var1) {
        while(true) {
            String var2 = InputValidator.getValidRegex("Nhập mã bệnh án (BA-XXX): ", "(?i)BA-\\d{3}", "Lỗi: Mã BA phải có dạng BA-XXX (X là số)!");
            var2 = var2.toUpperCase();
            if (!this.repository.isRecordCodeExists(var2)) {
                String var3 = InputValidator.getValidRegex("Nhập mã bệnh nhân (BN-XXX): ", "(?i)BN-\\d{3}", "Lỗi: Mã BN phải có dạng BN-XXX (X là số)!");
                var3 = var3.toUpperCase();
                String var4 = InputValidator.getString("Nhập tên bệnh nhân: ");
                LocalDate var5 = InputValidator.getLocalDate("Ngày nhập viện");

                LocalDate var6;
                for(var6 = InputValidator.getLocalDate("Ngày ra viện"); var5.isAfter(var6); var6 = InputValidator.getLocalDate("Nhập lại ngày ra viện")) {
                    System.out.println("Lỗi: Ngày nhập viện không được sau ngày ra viện!");
                }

                String var7 = InputValidator.getString("Lý do nhập viện: ");
                Object var8;
                if (var1 != 1) {
                    String var13 = InputValidator.getValidRegex("Loại VIP (VIP I, VIP II, VIP III): ", "VIP (I|II|III)", "Lỗi: Chỉ chấp nhận VIP I, II hoặc III!");
                    LocalDate var10 = InputValidator.getLocalDate("Thời hạn VIP");
                    var8 = new VipRecord(0, var2, var3, var4, var5, var6, var7, var13, var10);
                } else {
                    while(true) {
                        double var9 = InputValidator.getDouble("Phí nằm viện: ");
                        if (var9 > (double)0.0F) {
                            var8 = new NormalRecord(0, var2, var3, var4, var5, var6, var7, var9);
                            break;
                        }

                        System.out.println("Lỗi: Phí nằm viện phải là số thực lớn hơn 0! (P6)");
                    }
                }

                boolean var14 = this.repository.add((MedicalRecord)var8);
                if (var14) {
                    System.out.println("Thêm mới bệnh án thành công!");
                } else {
                    System.out.println("Thêm mới thất bại do lỗi hệ thống.");
                }

                return;
            }

            System.out.println("Lỗi: Mã bệnh án này đã tồn tại trên hệ thống! Vui lòng nhập mã khác.");
        }
    }

    public void removeRecord() {
        String var1 = InputValidator.getString("Nhập mã bệnh án cần xóa: ");
        var1 = var1.toUpperCase();
        if (!this.repository.isRecordCodeExists(var1)) {
            System.out.println("Lỗi: Mã bệnh án [" + var1 + "] không tồn tại trong hệ thống.");
        } else {
            String var2 = InputValidator.getString("Xác nhận xóa bệnh án " + var1 + "? (Yes/No): ");
            if (var2.equalsIgnoreCase("Yes")) {
                boolean var3 = this.repository.delete(var1);
                if (var3) {
                    System.out.println("Xóa thành công.");
                    this.displayAll();
                } else {
                    System.out.println("Xóa thất bại do lỗi hệ thống.");
                }
            } else {
                System.out.println("Hủy bỏ thao tác xóa.");
            }

        }
    }
}

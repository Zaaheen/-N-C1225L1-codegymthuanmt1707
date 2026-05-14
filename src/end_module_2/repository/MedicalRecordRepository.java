package end_module_2.repository;

import end_module_2.entity.MedicalRecord;
import end_module_2.entity.NormalRecord;
import end_module_2.entity.VipRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicalRecordRepository {
    private static final String FILE_PATH = "src/end_module_2/data/medical_records.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void save(List<MedicalRecord> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (MedicalRecord record : list) {
                writer.write(record.toCSVData());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Lỗi hệ thống khi ghi file CSV: " + e.getMessage());
        }
    }

    public List<MedicalRecord> findAll() {
        List<MedicalRecord> list = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length < 8) continue;

                int order = Integer.parseInt(data[0].trim());
                String recordCode = data[1].trim();
                String patientCode = data[2].trim();
                String patientName = data[3].trim();
                LocalDate admission = LocalDate.parse(data[4].trim(), FORMATTER);
                LocalDate discharge = LocalDate.parse(data[5].trim(), FORMATTER);
                String reason = data[6].trim();

                if (data.length == 8) {
                    // Bệnh án thường: cột thứ 8 là phí nằm viện
                    double fee = Double.parseDouble(data[7].trim());
                    list.add(new NormalRecord(order, recordCode, patientCode, patientName, admission, discharge, reason, fee));
                } else if (data.length >= 9) {
                    // Bệnh án VIP: cột 8 là loại VIP, cột 9 là thời hạn VIP
                    String vipType = data[7].trim();
                    LocalDate vipDuration = LocalDate.parse(data[8].trim(), FORMATTER);
                    list.add(new VipRecord(order, recordCode, patientCode, patientName, admission, discharge, reason, vipType, vipDuration));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file dữ liệu CSV.");
        } catch (IOException e) {
            System.out.println("Lỗi: Xảy ra sự cố khi đọc file.");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file CSV: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi định dạng ngày tháng trong file CSV (Yêu cầu dd/MM/yyyy): " + e.getMessage());
        }
        return list;
    }

    public boolean isRecordCodeExists(String recordCode) {
        List<MedicalRecord> list = findAll();
        return list.stream().anyMatch(r -> r.getRecordCode().equalsIgnoreCase(recordCode));
    }

    public boolean add(MedicalRecord newRecord) {
        try {
            List<MedicalRecord> list = findAll();

            // Tự động tính số thứ tự chuẩn xác
            int nextOrder = list.isEmpty() ? 1 : list.get(list.size() - 1).getOrderNumber() + 1;
            newRecord.setOrderNumber(nextOrder);

            list.add(newRecord);
            save(list); // Đồng bộ lưu xuống file
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm bệnh án: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(String recordCode) {
        List<MedicalRecord> list = findAll();

        Optional<MedicalRecord> target = list.stream()
                .filter(r -> r.getRecordCode().equalsIgnoreCase(recordCode))
                .findFirst();

        if (target.isPresent()) {
            list.remove(target.get());

            for (int i = 0; i < list.size(); i++) {
                list.get(i).setOrderNumber(i + 1);
            }

            save(list);
            return true;
        }
        return false;
    }
}
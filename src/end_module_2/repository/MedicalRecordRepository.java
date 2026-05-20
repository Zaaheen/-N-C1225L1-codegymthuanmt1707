//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.repository;

import end_module_2.entity.MedicalRecord;
import end_module_2.entity.NormalRecord;
import end_module_2.entity.VipRecord;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordRepository {
    private static final String FILE_PATH = "src/end_module_2/data/medical_records.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Map<String, MedicalRecord> records = new HashMap();
    private boolean isLoaded = false;

    public MedicalRecordRepository() {
        this.loadFromFile();
    }

    private void loadFromFile() {
        File var1 = new File("src/end_module_2/data/medical_records.csv");
        if (!var1.exists()) {
            this.isLoaded = true;
        } else {
            try (BufferedReader var2 = new BufferedReader(new FileReader(var1))) {
                String var3;
                while((var3 = var2.readLine()) != null) {
                    if (!var3.trim().isEmpty()) {
                        try {
                            String[] var4 = var3.split("(?<!\\\\),");
                            if (var4.length < 8) {
                                System.out.println("Cảnh báo: Dòng dữ liệu không đủ số cột: " + var3);
                            } else {
                                int var5 = Integer.parseInt(var4[0].trim());
                                String var6 = unescapeComma(var4[1].trim()).toUpperCase();
                                String var7 = unescapeComma(var4[2].trim()).toUpperCase();
                                String var8 = unescapeComma(var4[3].trim());
                                LocalDate var9 = LocalDate.parse(var4[4].trim(), FORMATTER);
                                LocalDate var10 = LocalDate.parse(var4[5].trim(), FORMATTER);
                                String var11 = unescapeComma(var4[6].trim());
                                MedicalRecord var12 = null;
                                if (var4.length == 8) {
                                    double var13 = Double.parseDouble(var4[7].trim());
                                    var12 = new NormalRecord(var5, var6, var7, var8, var9, var10, var11, var13);
                                } else if (var4.length >= 9) {
                                    String var19 = unescapeComma(var4[7].trim());
                                    LocalDate var14 = LocalDate.parse(var4[8].trim(), FORMATTER);
                                    var12 = new VipRecord(var5, var6, var7, var8, var9, var10, var11, var19, var14);
                                }

                                if (var12 != null) {
                                    this.records.put(var6, var12);
                                }
                            }
                        } catch (DateTimeParseException | NumberFormatException var16) {
                            System.out.println("Cảnh báo: Lỗi định dạng khi parse dòng: \"" + var3 + "\". Chi tiết: " + ((RuntimeException)var16).getMessage());
                        }
                    }
                }

                this.isLoaded = true;
            } catch (IOException var18) {
                System.out.println("Lỗi nghiêm trọng khi đọc file dữ liệu CSV: " + var18.getMessage());
                this.isLoaded = false;
            }

        }
    }

    private void save() {
        if (!this.isLoaded) {
            System.out.println("Lỗi: Hệ thống đang ở trạng thái bảo vệ dữ liệu do lỗi đọc file trước đó. Từ chối ghi file!");
        } else {
            File var1 = new File("src/end_module_2/data/medical_records.csv");
            File var2 = var1.getParentFile();
            if (var2 != null && !var2.exists()) {
                var2.mkdirs();
            }

            File var3 = new File("src/end_module_2/data/medical_records.csv.tmp");

            try (BufferedWriter var4 = new BufferedWriter(new FileWriter(var3))) {
                ArrayList<MedicalRecord> var5 = new ArrayList<>(this.records.values());
                var5.sort(Comparator.comparingInt(MedicalRecord::getOrderNumber));

                for(MedicalRecord var7 : var5) {
                    var4.write(var7.toCSVData());
                    var4.newLine();
                }

                var4.flush();
            } catch (IOException var11) {
                System.out.println("Lỗi hệ thống khi ghi file tạm CSV: " + var11.getMessage());
                return;
            }

            try {
                if (var3.exists()) {
                    if (!this.records.isEmpty() && var3.length() <= 0L) {
                        System.out.println("Lỗi nghiêm trọng: File tạm rỗng trong khi bộ nhớ có dữ liệu. Hủy thao tác ghi!");
                    } else {
                        Files.move(var3.toPath(), var1.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            } catch (IOException var9) {
                System.out.println("Lỗi khi đổi tên file tạm sang file chính thức: " + var9.getMessage());
            }

        }
    }

    private static String unescapeComma(String var0) {
        return var0 == null ? "" : var0.replace("\\,", ",");
    }

    public List<MedicalRecord> findAll() {
        ArrayList var1 = new ArrayList();

        for(MedicalRecord var3 : this.records.values()) {
            var1.add(var3.copy());
        }

        var1.sort(Comparator.comparingInt(MedicalRecord::getOrderNumber));
        return var1;
    }

    public boolean isRecordCodeExists(String var1) {
        return var1 == null ? false : this.records.containsKey(var1.toUpperCase());
    }

    public boolean add(MedicalRecord var1) {
        if (!this.isLoaded) {
            System.out.println("Lỗi: Hệ thống ở trạng thái bảo vệ dữ liệu, không thể thêm bệnh án mới.");
            return false;
        } else {
            try {
                String var2 = var1.getRecordCode().toUpperCase();
                var1.setRecordCode(var2);
                if (var1.getPatientCode() != null) {
                    var1.setPatientCode(var1.getPatientCode().toUpperCase());
                }

                int var3 = 1;
                if (!this.records.isEmpty()) {
                    int var4 = 0;

                    for(MedicalRecord var6 : this.records.values()) {
                        if (var6.getOrderNumber() > var4) {
                            var4 = var6.getOrderNumber();
                        }
                    }

                    var3 = var4 + 1;
                }

                var1.setOrderNumber(var3);
                this.records.put(var2, var1.copy());
                this.save();
                return true;
            } catch (Exception var7) {
                System.out.println("Lỗi khi thêm bệnh án: " + var7.getMessage());
                return false;
            }
        }
    }

    public boolean delete(String var1) {
        if (!this.isLoaded) {
            System.out.println("Lỗi: Hệ thống ở trạng thái bảo vệ dữ liệu, không thể xóa.");
            return false;
        } else if (var1 == null) {
            return false;
        } else {
            String var2 = var1.toUpperCase();
            if (!this.records.containsKey(var2)) {
                return false;
            } else {
                this.records.remove(var2);
                ArrayList var3 = new ArrayList(this.records.values());
                var3.sort(Comparator.comparingInt(MedicalRecord::getOrderNumber));

                for(int var4 = 0; var4 < var3.size(); ++var4) {
                    ((MedicalRecord)var3.get(var4)).setOrderNumber(var4 + 1);
                }

                this.save();
                return true;
            }
        }
    }
}

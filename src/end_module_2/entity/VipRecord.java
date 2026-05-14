package end_module_2.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VipRecord extends MedicalRecord{
    private String vipType;
    private LocalDate vipDuration;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VipRecord() {

    }

    public VipRecord(int orderNumber, String recordCode, String patientCode, String patientName,
                     LocalDate admissionDate, LocalDate dischargeDate, String reason, String vipType, LocalDate vipDuration) {
        super(orderNumber, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.vipType = vipType;
        this.vipDuration = vipDuration;
    }

    @Override
    public String getSpecificInfo() {
        return "Loại VIP: " + vipType + ", Thời hạn: " + vipDuration.format(FORMATTER);
    }
    @Override
    public String toCSVData() {
        return super.toCSVData() + "," + vipType + "," + vipDuration.format(FORMATTER);
    }
}

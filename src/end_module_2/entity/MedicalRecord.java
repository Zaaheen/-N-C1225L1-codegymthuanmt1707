package end_module_2.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class MedicalRecord {
    private Integer orderNumber;
    private String recordCode;
    private String patientCode;
    private String patientName;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String reason;

    private static final DateTimeFormatter FILE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MedicalRecord() {

    }
    public MedicalRecord(Integer orderNumber, String recordCode, String patientCode, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reason) {
        this.orderNumber = orderNumber;
        this.recordCode = recordCode;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s",
                orderNumber, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
    }
    public abstract String getSpecificInfo();
    public String toCSVData() {
        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return orderNumber + "," + recordCode + "," + patientCode + "," + patientName + "," +
                admissionDate.format(fmt) + "," + dischargeDate.format(fmt) + "," + reason;
    }
}

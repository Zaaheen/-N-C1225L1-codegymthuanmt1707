//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class MedicalRecord {
    private int orderNumber;
    private String recordCode;
    private String patientCode;
    private String patientName;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String reason;
    private static final DateTimeFormatter FILE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MedicalRecord() {
    }

    public MedicalRecord(int var1, String var2, String var3, String var4, LocalDate var5, LocalDate var6, String var7) {
        this.orderNumber = var1;
        this.recordCode = var2 != null ? var2.toUpperCase() : null;
        this.patientCode = var3 != null ? var3.toUpperCase() : null;
        this.patientName = var4;
        this.admissionDate = var5;
        this.dischargeDate = var6;
        this.reason = var7;
    }

    public MedicalRecord(MedicalRecord var1) {
        this.orderNumber = var1.orderNumber;
        this.recordCode = var1.recordCode;
        this.patientCode = var1.patientCode;
        this.patientName = var1.patientName;
        this.admissionDate = var1.admissionDate;
        this.dischargeDate = var1.dischargeDate;
        this.reason = var1.reason;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int var1) {
        this.orderNumber = var1;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public void setRecordCode(String var1) {
        this.recordCode = var1 != null ? var1.toUpperCase() : null;
    }

    public String getPatientCode() {
        return this.patientCode;
    }

    public void setPatientCode(String var1) {
        this.patientCode = var1 != null ? var1.toUpperCase() : null;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String var1) {
        this.patientName = var1;
    }

    public LocalDate getAdmissionDate() {
        return this.admissionDate;
    }

    public void setAdmissionDate(LocalDate var1) {
        this.admissionDate = var1;
    }

    public LocalDate getDischargeDate() {
        return this.dischargeDate;
    }

    public void setDischargeDate(LocalDate var1) {
        this.dischargeDate = var1;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String var1) {
        this.reason = var1;
    }

    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s", this.orderNumber, this.recordCode, this.patientCode, this.patientName, this.admissionDate, this.dischargeDate, this.reason);
    }

    public abstract String getSpecificInfo();

    public abstract MedicalRecord copy();

    protected String escapeComma(String var1) {
        return var1 == null ? "" : var1.replace(",", "\\,");
    }

    public String toCSVData() {
        int var10000 = this.orderNumber;
        return var10000 + "," + this.escapeComma(this.recordCode) + "," + this.escapeComma(this.patientCode) + "," + this.escapeComma(this.patientName) + "," + this.admissionDate.format(FILE_FORMAT) + "," + this.dischargeDate.format(FILE_FORMAT) + "," + this.escapeComma(this.reason);
    }
}

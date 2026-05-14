package end_module_2.entity;

import java.time.LocalDate;

public class NormalRecord extends MedicalRecord{
    private Double hospitalFee;

    public NormalRecord() {

    }

    public NormalRecord(Integer orderNumber, String recordCode, String patientCode, String patientName,
                        LocalDate admissionDate, LocalDate dischargeDate, String reason, Double hospitalFee) {
        super(orderNumber, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.hospitalFee = hospitalFee;
    }
    @Override
    public String getSpecificInfo() {
        return "Phí nằm viện: " + hospitalFee;
    }
    @Override
    public String toCSVData() {
        return super.toCSVData() + "," + hospitalFee;
    }
}

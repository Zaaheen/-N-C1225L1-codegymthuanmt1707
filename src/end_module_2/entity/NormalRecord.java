//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.entity;

import java.time.LocalDate;

public class NormalRecord extends MedicalRecord {
    private Double hospitalFee;

    public NormalRecord() {
    }

    public NormalRecord(int var1, String var2, String var3, String var4, LocalDate var5, LocalDate var6, String var7, Double var8) {
        super(var1, var2, var3, var4, var5, var6, var7);
        this.hospitalFee = var8;
    }

    public NormalRecord(NormalRecord var1) {
        super(var1);
        this.hospitalFee = var1.hospitalFee;
    }

    public NormalRecord copy() {
        return new NormalRecord(this);
    }

    public Double getHospitalFee() {
        return this.hospitalFee;
    }

    public void setHospitalFee(Double var1) {
        this.hospitalFee = var1;
    }

    public String getSpecificInfo() {
        return "Phí nằm viện: " + this.hospitalFee;
    }

    public String toCSVData() {
        String var10000 = super.toCSVData();
        return var10000 + "," + this.hospitalFee;
    }
}

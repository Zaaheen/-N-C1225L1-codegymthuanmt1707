//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package end_module_2.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VipRecord extends MedicalRecord {
    private String vipType;
    private LocalDate vipDuration;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public VipRecord() {
    }

    public VipRecord(int var1, String var2, String var3, String var4, LocalDate var5, LocalDate var6, String var7, String var8, LocalDate var9) {
        super(var1, var2, var3, var4, var5, var6, var7);
        this.vipType = var8;
        this.vipDuration = var9;
    }

    public VipRecord(VipRecord var1) {
        super(var1);
        this.vipType = var1.vipType;
        this.vipDuration = var1.vipDuration;
    }

    public VipRecord copy() {
        return new VipRecord(this);
    }

    public String getVipType() {
        return this.vipType;
    }

    public void setVipType(String var1) {
        this.vipType = var1;
    }

    public LocalDate getVipDuration() {
        return this.vipDuration;
    }

    public void setVipDuration(LocalDate var1) {
        this.vipDuration = var1;
    }

    public String getSpecificInfo() {
        String var10000 = this.vipType;
        return "Loại VIP: " + var10000 + ", Thời hạn: " + this.vipDuration.format(FORMATTER);
    }

    public String toCSVData() {
        String var10000 = super.toCSVData();
        return var10000 + "," + this.escapeComma(this.vipType) + "," + this.vipDuration.format(FORMATTER);
    }
}

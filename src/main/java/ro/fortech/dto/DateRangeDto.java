package ro.fortech.dto;

import java.math.BigDecimal;

public class DateRangeDto {
    private String kesKem;
    private BigDecimal kesSda;
    private BigDecimal kesSdb;

    public String getKesKem() {
        return kesKem;
    }

    public void setKesKem(String kesKem) {
        this.kesKem = kesKem;
    }

    public BigDecimal getKesSda() {
        return kesSda;
    }

    public void setKesSda(BigDecimal kesSda) {
        this.kesSda = kesSda;
    }

    public BigDecimal getKesSdb() {
        return kesSdb;
    }

    public void setKesSdb(BigDecimal kesSdb) {
        this.kesSdb = kesSdb;
    }
}

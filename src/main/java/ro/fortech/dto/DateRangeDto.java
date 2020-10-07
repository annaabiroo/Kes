package ro.fortech.dto;

import java.math.BigDecimal;

public class DateRangeDto {
    private String kesKem;
    private String biggerThan;
    private String smallerThan;

    public String getKesKem() {
        return kesKem;
    }

    public void setKesKem(String kesKem) {
        this.kesKem = kesKem;
    }

    public String getBiggerThan() {
        return biggerThan;
    }

    public void setBiggerThan(String biggerThan) {
        this.biggerThan = biggerThan;
    }

    public String getSmallerThan() {
        return smallerThan;
    }

    public void setSmallerThan(String smallerThan) {
        this.smallerThan = smallerThan;
    }
}

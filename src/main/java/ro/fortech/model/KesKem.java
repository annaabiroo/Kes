package ro.fortech.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@Table("table_kem")
public class KesKem extends Kes {
    @PrimaryKey("kes_kem")
    private String kesKem;
    @Column("kes_sda")
    private String kesSda;
    @Column("kes_sdb")
    private String kesSdb;

    public String getKesKem() {
        return kesKem;
    }

    public void setKesKem(String kesKem) {
        this.kesKem = kesKem;
    }

    public String getKesSda() {
        return kesSda;
    }

    public void setKesSda(String kesSda) {
        this.kesSda = kesSda;
    }

    public String getKesSdb() {
        return kesSdb;
    }

    public void setKesSdb(String kesSdb) {
        this.kesSdb = kesSdb;
    }
}

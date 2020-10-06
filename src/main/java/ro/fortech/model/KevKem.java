package ro.fortech.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.AllowFiltering;

import java.math.BigDecimal;

@Table("table_kem")
public class KevKem extends Kev {
    @PrimaryKey("kes_kem")
    private String kesKem;
    @Column("kes_sda")
    private BigDecimal kesSda;
    @Column("kes_sdb")
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

package ro.fortech.repo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import ro.fortech.model.KesKem;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface KesKemRepository extends CassandraRepository<KesKem, String> {
    @Query("SELECT * FROM table_kem WHERE kes_kem=?0;")
    List<KesKem> findAllByKesKem(String kesKem);
    @Query("SELECT * FROM table_kem WHERE kes_sda > ?0 AND kes_sda < ?1 ALLOW FILTERING;")
    List<KesKem> findAllByKesSdaInRange(String biggerThan, String smallerThan);
}

package ro.fortech.repo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.model.KevKem;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface KevKemRepository extends CassandraRepository<KevKem, String> {
    List<KevKem> findAllByKesKem(String kesKem);
    @AllowFiltering
    List<KevKem> findAllByKesSdaAfterAndKesSdbBefore(BigDecimal kesSda, BigDecimal kesSdb);
}

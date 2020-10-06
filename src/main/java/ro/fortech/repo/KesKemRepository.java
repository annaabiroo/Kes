package ro.fortech.repo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.model.KesKem;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface KesKemRepository extends CassandraRepository<KesKem, String> {
    List<KesKem> findAllByKesKem(String kesKem);
    @AllowFiltering
    List<KesKem> findAllByKesSdaAfterAndKesSdbBefore(BigDecimal kesSda, BigDecimal kesSdb);
}

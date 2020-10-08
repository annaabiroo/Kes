package ro.fortech.repo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.fortech.converter.DateConverter;
import ro.fortech.model.KesKem;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class KesKemRepositoryImpl {
    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public KesKemRepositoryImpl(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public List<KesKem> getAllByKesKem(String kesKem) {
        Statement query = QueryBuilder.select()
                .from("kev", "table_kem")
                .where(QueryBuilder.eq("kes_kem", kesKem));

        return cassandraTemplate.select(query, KesKem.class);

    }

    public List<KesKem> findAllByKesSdaInRange(String biggerThan, String smallerThan) {
        Optional<String> biggerThanKesFormat = DateConverter.convertFromISOtoKesFormat(biggerThan);
        Optional<String> smallerThanKesFormat = DateConverter.convertFromISOtoKesFormat(smallerThan);

        if (biggerThanKesFormat.isPresent() && smallerThanKesFormat.isPresent()) {
            Statement query = QueryBuilder.select()
                    .from("kev", "table_kem")
                    .where(QueryBuilder.gt("kes_sda", biggerThanKesFormat.get()))
                    .and(QueryBuilder.lt("kes_sda", smallerThanKesFormat.get()))
                    .allowFiltering();
            return cassandraTemplate.select(query, KesKem.class);
        }
        return Collections.emptyList();
    }

    public List<KesKem> findAllByKesKemAndKesSdaInRange(String kesKem, String biggerThan, String smallerThan) {
        Optional<String> biggerThanKesFormat = DateConverter.convertFromISOtoKesFormat(biggerThan);
        Optional<String> smallerThanKesFormat = DateConverter.convertFromISOtoKesFormat(smallerThan);

        if (biggerThanKesFormat.isPresent() && smallerThanKesFormat.isPresent()) {

            Statement query = QueryBuilder.select()
                    .from("kev", "table_kem")
                    .where(QueryBuilder.eq("kes_kem", kesKem))
                    .and(QueryBuilder.gt("kes_sda", biggerThanKesFormat.get()))
                    .and(QueryBuilder.lt("kes_sda", smallerThanKesFormat.get()))
                    .allowFiltering();

            return cassandraTemplate.select(query, KesKem.class);
        }
        return Collections.emptyList();
    }
}

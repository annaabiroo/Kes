package ro.fortech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;
import ro.fortech.converter.DateConverter;
import ro.fortech.model.KesKem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class KesKemService {
    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public KesKemService(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public List<KesKem> getAllByKesKem(String kesKem) {
        String stringBuilder = "select * from table_kem where kes_kem =" + "'" +
                kesKem +
                "'";
        return cassandraTemplate.select(stringBuilder, KesKem.class);
    }

    public List<KesKem> getAllByKesKemAndKesSdaInRange(String kesKem, String biggerThan, String smallerThan) {
        List<KesKem> kesAll = this.getAllByKesKem(kesKem);
        List<KesKem> kesFiltered = new ArrayList<>();
        for (KesKem k : kesAll) {
            Optional<String> dateSda = DateConverter.convertFromKesToISOdateFormat(k.getKesSda());
            if (dateSda.isPresent())
                if (dateSda.get().compareTo(biggerThan) > 0 && dateSda.get().compareTo(smallerThan) < 0)
                    kesFiltered.add(k);
        }
        return kesFiltered;
    }

    public List<KesKem> getAllByKesSdaInRange(String biggerThan, String smallerThan) {
        Optional<String> biggerThanKesFormat = DateConverter.convertFromISOtoKesFormat(biggerThan);
        Optional<String> smallerThanKesFormat = DateConverter.convertFromISOtoKesFormat(smallerThan);

        if (biggerThanKesFormat.isPresent() && smallerThanKesFormat.isPresent()) {
            String stringBuilder = "SELECT * FROM table_kem WHERE kes_sda > " + "'" +
                    biggerThanKesFormat.get() + "'" +
                    " AND kes_sda < " + "'" +
                    smallerThanKesFormat.get() + "'" +
                    " ALLOW FILTERING";
            return cassandraTemplate.select(stringBuilder, KesKem.class);
        }
        return Collections.emptyList();
    }
}

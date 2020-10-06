package ro.fortech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.exception.KevNotFoundException;
import ro.fortech.model.Kev;
import ro.fortech.model.KevKem;
import ro.fortech.repo.KevKemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KevKemService {
    private final KevKemRepository kevKemRepository;

    @Autowired
    public KevKemService(KevKemRepository kevKemRepository) {
        this.kevKemRepository = kevKemRepository;
    }

    public List<KevKem> getAllByKesKem(String kesKem) {
        List<KevKem> kev = kevKemRepository.findAllByKesKem(kesKem);
        if (!kev.isEmpty())
            return kev;
        else
            throw new KevNotFoundException("Object with the given id does not exist!");

    }

    public List<KevKem> getAllByKesKemAndKesSdaAfterAndKesSdbBefore(String kesKem, BigDecimal kesSda, BigDecimal kesSdb) {
        List<KevKem> kevAll = kevKemRepository.findAllByKesKem(kesKem);
        List<KevKem> kevFiltered = new ArrayList<>();
        for (KevKem k : kevAll) {
            if (k.getKesSda().compareTo(kesSda) > 0 && k.getKesSdb().compareTo(kesSdb) < 0)
                kevFiltered.add(k);
        }
        return kevFiltered;
    }

    public List<KevKem> getAllByKesSdaAfterAndKesSdbBefore(BigDecimal kesSda, BigDecimal kesSdb) {
        return kevKemRepository.findAllByKesSdaAfterAndKesSdbBefore(kesSda, kesSdb);
    }
}

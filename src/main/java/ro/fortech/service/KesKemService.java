package ro.fortech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.exception.KesNotFoundException;
import ro.fortech.model.KesKem;
import ro.fortech.repo.KesKemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class KesKemService {
    private final KesKemRepository kesKemRepository;

    @Autowired
    public KesKemService(KesKemRepository kesKemRepository) {
        this.kesKemRepository = kesKemRepository;
    }

    public List<KesKem> getAllByKesKem(String kesKem) {
        List<KesKem> kes = kesKemRepository.findAllByKesKem(kesKem);
        if (!kes.isEmpty())
            return kes;
        else
            throw new KesNotFoundException("Object with the given id does not exist!");

    }

    public List<KesKem> getAllByKesKemAndKesSdaAfterAndKesSdbBefore(String kesKem, BigDecimal kesSda, BigDecimal kesSdb) {
        List<KesKem> kesAll = kesKemRepository.findAllByKesKem(kesKem);
        List<KesKem> kesFiltered = new ArrayList<>();
        for (KesKem k : kesAll) {
            if (k.getKesSda().compareTo(kesSda) > 0 && k.getKesSdb().compareTo(kesSdb) < 0)
                kesFiltered.add(k);
        }
        return kesFiltered;
    }

    public List<KesKem> getAllByKesSdaAfterAndKesSdbBefore(BigDecimal kesSda, BigDecimal kesSdb) {
        return kesKemRepository.findAllByKesSdaAfterAndKesSdbBefore(kesSda, kesSdb);
    }
}

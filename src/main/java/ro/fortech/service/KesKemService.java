package ro.fortech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.converter.DateConverter;
import ro.fortech.exception.KesNotFoundException;
import ro.fortech.model.KesKem;
import ro.fortech.repo.KesKemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<KesKem> getAllByKesKemAndKesSdaInRange(String kesKem, String biggerThan, String smallerThan) {
        List<KesKem> kesAll = kesKemRepository.findAllByKesKem(kesKem);
        List<KesKem> kesFiltered = new ArrayList<>();
        for (KesKem k : kesAll) {
            Optional<String> dateSda = DateConverter.convertFromKesToISOdateFormat(k.getKesSda());
            if (dateSda.isPresent())
                if (dateSda.get().compareTo(biggerThan) > 0 && dateSda.get().compareTo(smallerThan) < 0)
                    kesFiltered.add(k);
        }
        return kesFiltered;
    }

    public List<KesKem> getAllByKesSdaInRange(String biggerThan, String smalerThan) {
        return kesKemRepository.findAllByKesSdaInRange(biggerThan, smalerThan);
    }
}

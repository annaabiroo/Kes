package ro.fortech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.converter.DateConverter;
import ro.fortech.model.KesKem;
import ro.fortech.repo.KesKemRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KesKemService {
    private final KesKemRepositoryImpl kesKemRepository;

    @Autowired
    public KesKemService(KesKemRepositoryImpl kesKemRepository) {
        this.kesKemRepository = kesKemRepository;
    }

    public List<KesKem> getAllByKesKem(String kesKem) {
        return kesKemRepository.getAllByKesKem(kesKem);
    }

    public List<KesKem> getAllByKesKemAndKesSdaInRange(String kesKem, String biggerThan, String smallerThan) {
        return kesKemRepository.findAllByKesKemAndKesSdaInRange(kesKem, biggerThan, smallerThan);
    }

    public List<KesKem> getAllByKesSdaInRange(String biggerThan, String smallerThan) {
        return kesKemRepository.findAllByKesSdaInRange(biggerThan, smallerThan);
    }
}

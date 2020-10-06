package ro.fortech.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fortech.dto.DateRangeDto;
import ro.fortech.model.KesKem;
import ro.fortech.service.KesKemService;

import java.util.List;

@Controller
@RequestMapping("/kestable")
public class KesController {
    private final KesKemService kesKemService;

    @Autowired
    public KesController(KesKemService kesKemService) {
        this.kesKemService = kesKemService;
    }

    @GetMapping("/{kes_kem}")
    public ResponseEntity<List<KesKem>> getByKesKem(@PathVariable String kes_kem) {
        return new ResponseEntity<>(kesKemService.getAllByKesKem(kes_kem), HttpStatus.OK);
    }

    @GetMapping("/daterange")
    public ResponseEntity<List<KesKem>> getKevByKesKemAndKesSdaAndKesSdb(@RequestBody DateRangeDto dateRangeDTO) {
        if (dateRangeDTO.getKesKem().isEmpty()) {
            return new ResponseEntity<>(kesKemService.getAllByKesSdaAfterAndKesSdbBefore(
                    dateRangeDTO.getKesSda(),
                    dateRangeDTO.getKesSdb()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(kesKemService.getAllByKesKemAndKesSdaAfterAndKesSdbBefore(
                    dateRangeDTO.getKesKem(),
                    dateRangeDTO.getKesSda(),
                    dateRangeDTO.getKesSdb()), HttpStatus.OK);
        }
    }
}

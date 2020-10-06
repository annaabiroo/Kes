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
import ro.fortech.model.Kev;
import ro.fortech.model.KevKem;
import ro.fortech.service.KevKemService;

import java.util.List;

@Controller
@RequestMapping("/kevtable")
public class KevController {
    private final KevKemService kevKemService;

    @Autowired
    public KevController(KevKemService kevKemService) {
        this.kevKemService = kevKemService;
    }

    @GetMapping("/{kes_kem}")
    public ResponseEntity<List<KevKem>> getByKesKem(@PathVariable String kes_kem) {
        return new ResponseEntity<>(kevKemService.getAllByKesKem(kes_kem), HttpStatus.OK);
    }

    @GetMapping("/daterange")
    public ResponseEntity<List<KevKem>> getKevByKesKemAndKesSdaAndKesSdb(@RequestBody DateRangeDto dateRangeDTO) {
        if (dateRangeDTO.getKesKem().isEmpty()) {
            return new ResponseEntity<>(kevKemService.getAllByKesSdaAfterAndKesSdbBefore(
                    dateRangeDTO.getKesSda(),
                    dateRangeDTO.getKesSdb()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(kevKemService.getAllByKesKemAndKesSdaAfterAndKesSdbBefore(
                    dateRangeDTO.getKesKem(),
                    dateRangeDTO.getKesSda(),
                    dateRangeDTO.getKesSdb()), HttpStatus.OK);
        }
    }
}

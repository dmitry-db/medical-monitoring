package liga.medical.medicalmonitoring.core.controller.rest;

import liga.medical.medicalmonitoring.api.MedicalHistoryService;
import liga.medical.medicalmonitoring.dto.MedicalHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical")
public class MedicalHistoryController {

    private final MedicalHistoryService service;

    @Autowired
    public MedicalHistoryController(MedicalHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MedicalHistoryDto> save(@RequestBody MedicalHistoryDto medicalHistoryDto) {
        return ResponseEntity.ok(service.save(medicalHistoryDto));
    }

    @GetMapping
    public ResponseEntity<MedicalHistoryDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}

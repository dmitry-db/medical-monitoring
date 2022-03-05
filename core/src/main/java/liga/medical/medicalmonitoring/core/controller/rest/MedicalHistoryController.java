package liga.medical.medicalmonitoring.core.controller.rest;

import liga.medical.medicalmonitoring.core.exception_handling.medical_history.medical_history_exception.NoSuchMedicalHistoryException;
import liga.medical.medicalmonitoring.core.model.entity.MedicalHistory;
import liga.medical.medicalmonitoring.core.service.MedicalHistoryService;
import liga.medical.medicalmonitoring.core.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/medical-histories")
@RequiredArgsConstructor
public class MedicalHistoryController {

    private final PatientServiceImpl patientService;
    private final MedicalHistoryService medicalHistoryService;

    @GetMapping
    public List<MedicalHistory> findAll() {
        return medicalHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public MedicalHistory findMedicalHistory(@PathVariable("id") Long id) {
        if (medicalHistoryService.findById(id) == null) {
            throw new NoSuchMedicalHistoryException("There is no medical history with ID = " + id + " in database");
        } else {
            return medicalHistoryService.findById(id);
        }
    }

    @PostMapping
    public MedicalHistory createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        if (patientService.findById(medicalHistory.getPatient().getId()) == null) {
            throw new RuntimeException("no patient with id in this medical history");
        }
        medicalHistoryService.save(medicalHistory);
        return medicalHistory;
    }

    @PatchMapping("/{id}")
    public MedicalHistory updatePatient(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
        if (medicalHistoryService.findById(medicalHistory.getId()) == null) {
            throw new RuntimeException("no medical history with this id");
        }
        if (patientService.findById(medicalHistory.getPatient().getId()) == null) {
            throw new RuntimeException("no patient with id in this medical history");
        }
        medicalHistoryService.update(id, medicalHistory);
        return medicalHistoryService.findById(medicalHistory.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        MedicalHistory medicalHistory = medicalHistoryService.findById(id);

        if (medicalHistory == null) {
            throw new RuntimeException("no patient with id = " + id);
        }
        medicalHistoryService.deleteById(id);
        return "Patient with id = " + id + "was deleted";
    }
}

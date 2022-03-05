package liga.medical.medicalmonitoring.core.controller.rest;

import liga.medical.medicalmonitoring.core.exception_handling.patients.patient_exception.NoSuchPatientException;
import liga.medical.medicalmonitoring.core.model.entity.Patient;
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
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientServiceImpl patientService;

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public Patient findPatient(@PathVariable("id") Long id) {
        if (patientService.findById(id) == null) {
            throw new NoSuchPatientException("There is no patient with ID = " + id + " in database");
        } else {
            return patientService.findById(id);
        }
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        patientService.save(patient);
        return patient;
    }

    @PatchMapping("/{id}")
    public Patient updatePatient(@PathVariable("id") Long id, @RequestBody Patient patient) {
        patientService.update(id, patient);
        return patientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        Patient patient = patientService.findById(id);
        if (patient == null) {
            throw new RuntimeException("no patient with id = " + id);
        }
        patientService.deleteById(id);
        return "Patient with id = " + id + "was deleted";
    }
}

package liga.medical.medicalmonitoring.core.service.impl;

import liga.medical.medicalmonitoring.core.mapper.PatientMapper;
import liga.medical.medicalmonitoring.core.model.entity.Patient;
import liga.medical.medicalmonitoring.core.repository.PatientRepository;
import liga.medical.medicalmonitoring.core.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper mapper;

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void save(Patient patient) {
        log.info("Saving new{}", patient);
        patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public void update(Long id, Patient updatePatient) {
        Patient patientToBeUpdated = findById(id);
        patientToBeUpdated.setName(updatePatient.getName());
        patientToBeUpdated.setGender(updatePatient.getGender());
        patientToBeUpdated.setAge(updatePatient.getAge());
        patientToBeUpdated.setAddress(updatePatient.getAddress());
        patientToBeUpdated.setPassportSeries(updatePatient.getPassportSeries());
        patientToBeUpdated.setPassportNumber(updatePatient.getPassportNumber());
        patientRepository.save(patientToBeUpdated);
        //и т.д.
    }
}

package liga.medical.medicalmonitoring.core.service.impl;

import liga.medical.medicalmonitoring.core.model.entity.MedicalHistory;
import liga.medical.medicalmonitoring.core.repository.MedicalHistoryRepository;
import liga.medical.medicalmonitoring.core.service.MedicalHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public MedicalHistory findById(Long id) {
        return medicalHistoryRepository.findById(id).orElse(null);
    }

    public List<MedicalHistory> findAll() {
        return medicalHistoryRepository.findAll();
    }

    public void save(MedicalHistory medicalHistory) {
        log.info("Saving new{}", medicalHistory);
        medicalHistoryRepository.save(medicalHistory);
    }

    public void deleteById(Long id) {
        medicalHistoryRepository.deleteById(id);
    }

    public void update(Long id, MedicalHistory updMedicalHistory) {
        MedicalHistory medicalHistory = findById(id);
        medicalHistory.setDoctor(updMedicalHistory.getDoctor());
        medicalHistory.setDiagnosis(updMedicalHistory.getDiagnosis());
        medicalHistory.setModifyDttm(updMedicalHistory.getModifyDttm());
        medicalHistoryRepository.save(medicalHistory);
        //и.т.д.
    }
}
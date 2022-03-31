package liga.medical.medicalmonitoring.core.service.impl;

import liga.medical.medicalmonitoring.core.model.entity.LogBadMedicalStatus;
import liga.medical.medicalmonitoring.core.repository.LogBadStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class LogBadStatusService {

    private final LogBadStatusRepository logBadStatusRepository;

    public LogBadStatusService(LogBadStatusRepository logBadStatusRepository) {
        this.logBadStatusRepository = logBadStatusRepository;
    }

    public void saveLog(LogBadMedicalStatus logBadMedicalStatus) {
        logBadStatusRepository.save(logBadMedicalStatus);
    }
}

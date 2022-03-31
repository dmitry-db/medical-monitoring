package liga.medical.medicalmonitoring.core.repository;

import liga.medical.medicalmonitoring.core.model.entity.LogBadMedicalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogBadStatusRepository extends JpaRepository<LogBadMedicalStatus, Long> {
}

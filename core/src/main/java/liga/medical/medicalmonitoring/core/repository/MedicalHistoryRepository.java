package liga.medical.medicalmonitoring.core.repository;

import liga.medical.medicalmonitoring.core.model.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}

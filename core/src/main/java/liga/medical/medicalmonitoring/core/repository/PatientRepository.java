package liga.medical.medicalmonitoring.core.repository;

import liga.medical.medicalmonitoring.core.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

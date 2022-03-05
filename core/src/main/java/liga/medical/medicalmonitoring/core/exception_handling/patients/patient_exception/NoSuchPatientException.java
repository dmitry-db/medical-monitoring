package liga.medical.medicalmonitoring.core.exception_handling.patients.patient_exception;

public class NoSuchPatientException extends RuntimeException {

    public NoSuchPatientException(String message) {
        super(message);
    }
}

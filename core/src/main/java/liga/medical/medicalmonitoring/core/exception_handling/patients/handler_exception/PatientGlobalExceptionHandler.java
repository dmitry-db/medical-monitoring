package liga.medical.medicalmonitoring.core.exception_handling.patients.handler_exception;

import liga.medical.medicalmonitoring.core.exception_handling.abstract_exception.IncorrectData;
import liga.medical.medicalmonitoring.core.exception_handling.patients.patient_exception.NoSuchPatientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handlerExceptionPatient(NoSuchPatientException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}

package liga.medical.medicalmonitoring.core.exception_handling.global_exception_handling;

import liga.medical.medicalmonitoring.core.exception_handling.abstract_exception.IncorrectData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handlerExceptionPatient(Exception exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

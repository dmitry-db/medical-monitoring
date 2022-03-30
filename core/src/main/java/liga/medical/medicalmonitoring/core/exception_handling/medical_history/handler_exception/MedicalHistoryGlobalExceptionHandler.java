package liga.medical.medicalmonitoring.core.exception_handling.medical_history.handler_exception;

//import liga.medical.medicalmonitoring.core.exception_handling.abstract_exception.IncorrectData;
//import liga.medical.medicalmonitoring.core.exception_handling.medical_history.medical_history_exception.NoSuchMedicalHistoryException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class MedicalHistoryGlobalExceptionHandler {
//
//    @ExceptionHandler
//    public ResponseEntity<IncorrectData> handlerExceptionMedicalHistory(NoSuchMedicalHistoryException exception) {
//        IncorrectData data = new IncorrectData();
//        data.setInfo(exception.getMessage());
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//}

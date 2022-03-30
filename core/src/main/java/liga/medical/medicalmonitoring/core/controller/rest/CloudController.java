package liga.medical.medicalmonitoring.core.controller.rest;

import liga.medical.medicalmonitoring.core.repository.PersonServiceFeignClient;
import liga.medical.personservice.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cloud-person/api")
public class CloudController {

    @Autowired
    PersonServiceFeignClient personServiceFeignClient;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(personServiceFeignClient.getPersonById(id));
    }
}

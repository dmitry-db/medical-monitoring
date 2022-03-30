package liga.medical.medicalmonitoring.core.repository;

import liga.medical.personservice.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name="person-service", url = "http://localhost:8081/patient")
public interface PersonServiceFeignClient {

    @GetMapping(path = "/{id}")
    PersonDto getPersonById(@PathVariable(value = "id") Long id);
}

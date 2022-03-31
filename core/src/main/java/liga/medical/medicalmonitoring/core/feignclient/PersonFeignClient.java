package liga.medical.medicalmonitoring.core.feignclient;

import liga.medical.personservice.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(name="person-service", url = "http://localhost:8081/patient")
public interface PersonFeignClient {

    @GetMapping(path = "/{id}")
    PersonDto getPersonById(@PathVariable(value = "id") Long id);
}

package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.core.feignclient.PersonFeignClient;
import liga.medical.personservice.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public class FeignClientService {

    private final PersonFeignClient personFeignClient;

    public FeignClientService(PersonFeignClient personFeignClient) {
        this.personFeignClient = personFeignClient;
    }

    public PersonDto getPersonById(Long id) {
        return personFeignClient.getPersonById(id);
    }
}

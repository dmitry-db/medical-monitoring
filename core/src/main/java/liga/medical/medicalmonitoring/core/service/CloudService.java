package liga.medical.medicalmonitoring.core.service;

import liga.medical.personservice.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CloudService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public ResponseEntity<PersonDto> findPerson(Long id, String serviceName) {
        return restTemplate.getForEntity(getUrl(id, serviceName), PersonDto.class);
    }

    public String getUrl(Long id, String serviceName) {
        return "http://" + serviceName + "/person/" + id;
    }
}

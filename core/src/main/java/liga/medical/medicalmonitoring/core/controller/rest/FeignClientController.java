package liga.medical.medicalmonitoring.core.controller.rest;

import liga.medical.medicalmonitoring.core.service.FeignClientService;
import liga.medical.personservice.dto.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class FeignClientController {

    private final FeignClientService feignClientService;

    public FeignClientController(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }

    @GetMapping("/{id}")
    public PersonDto getFindId(@PathVariable Long id) {
        return feignClientService.getPersonById(id);
    }
}

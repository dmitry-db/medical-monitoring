package liga.medical.medicalmonitoring.core.rabbitListener;

import liga.medical.medicalmonitoring.core.model.entity.LogBadMedicalStatus;
import liga.medical.medicalmonitoring.core.service.impl.LogBadStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMqListener {
    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    private final LogBadStatusService logBadStatusService;

    public RabbitMqListener(LogBadStatusService logBadStatusService) {
        this.logBadStatusService = logBadStatusService;
    }

    @RabbitListener(queues = "patient-alert")  //как вариант, по хорошему лучше распарсить string и записывать определенные поля в базу а не все сообщение
    public void processMedical(String message) {
        logBadStatusService.saveLog(new LogBadMedicalStatus(message));
        logger.warn("Ill parient: {}", message);
    }
}

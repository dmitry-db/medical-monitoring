package liga.medical.medicalmonitoring.core.rabbitListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMqListener {
    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "patient-alert")
    public void processMedical(String message) {
        logger.warn("Ill parient: {}", message);
    }
}

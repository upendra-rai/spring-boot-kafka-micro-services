package upendra.rai.kafka.email.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import upendra.rai.kafka.main.service.dtos.OrderEvent;

@Service
@Slf4j
public class EmailConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}"
                   ,groupId ="${spring.kafka.consumer.group-id}" )
    public void consume(OrderEvent event){
        log.info(">> consume({})",event.toString());

        System.out.println("+++++++++  Sending Email ++++++++ "+event);

    }

}

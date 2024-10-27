package upendra.rai.kafka.order.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import upendra.rai.kafka.main.service.dtos.OrderEvent;

@Service
@Slf4j
public class OrderProducer {

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String , OrderEvent> kafkaTemplate;


    public void sendMessages(OrderEvent event){
     log.info(">> send Message({})",event.toString());
       System.out.println(">> send Message=====>"+event);
        Message<OrderEvent>message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        kafkaTemplate.send(message);
    }
}

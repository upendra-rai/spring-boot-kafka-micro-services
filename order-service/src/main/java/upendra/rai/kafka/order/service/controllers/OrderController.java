package upendra.rai.kafka.order.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upendra.rai.kafka.main.service.dtos.Order;
import upendra.rai.kafka.main.service.dtos.OrderEvent;
import upendra.rai.kafka.order.service.kafka.OrderProducer;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/order")
    public  String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event= new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("order status is pending state.");
        event.setOrder(order);
        orderProducer.sendMessages(event);
        return "Order Placed Successfully.";
    }

}

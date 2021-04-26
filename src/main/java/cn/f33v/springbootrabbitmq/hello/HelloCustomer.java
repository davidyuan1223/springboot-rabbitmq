package cn.f33v.springbootrabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloCustomer {
    @RabbitHandler
    public void receive1(String message){
        System.out.println("message: "+message);
    }
}

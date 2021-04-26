package cn.f33v.springbootrabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
    //fanout广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout的模型发送的消息");
    }
    //work
    @Test
    public void testWork(){
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("work","work模型"+i);
        }
    }
    //topic动态路由,订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","product.save.add","produce.save.add 路由消息");
    }
    //route 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","error","发送info的key的路由消息");
    }
    @Test
    void contextLoads() {
    }

}

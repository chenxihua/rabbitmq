package rabbit.listener.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 生产者消费者模式的配置,包括一个队列和两个对应的消费者,
 *      特点: 只发一次, 并且指定一个消费者接收,(不会有第二个消费者接收, 就看那个消费者最先被接纳)
 *      只需一个消费者接收数据即可.
 */
@Component
public class QueueListener {

    /**
     * 感觉, 可要可不要 channel, 因为没有什么实际的用处.
     * @param
     * @param
     * @param message
     * @throws Exception
     */
    @RabbitListener(queues = "myQueue")
    public void displayMail(String message) throws Exception {
        System.out.println("message: "+message);
        System.out.println("====================================");
    }
}

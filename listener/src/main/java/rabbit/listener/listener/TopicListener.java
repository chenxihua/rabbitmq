package rabbit.listener.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * topic交换机模型，需要一个topic交换机，两个队列和三个binding
 */
@Component
public class TopicListener {

	@RabbitListener(queues = "topicQueue1")
	public void displayTopic1(String jsonMsg) {
		System.out.println("从topicQueue 1 取出消息: " + jsonMsg);
	}


    @RabbitListener(queues = "topicQueue2")
    public void displayTopic2(String jsonMsg) {
        System.out.println("从topicQueue 2 取出消息: " + jsonMsg);
    }


    /***
     * topic 模式: 是模糊匹配的模式, 和 direct模式有点类似.
     */


}

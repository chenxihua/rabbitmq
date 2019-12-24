package rabbit.listener.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 发布订阅模式的配置,包括两个队列和对应的订阅者,
 * 发布者的交换机类型使用fanout(子网广播),两根网线binding用来绑定队列到交换机
 */
@Component
public class SubscribeListener {

	@RabbitListener(queues = "publishQueue1")
	public void subscribe1(String jsonMsg) {
		System.out.println("订阅者 1 收到消息" + jsonMsg);
	}



    @RabbitListener(queues = "publishQueue2")
    public void subscribe2(String jsonMsg) {
        System.out.println("订阅者 2 收到消息" + jsonMsg);
    }

    /**
     * 订阅者2收到消息Mail [mailId=8888, country=88, weight=11.88]
     * 订阅者1收到消息Mail [mailId=8888, country=88, weight=11.88]
     *
     * 订阅者1收到消息Mail [mailId=8888, country=88, weight=11.88]
     * 订阅者2收到消息Mail [mailId=8888, country=88, weight=11.88]
     *
     * 由这个输出内容, 可以看出, publist-Subscribe 模式, 是所有消费者都能接收
     * 		并且, 接收的顺序是不限制谁先接收, 意为: 谁都有可能先接收到消息.
     *
     */


    /**
     * 如果是要将数据从队列中移除，则要配置 Channel 和 Message
     *   但是大多数情况，我们是不需要移除 队列 里面中的数据的
     */
//    @RabbitListener(queues = "publishQueue2")
//    public void subscribe2(Channel channel, Message message, String jsonMsg) throws IOException {
//        System.out.println("订阅者 2 收到消息" + jsonMsg);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    }

}

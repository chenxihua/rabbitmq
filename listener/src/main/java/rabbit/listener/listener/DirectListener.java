package rabbit.listener.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * direct直连模式的交换机配置,包括一个direct交换机，两个队列，三根网线binding
 */
@Component
public class DirectListener {

	@RabbitListener(queues = "directQueue1")
	public void displayMail1(String msg) {
		System.out.println("directQueue 1 队列监听器1号收到消息" + msg);
	}

    @RabbitListener(queues = "directQueue2")
    public void displayMail2(String msg) {
        System.out.println("directQueue 2 队列监听器2号收到消息" + msg);
    }


	/**
	 * directqueue1队列监听器1号收到消息Mail [mailId=生活, country=无奈, weight=22.22]
	 * directqueue2队列监听器2号收到消息Mail [mailId=生活, country=无奈, weight=22.22]
	 * directqueue2队列监听器2号收到消息Mail [mailId=生活, country=无奈, weight=22.22]
	 *
	 * 总结: 这个直连模式, 还是比较容易区分的, 你使用什么路由键, 就去到相应的路由键队列.
	 *
	 *
	 */

}

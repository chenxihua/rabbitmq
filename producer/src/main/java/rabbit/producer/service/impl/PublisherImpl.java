package rabbit.producer.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbit.producer.service.Publisher;

@Service("publisher")
public class PublisherImpl implements Publisher {

	@Autowired
    RabbitTemplate rabbitTemplate;

	@Override
	public void sendMessage(String queue, String msg) {
		rabbitTemplate.convertAndSend(queue, msg);
	}

	@Override
	public void sendFanoutMsg(String msg) {
		rabbitTemplate.convertAndSend("fanout", "", msg);
	}

	@Override
	public void sendDirectMsg(String msg, String routingkey) {
		rabbitTemplate.convertAndSend("direct", routingkey, msg);
	}

	@Override
	public void sendTopicMsg(String msg, String routingkey) {
		rabbitTemplate.convertAndSend("myTopic", routingkey, msg);
	}
}

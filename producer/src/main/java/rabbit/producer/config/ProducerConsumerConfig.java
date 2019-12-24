package rabbit.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  生产者消费者模式的配置,包括一个队列和两个对应的消费者
 *      生产者-消费者模式, 只需要定义一个队列, 即可. 不需要定义交换机(exchange)
 */
@Configuration
public class ProducerConsumerConfig {

    @Bean
    public Queue myQueue() {
        Queue queue = new Queue("myQueue");
        return queue;
    }

}

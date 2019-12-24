package rabbit.producer.confirm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName: RabbitTemplateConfig
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/24 10:33
 **/
@Component
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(RabbitTemplateConfig.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate(){
        // 设置生产者消息确认 , 其中，this代表着 RabbitTemplateConfig 这个对象
        logger.warn("初始化类： {}", this.getClass().getName());
        // 初始化类： rabbit.producer.confirm.RabbitTemplateConfig
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，
     *      也就是只确认是否正确到达 Exchange 中
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.warn("ack： {}, 消息到达rabbitmq服务器", ack);
        } else {
            logger.warn("ack： {}, 消息可能未到达rabbitmq服务器, 原因： {}", ack, cause);
        }
    }


    /**
     * 发送消息失败返回，比如 路由不到队列时触发回调
     *      一般这个回调函数，会继续触发第二次发送数据，直到成功为止
     *      这个可以使用 impl包下的 PublishImpl 里测试，
     *      修改：rabbitTemplate.convertAndSend("fanout", "", msg); 中"fanout" 为 "faning" 试试。
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.warn("message: {}", message);
        logger.warn("replyCode: {}", replyCode);
        logger.warn("replyText: {}", replyText);
        logger.warn("exchange: {}", exchange);
        logger.warn("routingKey: {}", routingKey);
    }
}

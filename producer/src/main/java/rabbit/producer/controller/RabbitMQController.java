package rabbit.producer.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rabbit.producer.bean.User;
import rabbit.producer.service.impl.PublisherImpl;


/**
 * 提示一下： 如果直接在rabbitmq的控制台传入数据，是直接上传 ASCII 码的，
 *      意思就是，监听这个队列，得到的数据，是 ASCII 码，而不是 UTF-8 编码的数据
 */
@RestController
public class RabbitMQController {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQController.class);


    @Autowired
    PublisherImpl publisher;

    @PostMapping(value = "/produce")
    public void produce(@RequestBody User user) {
        String jsonString = JSONObject.toJSONString(user);

        logger.warn("发送数据： {}", jsonString);
        publisher.sendMessage("myQueue", jsonString);

    }


    @PostMapping(value = "/subscribe", produces = {"application/json;charset=UTF-8"})
    public void subscribe(@RequestBody User user) {
        String toJSONString = JSONObject.toJSONString(user);
        logger.warn("发布订阅的： {}", toJSONString);
        publisher.sendFanoutMsg(toJSONString);
    }


    @PostMapping(value = "/direct", produces = {"application/json;charset=UTF-8"})
    public void direct(@RequestBody User user) {
        String toJSONString = JSONObject.toJSONString(user);
        logger.warn("直连模式： toJSONString： {},  key: {}", toJSONString, user.getKey());
        // 其中， 要输入路由键
        publisher.sendDirectMsg(toJSONString, user.getKey());
    }


    @PostMapping(value = "/myTopic", produces = {"application/json;charset=UTF-8"})
    public void topic(@RequestBody User user) {
        String toJSONString = JSONObject.toJSONString(user);
        logger.warn("主题模式： toJSONString： {},  key: {}", toJSONString, user.getKey());
        // 其中， 要输入路由键
        publisher.sendTopicMsg(toJSONString, user.getKey());
    }




}

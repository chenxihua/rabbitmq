package rabbit.producer.service;


public interface Publisher {

    /**
     * 向队列queue发送消息
     * @param queue
     * @param msg
     */
    void sendMessage(String queue, String msg);

    /**
     * 使用fanout交换机发布消息给所有队列
     * @param msg
     */
	void sendFanoutMsg(String msg);

    /**
     * 使用direct交换机发送消息
     * @param msg
     * @param routingkey
     */
	void sendDirectMsg(String msg, String routingkey);

    /**
     * 使用topic交换机发送消息
     * @param msg
     * @param routingkey
     */
	void sendTopicMsg(String msg, String routingkey);

}

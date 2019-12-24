package rabbit.producer;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import rabbit.producer.bean.User;

/**
 * @ClassName: OtherTest
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/20 17:52
 **/
public class OtherTest {



    @Test
    public void testData(){
        User user = new User();
        user.setId(11);
        user.setUser("陈喜华");
        user.setPassword("123456");

        String jsonString = JSONObject.toJSONString(user);
        System.out.println("1: "+jsonString);
    }


}

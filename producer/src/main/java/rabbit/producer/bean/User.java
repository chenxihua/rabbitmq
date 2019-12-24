package rabbit.producer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/12/20 17:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private Integer id;
    private String user;
    private String password;

    /**
     * 用作有路由时，使用的路由键
     */
    private String key;


}

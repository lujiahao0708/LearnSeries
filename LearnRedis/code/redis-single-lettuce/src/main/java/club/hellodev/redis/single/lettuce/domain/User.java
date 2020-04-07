package club.hellodev.redis.single.lettuce.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体类
 * @author lujiahao
 * @date 2020-04-07
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8899913992586794706L;
    
    private String name;
    private Integer age;
}

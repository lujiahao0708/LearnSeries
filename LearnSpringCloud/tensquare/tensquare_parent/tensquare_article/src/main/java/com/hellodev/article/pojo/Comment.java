package com.hellodev.article.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论(mongoDB)
 * @author lujiahao
 * @date 2019-09-06 15:33
 */
@Data
public class Comment implements Serializable {
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
}

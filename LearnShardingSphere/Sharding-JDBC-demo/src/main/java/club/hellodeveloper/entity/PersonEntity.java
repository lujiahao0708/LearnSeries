package club.hellodeveloper.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_person")
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = -706463047854212314L;
    private Long id;
    private String name;
}

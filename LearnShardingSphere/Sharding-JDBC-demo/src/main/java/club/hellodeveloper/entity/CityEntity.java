package club.hellodeveloper.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_city")
public class CityEntity implements Serializable {
    private static final long serialVersionUID = 7213286868188452783L;
    private Long id;
    private String name;
    private Long code;
}

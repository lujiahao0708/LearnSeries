package club.hellodeveloper.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_order")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 5330293869127993660L;

    private Long id;
    private String orderNo;
    private Long userId;
    private Long driverId;
}

package club.hellodeveloper;

import club.hellodeveloper.entity.OrderEntity;
import club.hellodeveloper.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class HorizontalSplitApplicationTests {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testHorizontalSplit() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			OrderEntity order = new OrderEntity();
			order.setOrderNo("P" + i);
			order.setUserId(Math.abs(random.nextLong()));
			order.setDriverId(Math.abs(random.nextLong()));
			orderMapper.insert(order);
		}

		List<OrderEntity> orderList = orderMapper.selectList(null);
		System.out.println(orderList);
	}

}

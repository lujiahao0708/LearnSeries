package club.hellodeveloper;

import club.hellodeveloper.entity.CityEntity;
import club.hellodeveloper.entity.OrderEntity;
import club.hellodeveloper.entity.PersonEntity;
import club.hellodeveloper.mapper.CityMapper;
import club.hellodeveloper.mapper.OrderMapper;
import club.hellodeveloper.mapper.PersonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class ShardingJDBCApplicationTests {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private PersonMapper personMapper;

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

	@Test
	public void testPublicTable() {
//		CityEntity cityEntity = new CityEntity();
//		cityEntity.setName("石家庄");
//		cityEntity.setCode(050700L);
//		cityMapper.insert(cityEntity);

		QueryWrapper<CityEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "石家庄");
		List<CityEntity> entityList = cityMapper.selectList(queryWrapper);
		System.out.println(entityList);
	}

	@Test
	public void testReadWriteSplit() {
//		PersonEntity personEntity = new PersonEntity();
//		personEntity.setName("张三");
//		personMapper.insert(personEntity);

		QueryWrapper<PersonEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "张三");
		PersonEntity queryPerson = personMapper.selectOne(queryWrapper);
		System.out.println(queryPerson);
	}

}

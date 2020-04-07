package club.hellodev.redis.single.jedis;

import club.hellodev.redis.single.jedis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSingleJedisApplicationTest {

	@Autowired
	private RedisTemplate<String, String> strRedisTemplate;
	@Autowired
	private RedisTemplate<String, Serializable> serializableRedisTemplate;

	@Test
	public void testGetString() {
		strRedisTemplate.opsForValue().set("url", "hellodev.club");
		String urlStr = strRedisTemplate.opsForValue().get("url");
		System.out.println(urlStr);
	}

	@Test
	public void testGetSerializable() {
		User user=new User();
		user.setName("hellodev.club");
		user.setAge(10);
		serializableRedisTemplate.opsForValue().set("user", user);
		User userFromRedis = (User) serializableRedisTemplate.opsForValue().get("user");
		System.out.println(userFromRedis.toString());
	}
}

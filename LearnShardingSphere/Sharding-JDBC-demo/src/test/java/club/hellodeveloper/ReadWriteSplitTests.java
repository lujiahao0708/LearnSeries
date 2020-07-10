package club.hellodeveloper;

import club.hellodeveloper.entity.PersonEntity;
import club.hellodeveloper.mapper.PersonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ReadWriteSplitTests {

	@Autowired
	private PersonMapper personMapper;


	@Test
	public void addPerson() {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName("张三");
		personMapper.insert(personEntity);
	}

	@Test
	public void getPerson() {
		QueryWrapper<PersonEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("name", "张三");
		List<PersonEntity> personList = personMapper.selectList(queryWrapper);
		System.out.println(personList);
	}

}

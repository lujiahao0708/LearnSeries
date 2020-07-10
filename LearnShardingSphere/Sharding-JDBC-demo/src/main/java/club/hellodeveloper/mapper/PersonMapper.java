package club.hellodeveloper.mapper;

import club.hellodeveloper.entity.PersonEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper extends BaseMapper<PersonEntity> {
}

package com.hellodev.spit.dao;

import com.hellodev.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽数据访问层
 * @author lujiahao
 * @date 2019-09-06 15:16
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 根据上级ID查询吐槽列表(分页)
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}

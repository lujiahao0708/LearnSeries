package com.lujiahao.es_company.repository;

import com.lujiahao.es_company.domain.EmployeeDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lujiahao
 * @date 2018-11-26 15:34
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<EmployeeDocument, Long> {
}

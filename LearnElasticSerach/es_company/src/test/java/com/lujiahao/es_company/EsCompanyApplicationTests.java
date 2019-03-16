package com.lujiahao.es_company;

import com.lujiahao.es_company.domain.Article;
import com.lujiahao.es_company.domain.EmployeeDocument;
import com.lujiahao.es_company.repository.ArticleEsRepository;
import com.lujiahao.es_company.repository.EmployeeRepository;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsCompanyApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void save() {
		EmployeeDocument employeeDocument = new EmployeeDocument();
		employeeDocument.setId(4L);
		employeeDocument.setName("啊3凯");
		employeeDocument.setAge(10);
		EmployeeDocument save = employeeRepository.save(employeeDocument);
		System.out.println(save);
	}

	@Test
	public void search() {
		NativeSearchQueryBuilder msqb = new NativeSearchQueryBuilder();
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		SearchQuery query = msqb.withQuery(boolQuery).build();
		Page<EmployeeDocument> employeeDocumentPage = employeeRepository.search(query);

		Optional<EmployeeDocument> byId = employeeRepository.findById(2L);
		if (byId.isPresent()) {
			EmployeeDocument employeeDocument = byId.get();
			System.out.println(employeeDocument.toString());
		}

	}



	@Autowired
	private ArticleEsRepository articleEsRepository;

	@Test
	public void testSave() {
		Article article = new Article();
		article.setAuthor("Alice");
		article.setContent("spring boot data es");
		article.setId(1l);
		article.setPv(100);
		article.setSummary("spring boot es");
		articleEsRepository.save(article);
	}
}

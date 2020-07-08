package club.hellodeveloper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("club.hellodeveloper.mapper")
public class HorizontalSplitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorizontalSplitApplication.class, args);
	}

}

package AISS.GitHubMiner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
@SpringBootApplication
public class GitHubMinerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitHubMinerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){return builder.build();}
}

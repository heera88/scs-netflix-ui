package com.rdmstudios.webui.scsnetflixui;

import com.rdmstudios.webui.scsnetflixui.domain.Fortune;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
//import org.springframework.hateoas.Resources;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ScsNetflixUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsNetflixUiApplication.class, args);
	}

	@FeignClient("scs-netflix")
	public interface FortuneClient {
		@GetMapping(value = "/fortunes", consumes = "application/hal+json")
		List<Fortune> getFortunes();
	}

	@Configuration
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.authorizeRequests().anyRequest().permitAll();
		}

	}
}

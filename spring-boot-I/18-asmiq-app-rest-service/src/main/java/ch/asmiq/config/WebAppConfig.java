package ch.asmiq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("ch.asmiq")
public class WebAppConfig {

	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
	
}

package fi.adhocapp.adhocappspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors().configurationSource(corsConfiguration());
	}

	private CorsConfigurationSource corsConfiguration() {

		return request -> {
			CorsConfiguration corsConfig = new CorsConfiguration();

			corsConfig.setAllowedOriginPatterns(Arrays.asList("*"));
			corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
			corsConfig.setAllowedHeaders(Collections.singletonList("*"));
			corsConfig.setAllowCredentials(true);
			corsConfig.setMaxAge(3600L);

			return corsConfig;
		};
	}

}
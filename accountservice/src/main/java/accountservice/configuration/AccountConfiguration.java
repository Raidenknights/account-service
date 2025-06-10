package accountservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import accountservice.constants.Constants;

@Configuration
@EnableWebSecurity
public class AccountConfiguration {

	@Bean
	SecurityFilterChain defaultSecurityFilterChains(HttpSecurity httpSecuirty) throws Exception {

		return httpSecuirty.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(Constants.CREATE_ACCOUNT_URL).permitAll())
				.authorizeHttpRequests(auth -> auth.requestMatchers(Constants.MODIFY_ACCOUNT_URL).authenticated()).build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

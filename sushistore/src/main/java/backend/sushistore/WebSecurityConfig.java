package backend.sushistore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import backend.sushistore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled=true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests( authorize -> authorize
			.anyRequest().authenticated()
			)
		.headers(headers -> headers
			.frameOptions(frameoptions -> frameoptions
					.disable()
					)
			)
		.formLogin(formlogin -> formlogin
				.loginPage("/login")
				.defaultSuccessUrl("/sushilist", true)
				.permitAll()
			)
		.logout(logout -> logout
				.permitAll()
		);
		return http.build();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new
		BCryptPasswordEncoder());
	}

}

package in.sita.sangitaTech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.sita.sangitaTech.service.CustomerService;
import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Autowired
	private CustomerService customerService;
    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider autProvider=
    			new DaoAuthenticationProvider();
    	autProvider.setPasswordEncoder(pwdEncoder());
    	autProvider.setUserDetailsService(customerService);
    	return autProvider;
    }
    
    @Bean
    @SneakyThrows
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
    	return config.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf->csrf.disable()); // Disable CSRF if not required, otherwise configure it appropriately
        return http.build();
    }
}

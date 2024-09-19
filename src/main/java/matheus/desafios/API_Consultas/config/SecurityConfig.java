package matheus.desafios.API_Consultas.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	   @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
	        https
	            .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())  
	            .httpBasic() 
	            .and()
	            .csrf().disable();
	        return https.build();
	    }
	

@Bean
public UserDetailsService userDetailService() {
	 UserDetails user = User.withDefaultPasswordEncoder()
             .username("admin")
             .password("y9X!vN2z&L4k@W8d")
             .roles("USER")
             .build(); 

return new InMemoryUserDetailsManager(user);
}
}

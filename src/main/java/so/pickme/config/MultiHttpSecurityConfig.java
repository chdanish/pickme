package so.pickme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, jsr250Enabled=true)
public class MultiHttpSecurityConfig {

		
	
	
	    @Autowired
	    private CustomAuthenticationProvider customAuthenticationProvider;
	    
	   
	  
	    
	    @Autowired
	    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	System.out.println("bb");

	        auth.authenticationProvider(customAuthenticationProvider);
	    }
	

	


	@Configuration                                                  
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		
		public void configure(WebSecurity web)
	               throws Exception {
			web
			.ignoring()
				.antMatchers("/resources/**");

			
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			System.out.println("3");
			
			/*http
					.authorizeRequests()
		            .antMatchers( "/login", "/resources/**", "/access/**","/signup").permitAll()
		            .anyRequest().authenticated()
		            .and()
					.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
	                  .permitAll()
	                  .and()
	                  .exceptionHandling().accessDeniedPage("/403")
	                  .and()
	                  .csrf();
			

        	            http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));*/

			
		 		http.authorizeRequests().antMatchers("/users").hasRole("ADMIN")
		 				.antMatchers( "/login","/signup").permitAll()
		 				.antMatchers( "/**").hasRole("USER")
		 				.anyRequest().authenticated()
		 				.and().formLogin()
		 				.usernameParameter("username") // default is username
		 				.passwordParameter("password") // default is password
		 				.loginPage("/login") // default is /login with an HTTP get
		 				.failureUrl("/403") // default is /login?error
		 				; 
			
            	http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		}
	}
	
}
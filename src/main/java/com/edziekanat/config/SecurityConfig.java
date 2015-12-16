package com.edziekanat.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from users where username = ?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student/**").access("hasRole('student')").antMatchers("/lecturer/**")
				.access("hasRole('lecturer')").antMatchers("/admin/**").access("hasRole('administrator')").and()
				.formLogin().successHandler(new EDziekanatAuthenticationSuccessHandler()).loginPage("/login")
				.failureUrl("/?error").usernameParameter("username").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/?logout").and().exceptionHandling().accessDeniedPage("/403").and().csrf();
	}
}
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//이런식으로 인증할 것들을 풀어주는 겁니다. 주로 리소스  
		web.ignoring().antMatchers("/css/**", "/script/**", "/");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		//여기에선 리소르외에 페이지의 인증/비인증/인증권한등을 성정하는게 좋은 것 같습니다. 
			.antMatchers("/mypage").authenticated()
			.antMatchers("/**").permitAll();			//순서를 바꿨음. 
	}
}

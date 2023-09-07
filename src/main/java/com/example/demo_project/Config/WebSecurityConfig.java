package com.example.demo_project.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo_project.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
//-----------------------18-21�b�}
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
//-----------------------
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
	// -------------------------
	// �����d�I => �����S�w���}�A����i��b���K�X�n��
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello.html").permitAll();
//	}

	// -------------------

	// ����k�P�W�� 2 �� 1 <�U�� = ( �����d�I )>

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}

	// -------------------39-47�b�}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()// �w�q����url�ݭn�O�@
				.antMatchers("/resources/**").permitAll()// resource��Ƨ��R�A��ƥi�ΦW�s��
				.antMatchers("/hello").hasRole("users")// �w�q�ǰt��"/hello"(���|)���U���ݭn��user(�ۭq�q����)���o�Ө���~��i�h
				.anyRequest().authenticated()// �|���ǰt�쪺url���ݭn��������<����ШD���ݭn�{��>
				.and().formLogin()// ����login������ (�i�ۤv�g�A�άO���[ ps.�o�O���ش��Ѫ�����)
				.and().httpBasic()// �t�m��http�򥻻{��
		;
	}

// in memory
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// �����N�K�X�s�i�O����(�q�`���|�o��)
//
////		auth.inMemoryAuthentication().withUser("Alice").roles("admin").password("123");
//
//		auth.inMemoryAuthentication().withUser("Alice")//
//				.roles("admin")//
//				.password(passwordEncoder().encode("123"))//
//				.and()//
//				.withUser("Bob")//
//				.roles("user")//
//				.password(passwordEncoder().encode("123"));//
//
//	}
//================67-77�b�}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}

}

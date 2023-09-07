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
//-----------------------18-21槓開
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
//-----------------------
//	@Autowired
//	private UserDetailsServiceImpl userDetailsServiceImpl;
	// -------------------------
	// 忽略攔截 => 忽略特定網址，不能進行帳號密碼登錄
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello.html").permitAll();
//	}

	// -------------------

	// 此方法與上面 2 選 1 <下方 = ( 忽略攔截 )>

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}

	// -------------------39-47槓開
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()// 定義哪個url需要保護
				.antMatchers("/resources/**").permitAll()// resource資料夾靜態資料可匿名存取
				.antMatchers("/hello").hasRole("users")// 定義匹配到"/hello"(路徑)底下有需要的user(自訂義角色)的這個角色才能進去
				.anyRequest().authenticated()// 尚未匹配到的url都需要身分驗證<任何請求都需要認證>
				.and().formLogin()// 跳轉login的頁面 (可自己寫，或是不加 ps.這是內建提供的頁面)
				.and().httpBasic()// 配置為http基本認證
		;
	}

// in memory
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 直接將密碼存進記憶體(通常不會這樣)
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
//================67-77槓開
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}

}

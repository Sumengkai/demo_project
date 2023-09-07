//package com.example.demo_project.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration // 讓Spring載入該類別設定
//@EnableSwagger2 // 啟用Swagger2函數建立docket的bean
//public class SwaggerConfig {
//	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder().title("RESTful APIs").build();
//
//	// ---
//	@Bean
//	public Docket api() {
//
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)// 顯示api基本資訊,可不加
//				.select()// 回傳一個apiselectorbuilder實例,用來控制那些介面可以給swagger展現
//				// 設定套件掃描
//				// Swagger 會掃描套件下所有controller定義的api並產生文件
//				// 若不想api回傳相關文件,可在api加上@ApiIgnore
//				.apis(RequestHandlerSelectors.basePackage("com.example.demo_project.controller")).paths(PathSelectors.any())
//				.build();
//
//	}
//	// ---
//}

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
//@Configuration // ��Spring���J�����O�]�w
//@EnableSwagger2 // �ҥ�Swagger2��ƫإ�docket��bean
//public class SwaggerConfig {
//	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder().title("RESTful APIs").build();
//
//	// ---
//	@Bean
//	public Docket api() {
//
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)// ���api�򥻸�T,�i���[
//				.select()// �^�Ǥ@��apiselectorbuilder���,�Ψӱ���Ǥ����i�H��swagger�i�{
//				// �]�w�M�󱽴y
//				// Swagger �|���y�M��U�Ҧ�controller�w�q��api�ò��ͤ��
//				// �Y���Qapi�^�Ǭ������,�i�bapi�[�W@ApiIgnore
//				.apis(RequestHandlerSelectors.basePackage("com.example.demo_project.controller")).paths(PathSelectors.any())
//				.build();
//
//	}
//	// ---
//}

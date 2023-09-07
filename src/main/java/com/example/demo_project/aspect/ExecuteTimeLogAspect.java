package com.example.demo_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecuteTimeLogAspect {
	// 切入點，定義controller or service下列所有程式會被包含
	// < * > -> 返回任意類型 + pacakge 路徑
	// 第一個< .* > -> 任何型態 ， 第二個< .* > -> 任何方法ps.若要指定->第二個.+方法名稱
	// < (..) > -> 方法裡面的參數，代表任意參數

//	@Pointcut("execution (* com.example.demo_project.controller.*.*(..))")
	@Pointcut("execution (* com.example.demo_project.service.impl.*.findAll(..))")
	public void pointcut3() {

	}

	@Pointcut("execution (public * com.example.demo_project.service.impl.*.findAll(..))")
	public void pointcut2() {

	}

	@Pointcut("execution (public * com.example.demo_project.service.impl.*.*(..))")
	public void pointcut() {

	}

	// ---

	@Before("pointcut()")
	public void before() {
		System.out.println("before advice ----------");
	}

	// ---

	@After("pointcut()")
	public void after() {
		System.out.println("after advice ----------");
	}

	// ---

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around advice start ---------");
		MethodSignature signaTure = (MethodSignature) pjp.getSignature();
		long startTime = System.currentTimeMillis();
		System.out.println("執行方法名稱 : " + pjp.getSignature().getName());
		System.out.println("執行方法名稱簽章 : " + signaTure.getName());
		System.out.println(startTime + " 跑之前ㄉ時間(毫秒)");
		// 呼叫proceed()，才會執行原本的方法
		Object result = pjp.proceed();
		long spentTime = System.currentTimeMillis() - startTime;
		System.out.println(spentTime + " 花費時間(毫秒)");
		System.out.println("around advice end ---------");
		return result;

	}

	// ---

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("AfterReturning advice -----------ㄏ");
	}

	// ---
	// 有報錯才會啟動道的方法
	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		// 轉型 用於取得方法名稱
		MethodSignature signaTure = (MethodSignature) joinPoint.getSignature();
		System.out.println("執行ㄉ方法名稱joinPoint : " + joinPoint.getSignature().getName());
		System.out.println("執行ㄉ方法名稱簽章 : " + signaTure.getName());
		// 拋錯訊息
		System.out.println("錯誤訊息 : " + throwable.getMessage());
		System.out.println("AfterThrowing advice -----------");
	}
}

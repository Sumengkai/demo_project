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
	// ���J�I�A�w�qcontroller or service�U�C�Ҧ��{���|�Q�]�t
	// < * > -> ��^���N���� + pacakge ���|
	// �Ĥ@��< .* > -> ���󫬺A �A �ĤG��< .* > -> �����kps.�Y�n���w->�ĤG��.+��k�W��
	// < (..) > -> ��k�̭����ѼơA�N����N�Ѽ�

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
		System.out.println("�����k�W�� : " + pjp.getSignature().getName());
		System.out.println("�����k�W��ñ�� : " + signaTure.getName());
		System.out.println(startTime + " �]���e�x�ɶ�(�@��)");
		// �I�sproceed()�A�~�|����쥻����k
		Object result = pjp.proceed();
		long spentTime = System.currentTimeMillis() - startTime;
		System.out.println(spentTime + " ��O�ɶ�(�@��)");
		System.out.println("around advice end ---------");
		return result;

	}

	// ---

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("AfterReturning advice -----------�~");
	}

	// ---
	// �������~�|�ҰʹD����k
	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		// �૬ �Ω���o��k�W��
		MethodSignature signaTure = (MethodSignature) joinPoint.getSignature();
		System.out.println("����x��k�W��joinPoint : " + joinPoint.getSignature().getName());
		System.out.println("����x��k�W��ñ�� : " + signaTure.getName());
		// �߿��T��
		System.out.println("���~�T�� : " + throwable.getMessage());
		System.out.println("AfterThrowing advice -----------");
	}
}

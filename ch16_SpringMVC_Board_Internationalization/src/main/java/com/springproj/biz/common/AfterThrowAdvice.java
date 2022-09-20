package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springproj.biz.domain.BoardVO;

@Service
@Aspect
public class AfterThrowAdvice {
	@Pointcut("execution(* com.springproj.biz..*Impl.*(..))")
	public void allPointcut() {}

	@AfterThrowing(pointcut = "allPointcut()", throwing = "exception")
	public void exceptionLog(JoinPoint jp, Exception exception) {
		String method = jp.getSignature().getName();
		
		if(exception instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		}else if(exception instanceof NullPointerException) {
			System.out.println("객체가 존재하지 않습니다.");
		}else {
			System.out.println("문제가 발생하였습니다.");
		}
		
		System.out.println("[오류발생(AfterThrowing)]"+method+"비즈니스 로직 수행 후 동작.");
		
	}
}

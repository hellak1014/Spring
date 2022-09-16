package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //bean객체를 생성하게끔 설정. 
@Aspect //pointcut과 advice의 설정이 있음을 표시. 
public class BeforeAdvice {
	
	@Pointcut("execution(* com.springproj.biz..*Impl.*(..))") //적용하고자 하는 핵심 모듈 설정. 
	//* com.springproj.biz 밑의 모든 폴더와 파일 검색. 그 중에 *Impl로 끝나는 모든 매서드들. 그 안의 모든 매개변수.
	//별도의 ID를 설정하는데 참조 매서드를 설정한다.
	public void allPointcut() {} //=ID 이름. 

	
	//advice 설정. 위에 설정한 ID에 있는 매서드가 실행되기 전에 이 아래에 있는 beforeLog 매서드가 수행되도록 함. 
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[공통로그(BeforeAdvice)]"+method+"비즈니스 로직 수행 전 동작.");
		System.out.println("args 정보 : "+args[0].toString());
	}
}

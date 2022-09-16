package com.springproj.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service //bean 생성
@Aspect //pointcut과 around를 설정
public class AroundAdvice {

	@Pointcut("execution(* com.springproj.biz..*Impl.*(..))") //포인트컷 지정
	public void allPointcut() {}
	
	@Around("allPointcut()") //별도의 매개변수가 없으니 그냥 ID만 지정해둠. 
	public Object aroundLog(ProceedingJoinPoint pjp) {
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		try {
			Object returnObj = pjp.proceed();
			
			stopWatch.stop();
			
			System.out.println(method + "() 메서드 수행에 걸린 시간 : "+
					stopWatch.getTotalTimeMillis()+"(ms)초\n");
			
			return returnObj;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

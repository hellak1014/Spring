package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springproj.biz.domain.BoardVO;

@Service //bean 설정. 
@Aspect //pointcut이랑 afterreturning을 연결
public class AfterReturningAdvice {
	/*
	@Pointcut("execution(* com.springproj.biz..*Impl.get*(..))") //실행되어야 하는 위치. 
	public void getPointcut() {} //고유 ID 지정
	
	@AfterReturning(pointcut = "getPointcut()", returning = "returnObj") //포인트컷의 위치와 반환값을 같이 가져와야 한다.
	*/ 
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		//Object[] args = jp.getArgs();
		
		if(returnObj instanceof BoardVO) {
			BoardVO board = (BoardVO) returnObj;
			
			if(board.getWriter().equals("홍길동")) {
				System.out.println("홍길동님이군요.");
			}
		}
		
		
		System.out.println("[정상 종료(AfterReturningAdvice)]"+method+"비즈니스 로직 수행 후 동작.");
		//System.out.println("args 정보 : " +args[0].toString());
		
	}
}

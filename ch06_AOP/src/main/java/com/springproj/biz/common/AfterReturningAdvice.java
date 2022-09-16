package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springproj.biz.board.BoardVO;

public class AfterReturningAdvice {

	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if (returnObj instanceof BoardVO) {
			
		}
		
		//자료형에 맞춰서 꺼내오기. 자료형을 받아오는 instanceof 연산자.
		
		
		System.out.println("[정상종료]" + method + "+비즈니스 로직 수행 이후 동작+");
		
		//after는 보통 핵심기능이 끝난 직후 소환이 되므로 보통은 리턴값을 받아와 확인한다.
		//따라서 before에는 리턴값이라는게 없기 때문에 쓸수가 없다.
	
	
	}
	
}

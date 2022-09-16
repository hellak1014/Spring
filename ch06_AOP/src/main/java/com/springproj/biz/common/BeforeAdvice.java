package com.springproj.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		
		System.out.println("[공통로그]" + method + "+비즈니스 로직 수행 전 동작+");
		System.out.println("args 정보 : " +args[0].toString());
		
		//joinpoint가 실행하면서 지금 대상으로 지목해서 실행하는 pointcut의 메소드를 전달해준다.
		//jp의 시그니처 정보를 전달하면서 그 정보의 매서드 이름을 반환해준다.
		//반환 형태가 String이기 때문에 그것을 method라는 지역변수로 만들어서 적용한다.
		//만약 호출한 매서드가 가져오는 정보도 알고 싶을경우, 배열로 들어오기 때문에 배열 지역변수로 담아준다.(args)
		//그리고 별도로 호출한다. 배열이기 때문에 배열일 경우 정보가, 없다면 그냥 정보가 나온다.
	}
	
}

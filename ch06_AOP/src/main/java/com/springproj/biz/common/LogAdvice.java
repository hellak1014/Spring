package com.springproj.biz.common;

public class LogAdvice {
	//프로젝트의 성격에 맞는 annotation을 사용해야 한다. 
	public void printLog(String func) {
		System.out.println("[공통로그]" + func + "비즈니스 로직 수행 전 동작");
	}

}

package com.springproj.ex02;

public class TvUser {

	public static void main(String[] args) {
		
		TV tv = new LgTV(); //변수 선언 이후 메모리 할당(객체 만들어줘) 요청. tv는 부모.
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
	}

}

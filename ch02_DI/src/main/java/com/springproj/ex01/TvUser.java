package com.springproj.ex01;

public class TvUser {

	public static void main(String[] args) {
		//SSTV ssTv
		LGTV lgTv;
		lgTv = new LGTV(); //lgtv 찾아가서 크기를 계산해 메모리를 할당해줘
					// 시작 주소값을 가지고 와있음. 보관할 용도의 메모리 공간을 만들어야 한다.
		
		lgTv.turnOn();
		lgTv.soundUp();
		lgTv.soundOff();
		lgTv.turnOff();
		
	}

}

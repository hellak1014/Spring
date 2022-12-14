package ex06.springcontainer.di.xmlns.p;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		//생성자 특징. 클래스와 동일한 이름. 매서드와 비슷한 외형이지만 매서드가 다름. 매서드는 반환명이 있어야 하지만 
		//얘는 반환명이 없다. 그리고 호출 목적도 아니다. 얘는 자바에 의해서 객체를 생성할때 new라고 하면 이곳으로 들어와
		//SonySpeaker에 대해 메모리를 받는다. 그리고는 생성자를 호출하게끔 동작한다. 우리가 호출하려고 하는게 아니라 
		//단 한번 호출되기 위해 만들어짐. 
		//this -> 지금 할당한 메모리의 참조변수를 이야기 함. this.(new로 선언한 객체) 생성자를 호출한다. 
		
		System.out.println("AppleSpeaker 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("AppleSpeaker --- 소리 올림");
	}
	
	public void volumeDown() {
		System.out.println("AppleSpeaker --- 소리 내림");
	}

	//엘지사 티비 구매시 스피커를 증정한다고 가정.
}

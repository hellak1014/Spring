package ex01.annotation.component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		//TV tv = new LgTV(); //변수 선언 이후 메모리 할당(객체 만들어줘) 요청. tv는 부모.
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext01.xml"); 
		//주소값 가져와서 넣을 변수 설정
		//메모리 할당 (객체 만들어줘) 근데 이제 스프링 참고해서.
		//스프링이 할 일을 얻어 갈 수 있도록 정보를 할당. 
		
		
		TV tv = (TV)factory.getBean("tv"); //스프링아 위의 xml에서 주소값 tv인거 주라. 그리고 변수 tv 설정. 시작 주소값 반환
		//(TV)를 안 친 상태에서는 에러 메세지가 뜨는데, 보면 tv를 받아오는 타입이 object라고 온다. 
		//그 이유는 컴파일 할때 object로 컴파일됨
		//그 이유는 다형성. 모든 클래스의 최고 부모 클래스를 object로 강제하기 때문이다. 어떤 자료형이라도 받아오기 위해서
		//자바가 리턴을 object로 받아온 것. 그리고 TV는 Object보다 낮은 단계이기 때문에 에러가 나는것. 
		//원래 자료형으로 복원을 해야 한다. => 강제 형변환을 진행. TV를 TV로 보라고 시키는 것. 
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
		
	}

}

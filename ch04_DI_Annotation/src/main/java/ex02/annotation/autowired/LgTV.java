package ex02.annotation.autowired;



import javax.inject.Inject;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component ("tv") 
//이걸 붙임으로서 설정파일이 스캔. 
//스캔하면서 여기서도 관리대상(id)을 설정할 수 있다. 설정파일에서 객체 생성으로 동작하는 bean을 대체.
//설정파일의 작업이 줄어드는 효과. 여기서는 LgTV를 사용할수있다. 
public class LgTV implements TV{
	
	//Speaker speaker = new SonySpeaker(); //이렇게 하면 강한 결합성을 가짐
	//@Autowired //자료형이 Speaker인 객체를 가져오기.  (Spring)
	@Inject //이건 자바가 제공해주는 annotation. autowired의 기능과 똑같다. 
	Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV 객체 생성");
	}

	@Override	//이것도 annotation. 1. 가독성 이유. 2. 에러를 보여주기 위해서. (오버라이딩에서 없으면 안해줌) 
	public void powerOn() {
		System.out.println("LgTV powerOn");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV powerOff");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		/* System.out.println("LgTV volumeup"); */
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		/* System.out.println("LgTV volumeDown"); */
	
	}
	
	
	
}

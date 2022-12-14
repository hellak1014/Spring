package ex04.springcontainer.di.constructor;

public class LgTV implements TV{
	//의무적인 매서드 오버라이딩. 기능의 정의를 해주어야 한다.
	
	Speaker speaker; //인터페이스 부모형으로 부르기
	int price;
	
	
	public LgTV() {
		// speaker = new SonySpeaker(); 필드 초기화는 생성자에서 하는게 원래 원칙이었으나, 스프링에서는 bean으로 한다.
	}
	
	public LgTV(Speaker speaker) {
		// speaker = new SonySpeaker();
		this.speaker = speaker;
	}
	
	public LgTV(Speaker speaker, int price) {
		// speaker = new SonySpeaker();
		this.speaker = speaker;
		this.price = price;
		System.out.println("price : " + this.price);
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV powerOff");
		
	}

	@Override
	public void volumeUp() {
		/* System.out.println("LgTV volumeup"); */
		//sonyspeaker의 볼륨업을 사용. 
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		/* System.out.println("LgTV volumeDown"); */
		speaker.volumeDown();
	}
	
	
	
}

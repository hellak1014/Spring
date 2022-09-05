package ex05.springcontainer.di.setter;

public class LgTV implements TV{
	
	
	Speaker speaker; //필드변수
	int price; 
	
	
	public LgTV() {
		// speaker = new SonySpeaker(); 
		// 필드 초기화는 생성자에서 하는게 원래 원칙이었으나, 스프링에서는 bean으로 한다.
	}
	
	
	public void setSpeaker(Speaker speaker) { //프로퍼티 이름이 필드변수와 같다.
		System.out.println("setSpeaker() 매서드 호출");
		this.speaker = speaker;   
	}
	

	public void setPrice(int price) {
		System.out.println("setPrice() 매서드 호출. price : " + price);
		this.price = price;
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

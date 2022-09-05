package ex01.collection.list;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext01.xml");
		//xml 파일을 읽어서 실행해야겠다는 정보 제공. 
		
		factory.getBean("collectionBean"); 
		//bean을 불러오기. 참조변수의 이름이 없을경우, 참조변수의 첫글자를 소문자로 하면 됨. 
		//object로 오기 때문에 강제 형변환을 해야함.
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		//getbean으로 요청한 xml을 읽어서 bean객체를 생성하고, CollectionBean의 bean객체를 반환한다. 
		
		List<String> list = bean.getAddressList();
		
		for(String address : list) {
			System.out.println(address);
		}
		//제너릭으로 출력. 이때 address는 객체라서 원래는 오버라이딩으로 출력이 되지 않는게 맞다. 
		//하지만 이때의 address는 object.tostring된거라서 에러가 나질 않는다. (재정의 되어있다.)
		
		factory.close();
		
	}

}

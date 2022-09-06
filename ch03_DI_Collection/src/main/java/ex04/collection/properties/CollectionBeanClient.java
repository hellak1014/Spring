package ex04.collection.properties;


import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext04.xml");
		
		
		factory.getBean("collectionBean"); 
		
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		
		Properties addressList = bean.getAddressList();
		//map과 거의 동일하다. 일반적으로 적은 데이터는 map. 대용량은 properties를 사용한다. (선택적)
		for(String key : addressList.stringPropertyNames()) {
			System.out.println(String.format("키:%s, 값:%s ", key, addressList.get(key)));
		}
		
		
		factory.close();
		
	}

}

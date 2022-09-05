package ex03.collection.map;


import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext03.xml");
		
		
		factory.getBean("collectionBean"); 
		
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		
		Map <String, String> map = bean.getAddressList();
		
		for(String key : map.keySet()) {
			System.out.println(String.format("키:%s, 값:%s ", key, map.get(key)));
		}
		
		
		factory.close();
		
	}

}

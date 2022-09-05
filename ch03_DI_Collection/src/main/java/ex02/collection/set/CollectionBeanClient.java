package ex02.collection.set;


import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext02.xml");
		
		
		factory.getBean("collectionBean"); 
		
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		 
		
		Set <String> set = bean.getAddressList();
		
		for(String address : set) {
			System.out.println(address);
		}
		
		
		factory.close();
		
	}

}

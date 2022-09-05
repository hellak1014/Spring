package ex02.collection.set;

import java.util.Set;

public class CollectionBean { //CollectionBean -> 참조 자료형. 

	private Set<String> addressList; //참조변수 선언. getter와 setter를 통해 자동으로 스프링을 통해 자료를 주고 받겟다. 

	public Set<String> getAddressList() { //getter
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {  //setter
		this.addressList = addressList;
	}
	
	
}

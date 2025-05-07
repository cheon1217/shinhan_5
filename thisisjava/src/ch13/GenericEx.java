package ch13;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GenericEx {

	public static void main(String[] args) {
		// List 인터페이스
		// 배열과 유사 : 여러 값을 저장하는 용도
		// 타입 제한 없음, 길이 변경 가능
		List<Order> list = new ArrayList<Order>();
//		List list = new ArrayList();
		
		Order o = new Order();
		o.setNumber("12345");
		list.add(o);
		o = new Order();
		o.setNumber("12346");
		list.add(o);
		o = new Order();
		o.setNumber("12347");
		list.add(o);
//		list.add(new Car()); // 강한 타입 체크 
		
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(((Order)list.get(i)).getNumber());
			System.out.println(list.get(i).getNumber()); // 강제형변환 불필요
		}
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(30);
		list2.add(20);
		list2.add(10);
		System.out.println(list2);
		
	}

}

@Getter
@Setter
@ToString
class Order {
	private String number;
	private String date;
	private int price;
}

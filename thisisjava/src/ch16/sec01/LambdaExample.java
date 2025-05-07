package ch16.sec01;

public class LambdaExample {

	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});
		
		action((x, y) -> {
			int result = x - y;
			System.out.println("result: " + result);
		});
	}
	
	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		calculable.calculate(x, y);
	}
	
	/*
	 * cal 필드 (람다식 필드 선언)
	 	클래스 레벨에서 선언된 람다식 필드입니다.
		cal 은 Calculable 타입의 람다식이며, 뺄셈 연산을 수행합니다.
		예를 들어 cal.calculate(10, 4); 라고 하면, result: 6 이 출력됩니다.
		지금 코드에서는 사용하고 있지 않지만, 추후에 메서드 없이 필드로 사용할 때 유용
	 */
	public static Calculable cal = (x, y) -> {
		int result = x - y;
		System.out.println("result: " + result);
	};
	
	/*
	 *  람다식 반환 메소드
	 *  Calculable c = get();
	 *  c.calculate(10, 4); // result: 6
	 *  이렇게 메서드를 통해 람다식을 생성해서 외부에서 사용할 수 있습니다.
	 *  필요할 때마다 새로 생성할 수 있기 때문에 동적으로 람다를 반환하는 기법.
	 */
	public static Calculable get() {
		return (x, y) -> {
			int result = x - y;
			System.out.println("result: " + result);
		};
	}

}

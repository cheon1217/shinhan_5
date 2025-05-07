package ch08.sec02;

import java.util.Arrays;
import java.util.function.IntFunction;

import ch07.sec08.exam02.Vehicle;
import ch07.sec10.exam02.Animal;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		
		// rc 변수에 Television 객체를 대입
		rc = new Television();
		rc.turnOn();
		
		// rc 변수에 Audio 객체를 대입
		rc = new Audio();
		rc.turnOn();
		
		// 익명 객체 (일회성)
		RemoteControl rc2 = new RemoteControl() {
			public void turnOn() {
				System.out.println("에어컨을 켠다.");
			}
		};
		
		// 익명 상속 객체
		Animal ani = new Animal() {
			public void sound() {
				System.out.println("어흥");
			}
		};
		sound(ani);
		
		sound(new Animal() {
			public void sound() {
				System.out.println("야옹");
			}
		});
		
		sound(new Animal() {
			public void sound() {
				System.out.println("찍찍");
			}
		});
		
		Vehicle truck = new Vehicle() {
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		};
		
		cal(new LamdaEx() {
			@Override
			public int calc(int x, int y) {
				return x * y;
			}
		});
		
		cal((x, y) -> x -y);
		
		int[] arr = {1, 2, 3, 4, 5};
		// int[] -> Integer[]
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(new IntFunction<Integer[]>() {

			@Override
			public Integer[] apply(int value) {
				return new Integer[value];
			}
			
		});
		
		System.out.println(Arrays.toString(arr2));
		
		// Integer[] => int[]
		int[] arr3 = Arrays.stream(arr2).mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(arr3));
		
	}
	
	public static void sound(Animal ani) {
		ani.sound();
	}
	
	public static void cal(LamdaEx ex) {
		int result = ex.calc(10, 20);
		System.out.println(result);
	}

}

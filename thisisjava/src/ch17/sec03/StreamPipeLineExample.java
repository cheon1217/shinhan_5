package ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		
		// 방법 1
		Stream<Student> studentStream = list.stream();
		// 중간처리
		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		// 최종처리
		double avg1 = scoreStream.average().getAsDouble();
		
		System.out.println("평균 점수: " + avg1);
		
		// 방법 2
		double avg2 = list.stream()
				.mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		
		System.out.println("평균 점수: " + avg2);
	}

}

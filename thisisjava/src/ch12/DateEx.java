package ch12;

import java.text.DecimalFormat;

public class DateEx {

	public static void main(String[] args) {
		double a = 123456789.123456789;
		// #과 0이 있지만 웬만하면 다 #써도 무방
		// 0은 자리수가 모자를 때 채워줌 #은 안 채워줌 -> 이럴 때만 0 사용
		DecimalFormat df = new DecimalFormat("#,###.####");
		System.out.println(df.format(a));
	}

}

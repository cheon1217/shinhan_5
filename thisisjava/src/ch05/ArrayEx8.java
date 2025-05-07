package ch05;

public class ArrayEx8 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int totalP = 0;
		int totalSum = 0;
		
		for (int i = 0; i < array.length; i++) {
			totalP += array[i].length;
			for (int j = 0; j < array[i].length; j++) {
				totalSum += array[i][j];
			}
		}
		double avg = (double)totalSum / totalP;
		
		System.out.println("전체 합: " + totalSum);
		System.out.println("평균: " + avg);
	}

}

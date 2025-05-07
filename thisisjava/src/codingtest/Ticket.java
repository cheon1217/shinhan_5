package codingtest;

import java.util.Arrays;
import java.util.Comparator;

public class Ticket {

	public static int solution(int tickets, int[][] requests) {
		int soldTickets  = 0;
		
		Arrays.sort(requests, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
						
		});
		for (int i = 0; i < requests.length; i++) {
			if (tickets >= requests[i][1]) {
				soldTickets  += requests[i][1];
				tickets -= requests[i][1];
			}
		}
		
		return soldTickets ;
		
	}
	
	public static void main(String[] args) {
		int[][] request1 = {{2, 3},{1, 7},{2, 4},{3, 5}};
		int ticket1 = 10;
		
		System.out.println(solution(ticket1, request1));
		
		int[][] request2 = {{1,9},{3,6},{2,5}};
		int ticket2 = 8;
		
		System.out.println(solution(ticket2, request2));
		
		int[][] request3 = {{3,1},{2,5},{2,10},{3,8},{1,2}};
		int ticket3 = 20000;
		
		System.out.println(solution(ticket3, request3));
	}

	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		// TODO Auto-generated method stub
		return null;
	}

}

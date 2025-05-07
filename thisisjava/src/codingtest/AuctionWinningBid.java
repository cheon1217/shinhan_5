package codingtest;

import java.util.Arrays;

public class AuctionWinningBid {
	// 경매 낙찰 금액
	// 가장 높은 금액의 사람이 2번째로 높은 금액의 사람 + 10000원을 내고 물품 구입
	// 같은 금액으로 높으면 낮은 번호의 사람
	public static int[] solution(int n, int[] amounts) {
		int[] result = new int[n];
		int m = amounts.length;
		
		for (int i = 0; i < n; i++) {
			// 참가자 자본이 모두 0이면 낙찰 금액 0
			boolean allZero = true;
			for (int money : amounts) {
				if (money > 0) {
					allZero = false;
					break;
				}
			}
			if (allZero) {
				result[i] = 0;
				continue;
			}
			
			// 1. 가장 자본 많은 사람 찾기
			int maxAmount = 0;
			int maxCount = 0;
			int maxIndex = 0;
			
			for (int j = 0; j < m; j++) {
				if (amounts[j] > maxAmount) {
					maxAmount = amounts[j];
					maxIndex = j;
					maxCount = 1;
				} else if (amounts[j] == maxAmount) {
					maxCount++;
				}
			}
			
			// 낙찰가
			int bidPrice;
			
			if (maxCount >= 2) {
				// 자본이 같은 참가자가 2명 이상이면 maxIndex가 이미 가장 빠른 번호
				bidPrice = amounts[maxIndex];
			} else {
				// 두 번째로 많은 자본 찾기
				int secondMaxAmount = 0;
				for (int j = 0; j < m; j++) {
					if (j != maxIndex && amounts[j] > secondMaxAmount) {
						secondMaxAmount = amounts[j];
					}
				}
				// 입찰가 계산 (초과할 수 없으므로 min 사용)
				bidPrice = Math.min(amounts[maxIndex], secondMaxAmount + 10000);
			}
			
			// 낙찰 처리
			amounts[maxIndex] -= bidPrice;
			result[i] = bidPrice;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] test1 = {1000000, 490000, 700000, 290000};
        System.out.println(Arrays.toString(solution(4, test1))); // [710000, 500000, 300000, 290000]

        int[] test2 = {30000, 70000, 10000};
        System.out.println(Arrays.toString(solution(6, test2))); // [40000, 30000, 20000, 10000, 10000, 0]
        
        int[] test3 = {50000, 90000, 10000, 60000};
        System.out.println(Arrays.toString(solution(3, test3)));
	}

}

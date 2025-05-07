package ch06.ex.num20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	private static List<Account> accountList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNum = scanner.nextInt();
			
			if (selectNum == 1) {
				createAccount();
			} else if (selectNum == 2) {
				accountList();
			} else if (selectNum == 3) {
				deposit();
			} else if (selectNum == 4) {
				withdraw();
			} else if (selectNum == 5) {
				run = false;
			} else {
				System.out.println("1~5 중에 선택하세요.");
				continue;
			}
		}
		System.out.println("프로그램 종료");
	}
	
	// 계좌 생성
	public static void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accNum = scanner.next();
		
		if (findAccount(accNum) != null) {
			System.out.println("이미 존재하는 계좌");
			return;
		}
		
		System.out.print("계좌주: ");
		String accOwn = scanner.next();
		
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		
		Account acc = new Account(accNum, accOwn, balance);
		
		accountList.add(acc);
		
		System.out.println("계좌 생성 완료");
	}
	
	// 계좌 목록 조회
	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		
		if (accountList.isEmpty()) {
			System.out.println("등록된 계좌가 없다.");
			return;
		}
		
		for (Account acc : accountList) {
			System.out.printf("%s\t%s\t%d원\n", acc.getAccNum(), acc.getAccOwn(), acc.getBalance());
		}
	}
	
	// 예금
	private static void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accNum = scanner.next();
		
		Account acc = findAccount(accNum);
		
		if (acc == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}
		
		System.out.print("예금액: ");
		int balance = scanner.nextInt();
		
		if (balance <= 0) {
            System.out.println("0원 이상 입력해주세요.");
            return;
        }

        acc.setBalance(acc.getBalance() + balance);
        System.out.println("예금 성공.");
	}
	
	// 출금
	private static void withdraw() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accNum = scanner.next();
		
		Account acc = findAccount(accNum);
		
		if (acc == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		} 
		
		System.out.print("출금액: ");
		int balance = scanner.nextInt();
		
		
		if (acc.getBalance() < balance) {
			System.out.println("금액 부족");
			return;
		}
		
		acc.setBalance(acc.getBalance() - balance);
		System.out.println("출금 성공");
	}
	
	// Account 배열에서 accNum과 똑같은 계좌 찾기
	private static Account findAccount(String accNum) {
		return accountList.stream()
				.filter(acc -> acc.getAccNum().equals(accNum))
				.findFirst()
				.orElse(null);
	}

}

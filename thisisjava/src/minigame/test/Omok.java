package minigame.test;

import java.util.Scanner;

public class Omok {
    public static void main(String[] args) {
        Player player1 = new Player("플레이어1", "O", true); // 흑: 금수 적용
        Player player2 = new Player("플레이어2", "X", false); // 백: 금수 없음
        Board board = new Board(19);
        play(board, player1, player2);
    }

    private static void play(Board board, Player player1, Player player2) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            board.print();
            System.out.println(currentPlayer.name + " (" + currentPlayer.stone + ") 의 차례입니다.");
            System.out.print("좌표 입력 (예: A0): ");

            String input = scanner.nextLine().trim().toUpperCase();
            if (!input.matches("^[A-S](\\d{1,2})$")) {
                System.out.println("좌표 형식이 올바르지 않습니다. 다시 시도하세요. (예: A0)");
                continue;
            }

            char colChar = input.charAt(0);
            int col = colChar - 'A';
            int row = Integer.parseInt(input.substring(1));

            if (!board.isValidMove(row, col)) {
                System.out.println("잘못된 위치입니다. 다시 시도하세요.");
                continue;
            }

            // 금수 검사
            if (isForbiddenMove(row, col, currentPlayer.stone)) {
                System.out.println("금수입니다! 다른 위치를 선택하세요.");
                continue;
            }


            // 장목 검사
            if (board.isOverline(row, col, currentPlayer.stone)) {
                System.out.println("장목입니다! 다시 놓으세요");
                continue;
            } else if (board.checkWin(row, col, currentPlayer.stone)) {
                board.print();
                System.out.println(currentPlayer.name + " 님이 승리했습니다!");
                break;
            } else if (board.isFull()) {
                board.print();
                System.out.println("무승부입니다!");
                break;
            } else {            	
            	board.placeStone(row, col, currentPlayer.stone);
            }

            // 플레이어 교대
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }

	private static boolean isForbiddenMove(int row, int col, String stone) {
		// TODO Auto-generated method stub
		return false;
	}
}
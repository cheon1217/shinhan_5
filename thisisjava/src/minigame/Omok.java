package minigame;

import java.util.Scanner;

public class Omok {
    public static void main(String[] args) {
        Player player1 = new Player("플레이어1", "O");
        Player player2 = new Player("플레이어2", "X");
        Board board = new Board(19);
        play(board, player1, player2);
    }

    private static void play(Board board, Player player1, Player player2) {
    	// 사용자 입력을 받기
        Scanner scanner = new Scanner(System.in);
        // player1으로 초기화
        Player currentPlayer = player1;

//        board.print();
        while (true) {
        	board.print();
            // 좌표입력
            System.out.println(currentPlayer.name + " (" + currentPlayer.stone + ") 의 차례입니다.");

            String input = scanner.nextLine().toUpperCase();
            if (input.length() < 2) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }
            
            char colChar = input.charAt(0);
            int row = -1;
            int col = -1;

            try {
            	// int로 변환 후 인덱스화 (-1 해서 배열 인덱스 맞춤)
                row = Integer.parseInt(input.substring(2));
                // 'A' 빼서 인덱스화
                col = colChar - 'A';
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }

            // 이미 돌이 있거나 범위 벗어날 시 입력 다시 요청
            if (!board.isValidMove(row, col)) {
                System.out.println("잘못된 위치입니다. 다시 시도하세요.");
                continue;
            }

            // 돌 놓기
            if(board.checkValid(row, col, currentPlayer.stone) <= 5) {
            	board.placeStone(row, col, currentPlayer.stone);
            }else {
            	int num = board.checkValid(row, col, currentPlayer.stone);
            	if(num == 33) {
            		System.out.println("쌍3 입니다! 다시 놓으세요");
            	}
            	else if(num == 44) {
            		System.out.println("쌍4 입니다! 다시 놓으세요");
            	}
            	else {
                	System.out.println(num+"목 입니다! 다시 놓으세요");
            	}
            	continue;
            }
            // 승리 판별
            if (board.checkWin(row, col, currentPlayer.stone)) {
                board.print();
                System.out.println();
                System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
                System.out.println("★   🎉 "+ currentPlayer.name +" 님이 승리했습니다! 🎉   ★");	
                System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
                break;
            }
             
            // player 교대
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}

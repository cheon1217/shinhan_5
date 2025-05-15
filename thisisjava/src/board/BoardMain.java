package board;

import java.util.List;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardMain {
    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== 게시판 ===");
            System.out.println("1. 게시글 목록 보기");
            System.out.println("2. 게시글 추가");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    List<BoardDTO> boards = dao.getAllBoards();
                    for (BoardDTO board : boards) {
                        System.out.println(board);
                    }
                    break;
                case 2:
                    System.out.print("제목: ");
                    String title = scanner.nextLine();
                    System.out.print("내용: ");
                    String content = scanner.nextLine();
                    System.out.print("작성자: ");
                    String writer = scanner.nextLine();

                    BoardDTO newBoard = new BoardDTO(0, title, content, writer, null);
                    dao.addBoard(newBoard);
                    System.out.println("게시글이 추가되었습니다.");
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
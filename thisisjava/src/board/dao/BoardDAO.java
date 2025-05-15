package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.util.OracleDBUtil;

public class BoardDAO {
    private Connection conn;

    public BoardDAO() {
        conn = OracleDBUtil.getConnection();
    }

    // 게시글 목록 조회
    public List<BoardDTO> getAllBoards() {
        List<BoardDTO> boards = new ArrayList<>();
        String sql = "SELECT * FROM board";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BoardDTO board = new BoardDTO(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"),
                        rs.getString("created_date"));
                boards.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boards;
    }

    // 게시글 추가
    public void addBoard(BoardDTO board) {
        String sql = "INSERT INTO board (title, content, writer, created_date) VALUES (?, ?, ?, SYSDATE)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setString(3, board.getWriter());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

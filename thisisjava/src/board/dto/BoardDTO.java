package board.dto;

public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String createdDate;

    // 기본 생성자
    public BoardDTO() {
    }

    // 모든 필드를 포함한 생성자
    public BoardDTO(int id, String title, String content, String writer, String createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
    }

    // Getter와 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BoardDTO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
                + ", createdDate=" + createdDate + "]";
    }
}

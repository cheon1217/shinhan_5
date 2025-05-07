package team3.domain;

import lombok.Data;

@Data
public class Users {
	private int userId;
    private String email;
    private String password;
    private int age;
    private int score;

    public Users(int userId, String email, String password, int age, int score) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.age = age;
        this.score = score;
    }

    public int getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public int getScore() { return score; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setAge(int age) { this.age = age; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return String.format(
            "👤 사용자 ID: %-4d | 📧 이메일: %-25s | 🎂 나이: %-3d | 🌟 점수: %-3d",
            userId, email, age, score
        );
    }


}

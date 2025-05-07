package minigame.test;

public class Player {
    String name;
    String stone;
    boolean isForbiddenRule; // 금수 규칙 적용 여부 (흑: true, 백: false)

    Player(String name, String stone, boolean isForbiddenRule) {
        this.name = name;
        this.stone = stone;
        this.isForbiddenRule = isForbiddenRule;
    }
}

package minigame.test;

class Board {
    int size;
    String[][] map;
    char c = 65;

    Board(int size) {
        this.size = size;
        map = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
    }

    public void print() {
        c = 65;
        for (int row = 0; row < size + 1; row++) {
            if (row == size) {
                System.out.print("  ");
                for (int col = 0; col < size; col++) {
                    System.out.print(" " + c++);
                }
            } else {
                if (row < 10) System.out.print(row + " ");
                else System.out.print(row);
                for (int col = 0; col < size; col++) {
                    System.out.print(" " + map[row][col]);
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && map[row][col].equals(".");
    }

    public void placeStone(int row, int col, String stone) {
        map[row][col] = stone;
    }

    public boolean isFull() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (map[row][col].equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(int row, int col, String stone) {
        return checkDirection(row, col, stone, 1, 0) // 가로
            || checkDirection(row, col, stone, 0, 1) // 세로
            || checkDirection(row, col, stone, 1, 1) // 대각 ↘
            || checkDirection(row, col, stone, 1, -1); // 대각 ↙
    }

    private boolean checkDirection(int row, int col, String stone, int dRow, int dCol) {
        int count = 1;
        count += countStones(row, col, stone, dRow, dCol);
        count += countStones(row, col, stone, -dRow, -dCol);
        return count == 5;
    }

    private int countStones(int row, int col, String stone, int dRow, int dCol) {
        int count = 0;
        int currRow = row + dRow;
        int currCol = col + dCol;

        while (currRow >= 0 && currRow < size && currCol >= 0 && currCol < size && map[currRow][currCol].equals(stone)) {
            count++;
            currRow += dRow;
            currCol += dCol;
        }
        return count;
    }

    public boolean isOverline(int row, int col, String stone) {
        return countInDirection(row, col, stone, 1, 0) > 5
            || countInDirection(row, col, stone, 0, 1) > 5
            || countInDirection(row, col, stone, 1, 1) > 5
            || countInDirection(row, col, stone, 1, -1) > 5;
    }

    private int countInDirection(int row, int col, String stone, int dRow, int dCol) {
        int count = 1;
        count += countStones(row, col, stone, dRow, dCol);
        count += countStones(row, col, stone, -dRow, -dCol);
        return count;
    }

 // 양쪽 끝 상태 포함해서 연속된 돌 개수 + 양쪽 끝 상태 반환
    private int[] countStonesWithEnds(int row, int col, String stone, int dRow, int dCol) {
        int count = 1;

        int currRow = row + dRow;
        int currCol = col + dCol;
        while (isInBounds(currRow, currCol) && map[currRow][currCol].equals(stone)) {
            count++;
            currRow += dRow;
            currCol += dCol;
        }

        int end1 = isInBounds(currRow, currCol) && map[currRow][currCol].equals(".") ? 1 : 0;

        currRow = row - dRow;
        currCol = col - dCol;
        while (isInBounds(currRow, currCol) && map[currRow][currCol].equals(stone)) {
            count++;
            currRow -= dRow;
            currCol -= dCol;
        }

        int end2 = isInBounds(currRow, currCol) && map[currRow][currCol].equals(".") ? 1 : 0;

        return new int[]{count, end1 + end2}; // [돌 개수, 열린 끝 개수]
    }

    // 보드 범위 안인지 확인하는 메서드
    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
    
    boolean isForbiddenMove(int row, int col, String stone) {
        int openThree = 0;
        int openFour = 0;

        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        for (int[] dir : directions) {
            int[] result = countStonesWithEnds(row, col, stone, dir[0], dir[1]);
            int count = result[0];
            int openEnds = result[1];

            if (count > 5) {
                return true; // 장목 검사
            }

            if (count == 3 && openEnds == 2) {
                openThree++;
            }

            if (count == 4 && openEnds >= 1) {
                openFour++;
            }
        }

        return openThree >= 2 || openFour >= 2;
    }

}

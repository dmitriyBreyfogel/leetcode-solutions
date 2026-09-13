package Medium;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] boxStartCorners = {
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}
        };

        for (int i = 0; i < 9; i++) {
            if (!validRow(board[i])) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!validColumn(board, i)) return false;
        }

        for (int[] corner: boxStartCorners) {
            if (!validBox(board, corner[0], corner[1])) return false;
        }

        return true;
    }

    private boolean validColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];

        for (int i = 0; i < 9; i++) {
            char ch = board[i][col];
            if (ch == '.') continue;

            int num = ch - '1';
            if (seen[num]) return false;
            seen[num] = true;
        }

        return true;
    }

    private boolean validRow(char[] row) {
        boolean[] seen = new boolean[9];

        for (char ch : row) {
            if (ch == '.') continue;
            int num = ch - '1';
            if (seen[num]) return false;
            seen[num] = true;
        }

        return true;
    }

    private boolean validBox(char[][] board, int rowStart, int colStart) {
        boolean[] seen = new boolean[9];

        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;

                int num = ch - '1';
                if (seen[num]) return false;
                seen[num] = true;
            }
        }

        return true;
    }
}

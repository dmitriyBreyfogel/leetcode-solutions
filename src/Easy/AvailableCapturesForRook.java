package Easy;

public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int[] rook = findRook(board);

        int rowRook = rook[0];
        int colRook = rook[1];

        int count = 0;
        for (int i = colRook; i >= 0; i--) {
            if (board[rowRook][i] == 'p') { count++; break;}
            if (board[rowRook][i] == 'B') { break;}
        }

        for (int i = colRook; i < board.length; i++) {
            if (board[rowRook][i] == 'p') { count++; break; }
            if (board[rowRook][i] == 'B') { break; }
        }

        for (int i = rowRook; i >= 0; i--) {
            if (board[i][colRook] == 'p') { count++; break; }
            if (board[i][colRook] == 'B') { break;}
        }

        for (int i = rowRook; i < board.length; i++) {
            if (board[i][colRook] == 'p') { count++; break; }
            if (board[i][colRook] == 'B') { break; }
        }

        return count;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }
}

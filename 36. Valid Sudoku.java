// Solution 1

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] != '.' && !isValidPlacement(board, board[row][column], row, column))
                    return false; 
            }
        }
        return true;
    }

    private boolean isValidPlacement(char[][] board, char number, int row, int column) {
        return !isNumberInRow(board, number, row, column) && 
               !isNumberInColumn(board, number, row, column) && 
               !isNumberInBox(board, number, row, column);
    }

    private boolean isNumberInRow(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number && column != i) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInColumn(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == number && row != i) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(char[][] board, char number, int row, int column) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (row != i && column != j && board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Solution 2

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> columns = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            rows = new HashSet<>();
            columns = new HashSet<>();
            //rows.clear();
            //columns.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) return false; 
                    else rows.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (columns.contains(board[j][i])) return false;
                    else columns.add(board[j][i]);
                }
            }
        } 

        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[i].length; j+=3) {
                if (!checkSquare(i, j, board)) return false;
            }
        }
        return true;
    }  

    public boolean checkSquare(int row, int column, char[][] board) {
        HashSet<Character> squares = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] != '.') {
                    if (squares.contains(board[i][j])) return false;
                    else squares.add(board[i][j]);
                }
            }
        }
        return true;
    }
}

import java.util.Scanner;

public class NQueens {

    // Function to print the board
    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper left diagonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper right diagonal
        for (int i = row-1, j = col+1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Backtracking function to solve N-Queens
    public static boolean solveNQueens(int[][] board, int row, int N) {
        if (row >= N) return true; // All queens placed

        for (int col = 0; col < N; col++) {
            if (board[row][col] == 0 && isSafe(board, row, col, N)) {
                board[row][col] = 1; // Place queen
                if (solveNQueens(board, row + 1, N)) return true;
                board[row][col] = 0; // Backtrack
            }
        }

        return false; // No valid placement found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the board (N): ");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        System.out.print("Enter the row index for the first queen (0-" + (N-1) + "): ");
        int firstRow = sc.nextInt();
        System.out.print("Enter the column index for the first queen (0-" + (N-1) + "): ");
        int firstCol = sc.nextInt();

        // Place the first queen
        board[firstRow][firstCol] = 1;

        // Start backtracking from the next row
        int startRow = (firstRow == 0) ? 1 : 0;

        if (solveNQueens(board, startRow, N)) {
            System.out.println("N-Queens solution:");
            printBoard(board, N);
        } else {
            System.out.println("No solution exists with the first queen at (" + firstRow + "," + firstCol + ")");
        }

        sc.close();
    }
}

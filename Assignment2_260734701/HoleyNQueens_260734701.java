package kattis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HoleyNQueens_260734701{
	public static int n;
	static int numSolutions = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line;
		int ninitial, m;
		while ((line = in.readLine()) != null) {
			String[] inarr = line.split(" ");
			ArrayList<Integer> input = new ArrayList<>();
			for (String s : inarr) {
				if(!s.isEmpty()) {
					input.add(Integer.parseInt(s));
				}
			}
			ninitial = input.get(0);
			m = input.get(1);
			//The end input is marked by values of zero for N and M
			if (ninitial == 0 && m == 0) {
				System.exit(0);
			}
			//Check the boundaries of N and M
			if (ninitial < 3 || ninitial > 12) {
				System.out.println("N must be greater than or equal to 3 and less than or equal to 12");
				System.exit(0);
			}
			if (m < 0 || m > (ninitial*ninitial)) {
				System.out.println("M must be greater than or equal to 0 and less than or equal to N^2");
				System.exit(0);
			}
			n = ninitial;
			//board[][] represents our board: if 0 open spot, if 1 queen at that spot, if 2 hole at that spot
			int board[][] = new int[n][n];
			for (int i = 0; i < m; i++) {
				input.clear();
				line = in.readLine();
				String[] inarr2 = line.split(" ");
				for (String s : inarr2) {
					if(!s.isEmpty()) {
						input.add(Integer.parseInt(s));
					}
				}
				int row = input.get(0);
				int col = input.get(1);
				board[row][col] = 2;
			}
			solver(board, 0);
			out.append(numSolutions+"\n");
			numSolutions = 0;
			out.flush();
			
		}
	}
	public static void solver(int board[][], int row) {
		//if n queens successfully placed exit solver
		if (row == n) {
			numSolutions++;
			return;
		}
			
		for (int i = 0; i < n; i++) {
			if (canPlace(board, row, i)) {
				board[row][i] = 1;
				solver(board, row+1);
				board[row][i] = 0;
			}
		}
	}
	
	public static boolean canPlace(int board[][], int row, int col) {
		if (board[row][col] == 2) {
			return false;
		}
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >=0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}

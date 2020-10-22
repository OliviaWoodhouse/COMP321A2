package kattis;
import java.util.*;

public class RadioCommercials_260734701 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 0 || n > 1000000) {
			System.out.println("The number of commercial breaks must be positive and less than 100,000");
			System.exit(0);
		} else if (n == 0) {
			System.out.println(0+"");
			System.exit(0);
		}
		int p = sc.nextInt();
		if (p < 0 || p > 1000) {
			System.out.println("The price of one commercial break must be positive and less than or equal to 1,000");
			System.exit(0);
		}
		int[] breaks = new int[n];
		for (int i = 0; i < n; i++) {
			breaks[i] = sc.nextInt();
			if (breaks[i] > 2000) {
				System.out.println("There must be at most 2000 students listening at a time");
				System.exit(0);
			}
		}
		int[] profits = new int[n];
		for (int i = 0; i < breaks.length; i++) {
			profits[i] = computeProfit(p, breaks[i]);
		}
		System.out.print(solve(profits));
		sc.close();
	}
	
	//Computes the profit given the price of the break and the number of student watching at that time
	public static int computeProfit(int p, int numStudents) {
		int profit = numStudents - p;
		return profit;
	}
	
	//Bottom-up Dynamic Programming solver to produce max profit of all continuous subarrays
	public static int solve(int[] profits) {
		int[] solution  = new int[profits.length+1];
		solution[0] = 0;
		
		for (int i = 1; i < solution.length; i++) {
			solution[i] = Math.max(solution[i-1]+profits[i-1], profits[i-1]);
		}
		int profit = solution[0];
		for (int i = 1; i < solution.length; i++) {
			if (profit < solution[i]) {
				profit = solution[i];
			}
		}
		return profit;
	}
	
}

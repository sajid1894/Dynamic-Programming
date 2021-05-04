package com.sajid.dp.coinchange;

import java.util.Arrays;

public class CoinChange2 {

	public static int coinChange(int[] coins, int amt) {

		int totalCoins = coins.length;

		// Creating array which stores subproblems' solutions
		double[][] arr = new double[totalCoins+1][amt+1];

		// Initialising first row with +ve infinity
		for(int i=0;i<=amt;i++) {
			arr[0][i]=Double.POSITIVE_INFINITY;
		}

		// Initialising first column with 0
		for(int i = 1; i <= totalCoins; i++){
			arr[i][0] = 0;
		}
		
		// Implementing the recursive solution
		for(int i=1; i<=totalCoins; i++) {
			for(int j=1; j<=amt; j++) {
				System.out.print("coin="+coins[i-1]+"\tamt="+j+"\n");
				if(coins[i-1]<=j) {
					arr[i][j] = min(1+arr[i][j-coins[i-1]],arr[i-1][j]);
				}else {
					arr[i][j] = arr[i-1][j];
				}
				System.out.println(Arrays.deepToString(arr).replace("Infinity", "Inf").replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
				System.out.println();
			}
		}
		return (int)arr[totalCoins][amt];
	}
	
	private static double min(double a, double b) {
		if(a<=b)
			return a;
		else
			return b;
	}
	
	public static void main(String[] args) {
		int[] coins = {2,5,4,3};
		int amount = 10;
		System.out.println();
		System.out.println("\n"+CoinChange2.coinChange(coins, amount));
	}

}

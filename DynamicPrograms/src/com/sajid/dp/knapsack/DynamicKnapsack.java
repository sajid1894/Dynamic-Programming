package com.sajid.dp.knapsack;

public class DynamicKnapsack {
	
	private static int[][] findOptimalWeights(int W, int[] val, int[] wt, int n) {
		
		int K[][] = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++) {
			for(int w=0; w<=W; w++) {
				if(i==0 || w==0) {
					K[i][w] = 0;
				}else if(wt[i-1]<=w) {
					K[i][w] = maxVal(K[i-1][w], val[i-1] + K[i-1][w-wt[i-1]]);
				}else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		
		return K;
	}
	
	static int maxVal(int a, int b) {
		return (a>b)?a:b;
	}
	
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(DynamicKnapsack.findOptimalWeights(W, val, wt, n)[n][W]);
	}
	
}

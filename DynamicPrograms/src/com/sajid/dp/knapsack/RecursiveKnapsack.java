package com.sajid.dp.knapsack;

public class RecursiveKnapsack {
	
	static int findOptimalWeight(int W, int[] val, int[] wgt, int n) {
		//boundary condition
		if(n==0||W==0)
			return 0;
		
		//if the weight of i-th element > W then discard
		if(wgt[n-1] > W) {
			return findOptimalWeight(W, val, wgt, n-1);
		}else {
			// Return the maximum of two cases:
	        // (1) nth item included
	        // (2) not included
			return maxVal(val[n-1]+findOptimalWeight(W-wgt[n-1], val, wgt, n-1), 
							findOptimalWeight(W, val, wgt, n-1));
		}
	}
	
	static int maxVal(int a, int b) {
		return (a>b)?a:b;
	}
	
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(RecursiveKnapsack.findOptimalWeight(W, val, wt, n));
	}
	
}

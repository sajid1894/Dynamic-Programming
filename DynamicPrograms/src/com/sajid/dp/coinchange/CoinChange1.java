package com.sajid.dp.coinchange;

/*
Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, 
	there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
*/
public class CoinChange1 {
	
	public static int coinChange(int[] coins, int amount) {
        int table[] = new int[amount+1];
        table[0] = 1;
        for(int i=0;i<coins.length;i++){
        	System.out.print("\n{");
        	System.out.print("coin="+coins[i]+"--->\t");
            for(int j=coins[i]; j<=amount; j++){
            	System.out.print("j="+j);
                table[j] += table[j-coins[i]];
                System.out.print("[");
                for(int k:table){
                    System.out.print(k+" ");
                 }
                System.out.print("]\t");
            }
            System.out.print("}");
        }
        
        return table[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {2,3,4};
		int amount = 6;
		System.out.println();
		System.out.println("\n"+CoinChange1.coinChange(coins, amount));
	}
	
}

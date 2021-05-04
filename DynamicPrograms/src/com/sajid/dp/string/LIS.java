package com.sajid.dp.string;

import java.util.Arrays;

/*
1. If A[i] is smallest among all end 
   candidates of active lists, we will start 
   new active list of length 1.
 

2. If A[i] is largest among all end candidates of 
   active lists, we will clone the largest active 
   list, and extend it by A[i].
 

3. If A[i] is in between, we will find a list with 
   largest end element that is smaller than A[i]. 
   Clone and extend this list by A[i]. We will discard all
   other lists of same length as that of this modified list.
*/
public class LIS {
	
	static int[] longestIncreasingSubsequence(int v[]) {
		
		int tail[] = new int[v.length];
		
		//boundary case
		if(v.length==0)
			return tail;
		
		//always point empty slot as the first element
		int length=1;
		tail[0]=v[0];
		System.out.println("item="+v[0]);
		System.out.println("tail="+Arrays.toString(tail));
		
		
		for(int i=1; i<v.length; i++) {
			System.out.println("item="+v[i]);
			System.out.println(v[i]+">"+tail[length-1]+": "+(v[i]>tail[length-1]));
			if(v[i]>tail[length-1]) {
				// v[i] extends the largest subsequence
				tail[length++] = v[i];
				System.out.println("tail["+length+"]="+v[i]);
			}else {
				// v[i] will extend a subsequence and
                // discard older subsequence
 
                // find the largest value just smaller than
                // v[i] in tail
 
                // to find that value do binary search for
                // the v[i] in the range from begin to 0 +
                // length
				int idx = Arrays.binarySearch(tail, 0, length-1, v[i]);
				System.out.println("Idx from binary search = "+idx);
				
				// binarySearch in java returns negative
                // value if searched element is not found in
                // array
 
                // this negative value stores the
                // appropriate place where the element is
                // supposed to be stored
				if(idx<0)
					idx = -1*idx-1;
				
				// replacing the existing subsequene with
                // new end value
				System.out.println("tail["+idx+"]="+v[i]);
				tail[idx]=v[i];
			}
			System.out.println("tail="+Arrays.toString(tail)+"\n\n");
		}
		return Arrays.copyOfRange(tail, 0, length);
	}
	
	public static void main(String[] args) {
		int v[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int tail[] = LIS.longestIncreasingSubsequence(v);
		System.out.println("Length = "+tail.length);
		System.out.println(Arrays.toString(tail));
	}
	
}

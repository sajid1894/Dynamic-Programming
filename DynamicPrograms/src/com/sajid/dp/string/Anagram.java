package com.sajid.dp.string;

public class Anagram {
	
	/*
	 * total number of Character in ASCII table is 256 (0 to 255). 
	 * 0 to 31(total 32 character ) is called as ASCII control characters (character code 0-31). 
	 * 32 to 127 character is called as ASCII printable characters (character code 32-127). 
	 * 128 to 255 is called as The extended ASCII codes (character code 128-255)
	 */
	static final int NO_OF_CHARS = 256;
	
	static boolean isAnagram(String str1, String str2) {
		// Create two count arrays and initialize
        // all values as 0
		int[] count = new int[NO_OF_CHARS];
		
		// If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length() != str2.length())
          return false;
        if(str1.equals(str2))
        	return true;
		
		// For each character in input strings,
        // increment count in the corresponding
        // count array
		for(int i=0; i<str1.length() && i<str2.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
        
        for(int i: count) {
        	if(i!=0)
        		return false;
        }
        
        return true;
	}
	
	public static void main(String[] args) {
		String str1="geeksquiz";
		String str2="zuiqkeegs";
		System.out.println(Anagram.isAnagram(str1, str2));
	}
	
}

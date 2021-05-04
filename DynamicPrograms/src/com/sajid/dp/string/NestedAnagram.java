package com.sajid.dp.string;

public class NestedAnagram {
	
	static boolean isNestedAnagram(String s, String t) {
		boolean flag = false;
		for(String str1: s.split(" ")) {
			for(String str2: t.split(" ")) {
				if(!flag)
					flag = Anagram.isAnagram(str1, str2);
			}
			if(!flag)
				return false;
			flag = false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s="geeks is for geeks";
		String t="for geeks geekp";
		System.out.println(NestedAnagram.isNestedAnagram(s, t));
	}
	
}

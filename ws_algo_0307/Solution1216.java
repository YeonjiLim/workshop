package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1216 {
	
	public static final int MAXRC = 100;
	public static final int MAXSTC = 200;
	
	public String[] sentences;
	
	public boolean isPalindrome(String str) {
		int start = 0;
		while(start < str.length()/2) {
			for(int j = str.length()-1; j >= str.length()/2; j--) {
				if(str.charAt(start) != str.charAt(j)) {
					return false;
				}
				start++;
			}
		}
		return true;
	}
	
	public int calcMaxLen(String stc) {
		int max = 0;
		for(int i = 0; i < stc.length()-1; i++) {
			for(int j = i+1; j < stc.length(); j++) {
				if(stc.charAt(i) == stc.charAt(j)) {
					if(isPalindrome(stc.substring(i, j+1))) {
						if(max < j-i+1) {
							max = j-i+1;
						}
					}
				}
			}
		}
		return max;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			String[][] map = new String[MAXRC][MAXRC];
			sentences = new String[MAXSTC];
			// input
			for(int row = 0; row < MAXRC; row++) {
				String[] s = br.readLine().split("");
				for(int col = 0; col < MAXRC; col++) {
					map[row][col] = s[col];
				}
			}
			int sIdx = 0;
			StringBuilder sb = new StringBuilder();
			// make lines - h
			for(int row = 0; row < MAXRC; row++) {
				sb.setLength(0);
				for(int col = 0; col < MAXRC; col++) {
					sb.append(map[row][col]);
				}
				sentences[sIdx] = sb.toString();
				sIdx++;
			}
			
			// make lines - v
			for(int col = 0; col < MAXRC; col++) {
				sb.setLength(0);
				for(int row = 0; row < MAXRC; row++) {
					sb.append(map[row][col]);
				}
				sentences[sIdx] = sb.toString();
				sIdx++;
			}
			
			int res = 0;
			for(int i = 0; i < MAXSTC; i++) {
				if(res < calcMaxLen(sentences[i])) {
					res = calcMaxLen(sentences[i]);
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Solution1216 s1216 = new Solution1216();
		s1216.solve();
	}
}

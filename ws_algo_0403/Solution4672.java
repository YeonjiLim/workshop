package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4672 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine().trim();
			int[] arr = new int[26];
			// a 97
			for(int i = 0; i < str.length(); i++) {
				arr[(int)str.charAt(i)-97]++;
			}
			int res = str.length();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] > 1) {
					while(arr[i] > 1) {
						res += arr[i]-1;
						arr[i]--;
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution4672 s4672 = new Solution4672();
		s4672.solve();
	}
}

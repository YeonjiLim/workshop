package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1256 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int K = Integer.parseInt(str);
			str = br.readLine();
			String[] arr = new String[str.length()];
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.substring(i, str.length());
			}
			Arrays.sort(arr);
			System.out.println("#" + tc + " " + arr[K-1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1256 s1256 = new Solution1256();
		s1256.solve();
	}
}

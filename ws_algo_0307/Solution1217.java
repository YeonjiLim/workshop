package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1217 {
	
	public int power(int N, int M) {
		if(M == 0) {
			return 1;
		}
		return N*power(N, M-1);
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int res = power(N, M);
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1217 s1217 = new Solution1217();
		s1217.solve();
	}
}

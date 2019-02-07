package com.ssafy.java.ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution6719 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strT = br.readLine();
		int T = Integer.parseInt(strT);
		for(int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int K = Integer.parseInt(str[1]);
			int[] M = new int[N];
			str = br.readLine().split(" ");
			for(int i = 0; i < M.length; i++) {
				M[i] = Integer.parseInt(str[i]);
			}
			Arrays.sort(M);
			double result = 0.0;
			for(int i = M.length; i > M.length-K; i--) {
				result += (M[i-1] / Math.pow(2, M.length-i+1));				
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	public static void main(String[] args) throws IOException {
		Solution6719 s6719 = new Solution6719();
		s6719.solve();
	}

}

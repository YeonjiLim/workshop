package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3143 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().trim().split(" ");
			String A = input[0] + "@";
			String B = input[1];
			String[] res = A.split(B);
			int result = res.length-1;
			for(int i = 0; i < res.length; i++) {
				result += res[i].length();
			}
			result -= 1;
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3143 s3143 = new Solution3143();
		s3143.solve();
	}
}

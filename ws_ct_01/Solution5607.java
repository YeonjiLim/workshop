package com.ssafy.ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5607 {

	public static final long SUB = 1234567891;
	
	// 팩토리얼 계산하기
	public long facto(long num) {
		long result = 1L;
		for(int i = 1; i <= num; i++) {
			result *= i;
			result %= SUB;
		}
		return result;
	}
		
	// 페르마 소정리로 연산 횟수 줄이기
	public long calculate(long base, long exponent, long mod) {
		long result = 1L;
		
		while(exponent > 0) {
			if(exponent % 2 == 1) {
				result = result * base % mod;
			}
			exponent = exponent >> 1;
			base = (base * base) % mod;
		}
		
		return result;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strT = br.readLine();
		int T = Integer.parseInt(strT);
		for(int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int R = Integer.parseInt(str[1]);
			long resN = facto(N);
			long resR = facto(R) * facto(N-R) % SUB;
			resR = calculate(resR, SUB-2, SUB) % SUB;
			long result = resN * resR % SUB;
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution5607 s5607 = new Solution5607();
		s5607.solve();
	}

}

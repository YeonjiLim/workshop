package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1808 {
	
	public int[] findNumber;
	public int N;
	public int[] numbers;
	
	public void makeDP() {
		
		if(findNumber.length <= 10) {
			for(int i = 0; i < findNumber.length; i++) {
				if(numbers[i] == 1) {
					findNumber[i]++;
				}
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(i < 2 && numbers[i] == 1) {
				findNumber[i] = 1;
			}
			
			if(i >= 2 && numbers[i] == 1) {
				findNumber[i] = 1;
				int tmp = i*i;
				int value = 3;
				while(tmp <= N) {
					findNumber[tmp] = value;
					tmp *= i;
					value+=2;
				}
			}
		}
		
		for(int i = 10; i < findNumber.length; i++) {
			int tmp = i;
			// 0보다 클때 각 자리수가 만들수있는 조합이면 자리수만큼 +해주기
			while(tmp > 0) {				
				if(numbers[tmp%10] == 1) {
					findNumber[i]++;
				}
				tmp /= 10;
			}
			// 돌렸는데 자리수만큼 채워진거 아니면 0으로 바꾸기
			if(findNumber[i] != (int)Math.log10(i)+1) {
				findNumber[i] = 0;
			}
		}
		
		if(findNumber[N] != 0) {
			return;
		}

		for(int first = 2; first <= N; first++) {
			if(findNumber[first] != 0) {
				for(int second = first+1; second <= N/first; second++) {
					if(findNumber[second] != 0) {
						if(findNumber[first*second] == 0) {
							findNumber[first*second] = findNumber[first]+findNumber[second]+1;
						} else if(findNumber[first*second] != 0 && findNumber[first*second] > findNumber[first]+findNumber[second]+1) {	
							findNumber[first*second] = findNumber[first]+findNumber[second]+1;
						}
					}
				}
			}
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			numbers = new int[10];
			for(int i = 0; i < 10; i++) {
				numbers[i] = Integer.parseInt(s[i]);
			}
			str = br.readLine();
			N = Integer.parseInt(str);
			findNumber = new int[N+1];
			makeDP();
			int res = 0;
			if(findNumber[N] == 0) {
				res = -1;
			} else {
				res = findNumber[N]+1;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1808 s1808 = new Solution1808();
		s1808.solve();
	}
}

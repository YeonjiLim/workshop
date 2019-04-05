package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3501 {
	
	public int p, q;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().trim().split(" ");
			p = Integer.parseInt(s[0]);
			q = Integer.parseInt(s[1]);
			int[][] arr = new int[100000][2];
			int index = 1;
			boolean flag = true;
			boolean inWhile = false;
			StringBuilder sb = new StringBuilder();
			sb.setLength(0);
			for(int i = 0; i < 100000; i++) {
				arr[i][1] = -1;
			}
			sb.append(p/q);
			int startIndex = 1;
			if(p/q > 0) {
				startIndex += Math.log10(p/q);
			}
			index = startIndex;
			if(p % q == 0) {
				flag = false;
			} else {
				p %= q;
			}
			while(flag) {
				inWhile = true;
				p *= 10;
				int tmp = p%q;
				int divide = p/q;
				if(arr[tmp][1] == -1) {
					arr[tmp][0] = divide;
					arr[tmp][1] = index;
					sb.append(arr[tmp][0]);
				} else if(arr[tmp][1] != -1){
					if(arr[tmp][0] == divide) {
						sb.insert(arr[tmp][1], "(");
						sb.append(")");
						flag = false;
					} else if(arr[tmp][0] != divide){
						arr[tmp][0] = p/q;
						arr[tmp][1] = index;
						sb.append(arr[tmp][0]);
					}
				}
				if(tmp == 0) {
					flag = false;
				}
				p %= q;
				index++;
			}
			if(inWhile && index >= 2) {
				sb.insert(startIndex, ".");
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3501 s3501 = new Solution3501();
		s3501.solve();
	}
}

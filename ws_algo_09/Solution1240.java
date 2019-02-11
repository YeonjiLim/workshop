package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1240 {
	
	public static final String[] pwCode = {"0001101",
										   "0011001",
										   "0010011",
										   "0111101",
										   "0100011",
										   "0110001",
										   "0101111",
										   "0111011",
										   "0110111",
										   "0001011"};
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String s[] = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] bits = new int[N][M];
			for(int row = 0; row < N; row++) {
				s = br.readLine().split("");
				for(int col = 0; col < M; col++) {
					bits[row][col] = Integer.parseInt(s[col]);
				}
			}
			StringBuilder sb = new StringBuilder();
			StringBuilder saveNum = new StringBuilder();
			int tempR = 0;
			int endC = -1;
			for(int row = 0; row < N; row++) {
				for(int col = M-1; col >= 0; col--) {
					if(bits[row][col] == 1) {						
						endC = col;
						break;
					}
				}
				if(endC >= 0) {
					tempR = row;
					break;
				}
			}
			
			int startC = endC-55;
			for(int col = startC; col <= endC; col++) {
				sb.append(bits[tempR][col]);
				if(sb.length() == 7) {
					for(int find = 0; find < pwCode.length; find++) {
						if(pwCode[find].equals(sb.toString())) {
							saveNum.append(find);
						}
					}
					sb.setLength(0);
				}
			}
			int code = Integer.parseInt(saveNum.toString());
			int tot = 0;
			int tot2 = 0;
			while(code != 0) {
				tot += (code % 10);
				tot2 += (code % 10);
				if(((int)Math.log10(code)+1 < 8) && ((int)Math.log10(code)+1)%2 == 1) {
					tot += (code%10)*2;
				}
				code /= 10;
			}
			if(tot % 10 == 0) {
				System.out.println("#" + tc + " " + tot2);
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Solution1240 s1240 = new Solution1240();
		s1240.solve();
	}

}

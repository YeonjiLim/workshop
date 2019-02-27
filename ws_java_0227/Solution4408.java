package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4408 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine().trim();
			int N = Integer.parseInt(str);
			boolean[][] map = new boolean[N+1][201];
			for(int st = 1; st <= N; st++) {
				String[] s = br.readLine().trim().split(" ");
				int start = (Integer.parseInt(s[0])-1)/2 + 1;
				int end = (Integer.parseInt(s[1])-1)/2 + 1;
				if(start > end) {
					int tmp = start;
					start = end;
					end = tmp;
				}
				for(int i = start; i <= end; i++) {
					map[st][i] = true;
				}
			}
			
			int max = 0;
			for(int col = 1; col < 201; col++) {
				int cnt = 0;
				for(int row = 1; row <= N; row++) {
					if(map[row][col]) {
						cnt++;
					}
				}
				if(max < cnt) {
					max = cnt;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution4408 s4408 = new Solution4408();
		s4408.solve();
	}
}

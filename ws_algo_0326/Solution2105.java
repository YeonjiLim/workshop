package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2105 {
	
	public int N;
	public int[][] map;
	
	public boolean[] eat;
	
	// right-down(0-second), left-down(1-first), left-up(2-second), right-up(3-first)
	public static final int[] moveR = {1, 1, -1, -1};
	public static final int[] moveC = {1, -1, -1, 1};
	public int status;

	public int max;
	
	public void search(int row, int col, int first, int second, int status) {
		if(status > 3) {
			int cnt = 0;
			for(int i = 0; i < 101; i++) {
				if(eat[i]) {
					cnt++;
				}
			}
			if(max < cnt) {
				max = cnt;
			}
			return;
		}
		
		if(status == 0 || status == 2) {
			int nxtR = row;
			int nxtC = col;
			for(int i = 0; i < second; i++) {
				nxtR = nxtR+moveR[status];
				nxtC = nxtC+moveC[status];
				if(nxtR >= 0 && nxtR < N && nxtC >= 0 && nxtC < N) {					
					if(eat[map[nxtR][nxtC]]) {						
						return;
					}
					eat[map[nxtR][nxtC]] = true;
				} else {
					return;
				}
			}
			search(nxtR, nxtC, first, second, status+1);
		} else if(status == 1 || status == 3){
			int nxtR = row;
			int nxtC = col;
			for(int i = 0; i < first; i++) {
				nxtR = nxtR+moveR[status];
				nxtC = nxtC+moveC[status];
				if(nxtR >= 0 && nxtR < N && nxtC >= 0 && nxtC < N) {					
					if(eat[map[nxtR][nxtC]]) {						
						return;
					}
					eat[map[nxtR][nxtC]] = true;
				} else {
					return;
				}
			}
			search(nxtR, nxtC, first, second, status+1);
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			N = Integer.parseInt(str);
			map = new int[N][N];
			max = -1;
			for(int row = 0; row < N; row++) {
				String[] s = br.readLine().split(" ");
				for(int col = 0; col < N; col++) {
					map[row][col] = Integer.parseInt(s[col]);
				}
			}
			
			for(int row = 0; row < N-1; row++) {
				for(int col = 1; col < N-1; col++) {
					int square = (N-1)/2;
					for(int first = 1; first <= square; first++) {
						eat = new boolean[101];
						search(row, col, first, first, 0);
					}
					
					for(int first = 1; first <= N-2; first++) {
						for(int second = 1; second <= N-first-1; second++) {
							if(first != second) {
								eat = new boolean[101];
								search(row, col, first, second, 0);
							}
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution2105 s2105 = new Solution2105();
		s2105.solve();
	}
}

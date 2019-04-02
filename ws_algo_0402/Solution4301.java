package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4301 {
	
	public int N, M;
	public boolean[][] map;
	
	// up, down, right, left
	public int[] moveR = {-2, 2, 0, 0};
	public int[] moveC = {0, 0, 2, -2};
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().trim().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new boolean[N][M];
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(!map[row][col]) {
						for(int d = 0; d < 4; d++) {
							int nxtR = row+moveR[d];
							int nxtC = col+moveC[d];
							if(nxtR >= 0 && nxtR < N && nxtC >= 0 && nxtC < M) {
								map[nxtR][nxtC] = true;
							}
						}
					}
				}
			}
			int res = 0;
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(!map[row][col]) {
						res++;
					}
				}
			}
			System.out.println("#" + tc + " " +res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution4301 s4301 = new Solution4301();
		s4301.solve();
	}
}

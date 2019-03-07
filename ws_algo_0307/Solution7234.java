package com.swexpertacademy;

import java.util.Scanner;

public class Solution7234 {
	
	public int[][] map;
	
	// up1, up2, right1, right2, down1, down2, left1, left2
	public int[] moveR = {-1, -2, 0, 0, 1, 2, 0, 0};
	public int[] moveC = {0, 0, 1, 2, 0, 0, -1, -2};

	public void solve(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			map = new int[N][N];
			for(int bs = 0; bs < B; bs++) {
				int row = sc.nextInt()-1;
				int col = sc.nextInt()-1;
				map[row][col]++;
				for(int d = 0; d < moveR.length; d++) {
					int currR = row+moveR[d];
					int currC = col+moveC[d];
					if(currR >= 0 && currR < N && currC >= 0 && currC < N) {
						map[currR][currC]++;
					}
				}
			}
			
			int max = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(max < map[r][c]) {
						max = map[r][c];
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void main(String[] args){
		Solution7234 s7234 = new Solution7234();
		s7234.solve();
	}
}

package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4013 {
	
	public int K;
	public int[][] magnet;
	
	public void clock(int row) {
		int temp = magnet[row][7];
		for(int col = 7; col >= 1; col--) {
			magnet[row][col] = magnet[row][col-1];
		}
		magnet[row][0] = temp;
	}
	
	public void reverseClock(int row) {
		int temp = magnet[row][0];
		for(int col = 0; col < 7; col++) {
			magnet[row][col] = magnet[row][col+1];
		}
		magnet[row][7] = temp;
	}
	
	public void up(int row, int clk) {
		if(row > 3) {
			return;
		}
		int point = -1;
		for(int r = row; r < 3; r++) {
			if(magnet[r][2] == magnet[r+1][6]) {
				point = r+1;
				break;
			}
		}
		
		if(point == -1) {
			point = 4;
		}
		
		for(int r = row+1; r < point; r++) {
			if(clk == 1) {
				reverseClock(r);
				clk = -1;
			} else {
				clock(r);
				clk = 1;
			}
		}
	}
	
	public void down(int row, int clk) {
		if(row < 0) {
			return;
		}
		int point = -1;
		for(int r = row; r >= 1; r--) {
			if(magnet[r][6] == magnet[r-1][2]) {
				point = r-1;
				break;
			}
		}
		
		for(int r = row-1; r > point; r--) {
			if(clk == 1) {
				reverseClock(r);
				clk = -1;
			} else {
				clock(r);
				clk = 1;
			}
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine().trim();
			K = Integer.parseInt(str);
			magnet = new int[4][8];
			for(int row = 0; row < 4; row++) {
				String[] s = br.readLine().trim().split(" ");
				for(int col = 0; col < 8; col++) {
					magnet[row][col] = Integer.parseInt(s[col]);
				}
			}
			
			for(int idx = 0; idx < K; idx++) {
				String[] s = br.readLine().trim().split(" ");
				int r = Integer.parseInt(s[0]);
				int clk = Integer.parseInt(s[1]);
				if(clk == 1) {
					up(r-1, clk);
					down(r-1, clk);
					clock(r-1);
				} else if(clk == -1) {
					up(r-1, clk);
					down(r-1, clk);
					reverseClock(r-1);
				}
			}
			
			
			int res = 0;
			for(int row = 0; row < 4; row++) {
				if(magnet[row][0] == 1) {					
					res += Math.pow(2, row);
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution4013 s4013 = new Solution4013();
		s4013.solve();
	}
}

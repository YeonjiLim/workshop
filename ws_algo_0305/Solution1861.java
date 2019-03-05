package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1861 {
	
	public int N;
	public int[][] arr;
	
	// up, right, down, left
	public int[] moveR = {-1, 0, 1, 0};
	public int[] moveC = {0, 1, 0, -1};
	
	public int cnt;
	
	public int[] result;
	
	public void dfs(int row, int col) {
		for(int d = 0; d < moveR.length; d++) {
			int currR = row+moveR[d];
			int currC = col+moveC[d];
			// 범위에 맞으면서
			if(currR >= 0 && currR < N && currC >= 0 && currC < N) {
				// 가려는 곳이 현재위치의 숫자보다 정확히 1 클때
				if(arr[currR][currC]-arr[row][col] == 1) {					
					cnt++;
					dfs(row+moveR[d], col+moveC[d]);
				}
			}
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			N = Integer.parseInt(str);
			arr = new int[N][N];
			result = new int[1000001];
			for(int row = 0; row < N; row++) {
				String[] s = br.readLine().split(" ");
				for(int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(s[col]);
				}
			}
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					cnt = 1;
					dfs(row, col);
					// 조건에 맞는 값이 나왔는데
					if(cnt != 0) {
						//해당 길이의 방에 아무것도 없다면
						if(result[cnt] == 0) {
							result[cnt] = arr[row][col];
						} else { // 해당길이에 맞는 방이 있는데
							// 저장되어있는 값보다 지금들어오는 값이 더 작을때
							if(result[cnt] > arr[row][col]) {
								result[cnt] = arr[row][col];
							}
						}
					}
				}
			}
			int maxV = 0;
			for(int i = 0; i < result.length; i++) {
				if(result[i] != 0) {
					maxV = i;
				}
			}
			System.out.println("#" + tc + " " + result[maxV] + " " + maxV);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1861 s1861 = new Solution1861();
		s1861.solve();
	}
}

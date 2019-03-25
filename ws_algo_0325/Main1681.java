package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1681 {
	
	public int[][] map;
	public boolean[] visited;
	public int N, min;
	
	public void dfs(int start, int currPrice, int depth) {
		if(currPrice >= min) {
			return;
		}
		
		if(depth == N-1) {
			if(map[start][0] != 0) {				
				currPrice += map[start][0];
				if(min > currPrice) {
					min = currPrice;
				}
				return;
			} else {				
				return;
			}
		}
		
		for(int c = 1; c < N; c++) {
			if(map[start][c] != 0 && !visited[c]) {
				visited[c] = true;
				dfs(c, currPrice+map[start][c], depth+1);
				visited[c] = false;
			}
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		N = Integer.parseInt(str);
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int r = 0; r < N; r++) {
			String[] s = br.readLine().trim().split(" ");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(s[c]);
			}
		}
		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 0, 0);
		System.out.println(min);
	}
	
	public static void main(String[] args) throws IOException {
		Main1681 m1681 = new Main1681();
		m1681.solve();
	}
}

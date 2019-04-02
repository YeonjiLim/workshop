package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3234 {
	
	public int N;
	public int[] weight;
	
	public int total;
	public int cnt;

	public void dfs(int idx, int[] wgt, int leftTotal, int rightTotal) {
		if(idx == N) {
			cnt += 1;
			return;
		}
		if(leftTotal >= rightTotal+wgt[idx]) {
			dfs(idx+1, wgt, leftTotal+wgt[idx], rightTotal);
			dfs(idx+1, wgt, leftTotal, rightTotal+wgt[idx]);
		} else {
			dfs(idx+1, wgt, leftTotal+wgt[idx], rightTotal);
		}
	}
	
	public void swap(int x, int y) {
		int temp = weight[x];
		weight[x] = weight[y];
		weight[y] = temp;
	}
	
	public void permu(int d) {
		if(d == N) {
			dfs(1, weight, weight[0], 0);
		}
		for(int depth = d; depth < N; depth++) {
			swap(d, depth);
			permu(d+1);
			swap(d, depth);			
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine().trim();
			N = Integer.parseInt(str);
			weight = new int[N];
			cnt = 0;
			String[] s = br.readLine().trim().split(" ");
			for(int w = 0; w < N; w++) {
				weight[w] = Integer.parseInt(s[w]);
				total += weight[w];
			}
			permu(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3234 s3234 = new Solution3234();
		s3234.solve();
	}
}

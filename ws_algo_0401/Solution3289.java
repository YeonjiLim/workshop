package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3289 {
	
	public int N, M;
	
	public int[] parent;
	
	public int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}

	public void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			parent[p1] = p2;
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			parent = new int[N+1];
			for(int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			StringBuilder sb = new StringBuilder();
			sb.setLength(0);
			for(int idx = 0; idx < M; idx++) {
				s = br.readLine().split(" ");
				int first = Integer.parseInt(s[1]);
				int second = Integer.parseInt(s[2]);
				if(s[0].equals("0")) {
					union(first, second);
				} else if(s[0].equals("1")) {
					if(find(parent[first]) == find(parent[second])) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3289 s3289 = new Solution3289();
		s3289.solve();
	}
}

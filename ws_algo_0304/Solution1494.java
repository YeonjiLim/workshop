package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1494 {
	
	public int N;
	public int C;
	
	public int[] checked;
	public boolean[] findElse;
	
	public int limit;
	public int cntCombi; // 조합 절반만 구하면 됨
	
	public int[] x;
	public int[] y;
	
	public long min;
	
	public int calcCombi(int n, int r) {
		if(n <= 1 || n == r || r < 1) {
			return 1;
		}
		return calcCombi(n-1, r-1)+calcCombi(n-1, r);
	}
	
	public void doCombi(int n, int r, int index, int target) {
		if(cntCombi <= limit) {
			if(r == 0) {
				cntCombi++;
				Arrays.fill(findElse, false);
				long totalX = 0L;
				long totalY = 0L;
				for(int i = 0; i < index; i++) {
					totalX += x[checked[i]];
					totalY += y[checked[i]];
					findElse[checked[i]] = true;
				}
				for(int i = 0; i < findElse.length; i++) {
					if(!findElse[i]) {
						totalX -= x[i];
						totalY -= y[i];
					}
				}
				long res = 0L + (totalX*totalX) + (totalY*totalY);
				if(min > res) {
					min = res;
				}
			} else if(n == target) {
				return;
			} else {
				checked[index] = target;
				doCombi(n, r-1, index+1, target+1);
				doCombi(n, r, index, target+1);
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
			checked = new int[N];
			findElse = new boolean[N];
			Arrays.fill(checked, -1);
			x = new int[N];
			y = new int[N];	
			min = Long.MAX_VALUE;
			for(int c = 0; c < N; c++) {
				String[] s = br.readLine().split(" ");
				x[c] = Integer.parseInt(s[0]);
				y[c] = Integer.parseInt(s[1]);
			}
			cntCombi = 0;
			limit = calcCombi(N, N/2)/2;
			doCombi(N, N/2, 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1494 s1494 = new Solution1494();
		s1494.solve();
	}
}

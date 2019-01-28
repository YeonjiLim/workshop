package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution6808 {
	
	public static final int MAX = 9;
	public int[] temp = new int[MAX*2+1];
	public int[] ky = new int[MAX];
	public int[] iy = new int[MAX];
	public int winCnt = 0;
	public int loseCnt = 0;
	public int kyPoint = 0;
	public int iyPoint = 0;
	
	public void swap(int x, int y) {
		int temp = iy[x];
		iy[x] = iy[y];
		iy[y] = temp;
	}
	
	public void cntWin(int choice) {
		if(choice == MAX) {
			for(int i = 0; i < MAX; i++) {
				if(ky[i] > iy[i]) {
					kyPoint += ky[i] + iy[i];
				} else {
					iyPoint += ky[i] + iy[i];
				}
			}
			if(kyPoint > iyPoint) {
				winCnt++;
			} else if(kyPoint < iyPoint){
				loseCnt++;
			}
			kyPoint = 0;
			iyPoint = 0;
			return;
		}
		for(int i = choice; i < MAX; i++) {
			swap(i, choice); // pick
			cntWin(choice+1);
			swap(i, choice);
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			winCnt = 0;
			kyPoint = 0;
			iyPoint = 0;
			loseCnt = 0;
			Arrays.fill(temp, 0);
			for(int i = 0; i < MAX; i++) {
				ky[i] = Integer.parseInt(s[i]);
				temp[ky[i]] = 1;
			}
			int cnt = 0;
			for(int i = 1; i <= MAX*2; i++) { // 인영이 덱
				if(temp[i] == 0) {
					iy[cnt] = i;
					cnt++;
				}
			}
			cntWin(0);
			System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution6808 s6808 = new Solution6808();
		s6808.solve();
	}
}

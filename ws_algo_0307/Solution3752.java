package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3752 {
	
	public int[] numList;
	public int[] result;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int N = Integer.parseInt(str);
			numList = new int[N];
			String[] s = br.readLine().split(" ");
			int resSize = 0;
			for(int i = 0; i < N; i++) {
				numList[i] = Integer.parseInt(s[i]);
				resSize += numList[i];
			}
			result = new int[resSize+1];
			result[0] = 1;
			int cnt = 0;
			for(int n = 0; n < numList.length; n++) {
				cnt = n+1;
				for(int r = 0; r < result.length; r++) {
					if(result[r] != 0 && result[r] <= cnt) {
						if(result[numList[n]+r] == 0) {							
							result[numList[n]+r] = cnt+1;
						}
					}
				}
			}
			int res = 0;
			for(int i = 0; i < result.length; i++) {
				if(result[i] > 0) {
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3752 s3752 = new Solution3752();
		s3752.solve();
	}
}

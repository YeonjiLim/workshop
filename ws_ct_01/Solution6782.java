package com.ssafy.ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6782 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			long N = Long.parseLong(str);
			int count = 0;
			while(N != 2) {
				if(Math.sqrt(N) - (long) Math.sqrt(N) == 0) {
					N = (long) Math.sqrt(N);
					count++;
				} else {
					long temp = N;
					N = ((long) Math.sqrt(N) + 1) * ((long) Math.sqrt(N) + 1) ;
					count += (int) (N - temp);
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	public static void main(String[] args) throws IOException {
		Solution6782 s6782 = new Solution6782();
		s6782.solve();
	}

}

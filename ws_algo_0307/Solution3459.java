package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3459 {
	
	public int state;
	
	public static final int BOB = 1;
	public static final int ALICE = 0;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			long N = Long.parseLong(str);
			state = BOB;
			long find = 1L;
			long tmp = 1L;
			while(find < N) {
				if(state == BOB) {
					tmp *= 4L;
				}
				find += tmp;
				if(state == BOB) {
					state = ALICE;
				} else if(state == ALICE) {
					state = BOB;
				}
			}
			if(state == BOB) {
				System.out.println("#" + tc + " Bob");
			} else if(state == ALICE) {
				System.out.println("#" + tc + " Alice");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution3459 s3459 = new Solution3459();
		s3459.solve();
	}
}

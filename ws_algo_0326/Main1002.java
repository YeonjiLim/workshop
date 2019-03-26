package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1002 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().trim().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int r1 = Integer.parseInt(s[2]);
			int x2 = Integer.parseInt(s[3]);
			int y2 = Integer.parseInt(s[4]);
			int r2 = Integer.parseInt(s[5]);
			
			int denominator = (-2)*x1 + (-2)*y1 + 2*x2 + 2*y2;
			int numerator = r1*r1 - r2*r2 - (x1*x1 + y1*y1 - x2*x2 - y2*y2);
			int res = 0;
			if(denominator == 0 && numerator != 0) {
				System.out.println(res);
			} else if(denominator == 0 && numerator == 0){
				res = -1;
				System.out.println(res);
			}else {
				res = numerator / denominator;
				int res2 = r1*r1 - res*res;
				int res3 = (int) Math.sqrt(res2);
				if(res3 == 0) {
					res = 1;
				} else {
					res = 2;
				}
				System.out.println(res);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1002 m1002 = new Main1002();
		m1002.solve();
	}
}

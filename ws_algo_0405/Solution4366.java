package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4366 {
	
	public int[] binary;
	public int[] ternary;
	
	public boolean find;
	
	public long calculate() {
		long res = 0;
		for(int i = 0; i < binary.length; i++) {
			res += binary[i]*(1 << (binary.length-i-1));
		}
		return res;
	}
	
	public void comp() {
		long r1 = BToD();
		long r2 = TToD();
		if(r1 == r2) {
			find = true;
		}
	}
	
	public long BToD() {
		long res = 0;
		for(int i = 0; i < binary.length; i++) {
			res += binary[i]*(1 << (binary.length-i-1));
		}
		
		return res;
	}
	
	public long TToD() {
		long res = 0;
		for(int i = 0; i < ternary.length; i++) {
			res += ternary[i]*(Math.pow(3, ternary.length-i-1));
		}
		return res;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			find = false;
			String[] s = br.readLine().trim().split("");
			binary = new int[s.length];
			for(int i = 0; i < s.length; i++) {
				binary[i] = Integer.parseInt(s[i]);
			}
			s = br.readLine().trim().split("");
			ternary = new int[s.length];
			for(int i = 0; i < s.length; i++) {
				ternary[i] = Integer.parseInt(s[i]);
			}
			
			for(int i = 1; i < binary.length; i++) {
				binary[i] = (binary[i] == 1 ? 0 : 1);
				for(int ii = 0; ii < ternary.length; ii++) {
					int original = 0;
					if(ii == 0) {
						ternary[ii] = (ternary[ii] == 1 ? 2 : 1);
						comp();
					} else {
						original = ternary[ii];
						for(int idx = 0; idx < 3; idx++) {
							if(idx != original && ternary[ii] != idx) {
								ternary[ii] = idx;
								comp();
							}
							if(find) {
								break;
							}
						}
					}
					if(find) {
						break;
					}
					if(ii == 0) {
						ternary[ii] = (ternary[ii] == 1 ? 2 : 1);
					} else {
						ternary[ii] = original;
					}
				}
				if(find) {
					break;
				}
				binary[i] = (binary[i] == 1 ? 0 : 1);
			}
			
			long res = calculate();
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution4366 s4366 = new Solution4366();
		s4366.solve();
	}
}

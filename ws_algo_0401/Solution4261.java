package com.swexpertacademy;

import java.util.Scanner;

public class Solution4261 {
	
	public String[][] cellphone = { {},
									{},
									{"a", "b", "c"},
									{"d", "e", "f"},
									{"g", "h", "i"},
									{"j", "k", "l"},
									{"m", "n", "o"},
									{"p", "q", "r", "s"},
									{"t", "u", "v"},
									{"w", "x", "y", "z"} };
	
	public void solve() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			String[] sList = s.trim().split("");
			int[] ip = new int[sList.length];
			for(int input = 0; input < ip.length; input++) {
				ip[input] = Integer.parseInt(sList[input]);
			}
			int res = 0;
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int cnt = 0;
				String tp = sc.next();
				String[] tmp = tp.trim().split("");
				int ipidx = 0;
				for(int idx = 0; idx < tmp.length; idx++) {
					for(int find = 0; find < cellphone[ip[ipidx]].length; find++) {
						if(tmp[idx].equals(cellphone[ip[ipidx]][find])) {
							cnt++;
							break;
						}
					}
					ipidx++;
					if(ipidx >= ip.length) {
						break;
					}
				}
				if(cnt == ip.length && cnt == tmp.length) {
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void main(String[] args) {
		Solution4261 s4261 = new Solution4261();
		s4261.solve();
	}
}

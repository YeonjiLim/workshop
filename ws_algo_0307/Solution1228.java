package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1228 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			int N = Integer.parseInt(str);
			ArrayList<Integer> arr = new ArrayList<>();
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < s.length; i++) {
				arr.add(Integer.parseInt(s[i]));
			}
			str = br.readLine();
			int command = Integer.parseInt(str);
			s = br.readLine().split("I");
			for(int i = 1; i < s.length; i++) {
				String[] commands = s[i].trim().split(" ");
				int start = Integer.parseInt(commands[0]);
				int end = Integer.parseInt(commands[1]);
				int comIdx = 2;
				for(int idx = start; idx < start+end; idx++) {
					arr.add(idx, Integer.parseInt(commands[comIdx]));
					comIdx++;
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) throws IOException {
		Solution1228 s1228 = new Solution1228();
		s1228.solve();
	}
}

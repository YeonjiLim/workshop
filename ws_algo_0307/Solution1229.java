package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1229 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			String[] s = br.readLine().split(" ");
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < s.length; i++) {
				arr.add(Integer.parseInt(s[i]));
			}
			str = br.readLine();
			s = br.readLine().split(" ");
			int idx = 0;
			int numbers = 0;
			for(int i = 0; i < s.length; i++) {
				if(s[i].equals("I")) {
					idx = Integer.parseInt(s[i+1]);
					numbers = Integer.parseInt(s[i+2]);
					int curIdx = i+3;
					for(int insert = idx; insert < idx+numbers; insert++) {
						arr.add(insert, Integer.parseInt(s[curIdx]));
						curIdx++;
					}
				} else if(s[i].equals("D")) {
					idx = Integer.parseInt(s[i+1]);
					numbers = Integer.parseInt(s[i+2]);
					for(int delete = 0; delete < numbers; delete++) {
						arr.remove(idx);
					}
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
		Solution1229 s1229 = new Solution1229();
		s1229.solve();
	}
}

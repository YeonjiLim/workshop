package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1225 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			Queue<Integer> queue = new LinkedList<>();
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < s.length; i++) {
				queue.add(Integer.parseInt(s[i]));
			}
			boolean flag = true;
			
			int cycle = 1;
			int sub = 1;
			while(flag) {
				int i = queue.poll();
				int addNewNum = i-sub;
				if(addNewNum <= 0) {
					queue.add(0);
					flag = false;
				} else {
					queue.add(addNewNum);
				}
				cycle++;
				if(cycle == 6) {
					sub = 1;
					cycle = 1;
				} else {					
					sub++;
				}
			}
			System.out.print("#" + tc + " " );
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1225 s1225 = new Solution1225();
		s1225.solve();
	}
}

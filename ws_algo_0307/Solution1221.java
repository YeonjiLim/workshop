package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1221 {
	
	public void solve() throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			int length = Integer.parseInt(s[1]);
			int[] arr = new int[length];
			s = br.readLine().split(" ");
			for(int i = 0; i < length; i++) {
				if(s[i].equals("ZRO")) {
					arr[i] = 0;
				} else if(s[i].equals("ONE")) {
					arr[i] = 1;
				} else if(s[i].equals("TWO")) {
					arr[i] = 2;
				} else if(s[i].equals("THR")) {
					arr[i] = 3;
				} else if(s[i].equals("FOR")) {
					arr[i] = 4;
				} else if(s[i].equals("FIV")) {
					arr[i] = 5;
				} else if(s[i].equals("SIX")) {
					arr[i] = 6;
				} else if(s[i].equals("SVN")) {
					arr[i] = 7;
				} else if(s[i].equals("EGT")) {
					arr[i] = 8;
				} else if(s[i].equals("NIN")) {
					arr[i] = 9;
				}
			}
			
			Arrays.sort(arr);
			System.out.print("#" + tc + " ");
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) {
					System.out.print("ZRO ");
				} else if(arr[i] == 1) {
					System.out.print("ONE ");
				} else if(arr[i] == 2) {
					System.out.print("TWO ");
				} else if(arr[i] == 3) {
					System.out.print("THR ");
				} else if(arr[i] == 4) {
					System.out.print("FOR ");
				} else if(arr[i] == 5) {
					System.out.print("FIV ");
				} else if(arr[i] == 6) {
					System.out.print("SIX ");
				} else if(arr[i] == 7) {
					System.out.print("SVN ");
				} else if(arr[i] == 8) {
					System.out.print("EGT ");
				} else if(arr[i] == 9) {
					System.out.print("NIN ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1221 s1221 = new Solution1221();
		s1221.solve();
	}
}

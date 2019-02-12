package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1247 {
	
	public int min;
	public boolean used[];
	public Stack<Integer> result = new Stack<>();
	int[] posX;
	int[] posY;
	
	public int calculate(Stack<Integer> result) {
		int tot = 0;
		Stack<Integer> tmp = new Stack<>();
		tmp.push(0);
		for(int i = 0; i < result.size(); i++) {
			tmp.push(result.get(i)+2);
		}
		tmp.push(1);
		int size = tmp.size();
		for(int i = 0; i < size-1; i++) {
			int curr = tmp.pop();
			tot = tot + Math.abs(posX[curr]-posX[tmp.peek()]) + Math.abs(posY[curr]-posY[tmp.peek()]);
		}
		return tot;
	}
	
	public void permu(int d, int r) {
		if(d == r) {
			int value = calculate(result);
			if(value < min) {
				min = value;
			}
			return;
		}
		
		for(int i = 0; i < r; i++) {
			if(!used[i]) {
				used[i] = true;
				result.push(i);
				permu(d+1, r);
				result.pop();
				used[i] = false;
			}
		}
		
	}
	
	public void solve() throws IOException {
		// 입력받은뒤에 x, y좌표를 따로 저장하는 두 일차원 배열을 만들어서 
		// 0-회사 1-집 2부터 고객을 넣고, 2부터 고객수 n번만큼 index돌면서 permutation으로 경우의수를 모두 구한다음
		// 해당 index에 있는거 순서대로 회사-고객-고객-집이 되게 거리를 계산한다음
		// 전역변수 min에 저장하고 이거보다 작으면 저장 크면 버림 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int N = Integer.parseInt(str);
			String[] s = br.readLine().split(" ");
			posX = new int[s.length/2];
			posY = new int[s.length/2];
			for(int i = 0; i < s.length/2; i++) {
				posX[i] = Integer.parseInt(s[2*i]);
				posY[i] = Integer.parseInt(s[2*i+1]);
			}
			min = Integer.MAX_VALUE;
			used = new boolean[N];
			permu(0, N);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1247 s1247 = new Solution1247();
		s1247.solve();
	}
}

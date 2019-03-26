package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2283 {
	
	public int N;
	
	public int min(int first, int second) {
		return first < second? first : second;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		N = Integer.parseInt(str);
		
		int[] rgb = new int[3];
		int prevR, prevG, prevB;
		
		for(int i = 0; i < N; i++) {
			prevR = rgb[0];
			prevG = rgb[1];
			prevB = rgb[2];
			String[] s = br.readLine().trim().split(" ");
			rgb[0] = Integer.parseInt(s[0]) + min(prevG, prevB);
			rgb[1] = Integer.parseInt(s[1]) + min(prevR, prevB);
			rgb[2] = Integer.parseInt(s[2]) + min(prevR, prevG);
		}
		
		System.out.println(min(rgb[0], min(rgb[1], rgb[2])));
	}
	
	public static void main(String[] args) throws IOException {
		Main2283 m2283 = new Main2283();
		m2283.solve();
	}
}

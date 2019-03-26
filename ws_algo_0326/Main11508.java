package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11508 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			arr[i] = Integer.parseInt(str);
		}
		Arrays.sort(arr);
		int tot = 0;
		int idx = N-1;
		while(idx >= 0) {
			if(idx == 0) {
				tot += arr[idx];
			} else {				
				tot += arr[idx]+arr[idx-1];
			}
			idx -= 3;
		}
		System.out.println(tot);
	}
	
	public static void main(String[] args) throws IOException {
		Main11508 m11508 = new Main11508();
		m11508.solve();
	}
}

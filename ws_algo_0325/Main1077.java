package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1077 {
	
	public int N, W;
	public Jewel[] arr;
	public int[] bag;
	public int[] weight;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		arr = new Jewel[N];
		bag = new int[10001];
		Arrays.fill(bag, -1);
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			arr[i] = new Jewel(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		int max = 0;
		bag[0] = 0;
		int b = 0;
		while(b <= W) {
			for(int i = 0; i < N; i++) {
				if(b-arr[i].weight >= 0) {
					bag[b] = Math.max(bag[b], bag[b-arr[i].weight] + arr[i].price);
				}
			}
			if(max < bag[b]) {
				max = bag[b];
			}
			b++;
		}
		
		System.out.println(max);
	}
	
	class Jewel {
		int weight;
		int price;
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1077 m1077 = new Main1077();
		m1077.solve();
	}
}

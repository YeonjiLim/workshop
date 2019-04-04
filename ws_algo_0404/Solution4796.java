import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public void solve() throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] heights = new int[N];
			int[] left = new int[N];
			int[] right = new int[N];
			for(int i = 0; i < N; i++) {
				heights[i] = sc.nextInt();
			}
			for(int i = 1; i < heights.length; i++) {
				if(heights[i] > heights[i-1]) {
					left[i] = left[i-1]+1;
				}
			}
			for(int i = heights.length-2; i >= 0; i--) {
				if(heights[i] > heights[i+1]) {
					right[i] = right[i+1]+1;
				}
			}
			int res = 0;
			for(int i = 0; i < heights.length; i++) {
				res += (left[i]*right[i]);
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	public static void main(String[] args) throws IOException {
		Solution s4796 = new Solution();
		s4796.solve();
	}
}
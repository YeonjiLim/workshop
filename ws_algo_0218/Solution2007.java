package wsalgo12_대전3반_1_임연지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int count = 0;
			int curr = 0;
			for(int i = 1; i < str.length(); i++) {
				if(str.charAt(curr) == str.charAt(i)) {
					String s = str.substring(curr, i);
					if(s.equals(str.substring(i, i+(i-curr)))) {
						count = i-curr;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	public static void main(String[] args) throws IOException {
		Solution2007 s2007 = new Solution2007();
		s2007.solve();
	}

}

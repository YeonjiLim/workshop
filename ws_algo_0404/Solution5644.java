import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public int M, A;
	public int[][] map;
	
	public int[] AmoveInfo;
	public int[] BmoveInfo;
	
	public BC[] BCInfo;
	
	// X, up, right, down, left
	public int[] moveR = {0, -1, 0, 1, 0};
	public int[] moveC = {0, 0, 1, 0, -1};
	
	public boolean[] AinBC;
	public boolean[] BinBC;
	public int AinBCcnt, BinBCcnt;
	
	public int max;
	
	public int calculate() {
		int BBCMax = 0;
		int ABCMax = 0;
		if(AinBCcnt == 0 && BinBCcnt == 0) {
			BBCMax = 0;
			ABCMax = 0;
		} else if(AinBCcnt == 0 && BinBCcnt != 0) {
			for(int findBC = 0; findBC < A; findBC++) {
				if(BinBC[findBC]) {
					if(BBCMax < BCInfo[findBC].P) {
						BBCMax = BCInfo[findBC].P;
					}
				}
			}
		} else if(AinBCcnt != 0 && BinBCcnt == 0) {
			for(int findBC = 0; findBC < A; findBC++) {
				if(AinBC[findBC]) {
					if(ABCMax < BCInfo[findBC].P) {
						ABCMax = BCInfo[findBC].P;
					}
				}
			}
		} else if(AinBCcnt != 0 && BinBCcnt != 0) {
			if(AinBCcnt == 1 && BinBCcnt == 1) {
				for(int findBC = 0; findBC < A; findBC++) {
					if(AinBC[findBC] && BinBC[findBC]) {
						ABCMax = BCInfo[findBC].P / 2;
						BBCMax = BCInfo[findBC].P / 2;
					}
					if(AinBC[findBC] && !BinBC[findBC]) {
						ABCMax = BCInfo[findBC].P;
					}
					if(!AinBC[findBC] && BinBC[findBC]) {
						BBCMax = BCInfo[findBC].P;
					}
				}
			} else if(AinBCcnt == 1 && BinBCcnt > 1) {
				int AChoice = -1;
				for(int findBC = 0; findBC < A; findBC++) {
					if(AinBC[findBC]) {
						AChoice = findBC;
					}
				}
				ABCMax = BCInfo[AChoice].P;
				for(int findBC = 0; findBC < A; findBC++) {
					if(BinBC[findBC] && findBC != AChoice && BBCMax < BCInfo[findBC].P) {
						BBCMax = BCInfo[findBC].P;
					}
				}
			} else if(AinBCcnt > 1 && BinBCcnt == 1) {
				int BChoice = -1;
				for(int findBC = 0; findBC < A; findBC++) {
					if(BinBC[findBC]) {
						BChoice = findBC;
					}
				}
				BBCMax = BCInfo[BChoice].P;
				for(int findBC = 0; findBC < A; findBC++) {
					if(AinBC[findBC] && findBC != BChoice && ABCMax < BCInfo[findBC].P) {
						ABCMax = BCInfo[findBC].P;
					}
				}
			} else if(AinBCcnt > 1 && BinBCcnt > 1) {
				int AChoice = -1;
				int tmp = 0;
				for(int findBC = 0; findBC < A; findBC++) {
					if(AinBC[findBC] && ABCMax < BCInfo[findBC].P) {
						ABCMax = BCInfo[findBC].P;
						AChoice = findBC;
					}
				}
				for(int findBC = 0; findBC < A; findBC++) {
					if(BinBC[findBC] && findBC != AChoice && BBCMax < BCInfo[findBC].P) {
						BBCMax = BCInfo[findBC].P;
					}
				}
				int tmpA = ABCMax;
				int tmpB = BBCMax;
				tmp = tmpA+tmpB;
				int BChoice = -1;
				ABCMax = 0;
				BBCMax = 0;
				for(int findBC = 0; findBC < A; findBC++) {
					if(BinBC[findBC] && BBCMax < BCInfo[findBC].P) {
						BBCMax = BCInfo[findBC].P;
						BChoice = findBC;
					}
				}
				for(int findBC = 0; findBC < A; findBC++) {
					if(AinBC[findBC] && findBC != BChoice && ABCMax < BCInfo[findBC].P) {
						ABCMax = BCInfo[findBC].P;
					}
				}
				if(tmp > ABCMax+BBCMax) {
					ABCMax = tmpA;
					BBCMax = tmpB;
				}
			}
		}
		return (BBCMax+ABCMax);
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			map = new int[11][11];
			max = 0;
			String[] s = br.readLine().trim().split(" ");
			M = Integer.parseInt(s[0]);
			A = Integer.parseInt(s[1]);
			AmoveInfo = new int[M];
			BmoveInfo = new int[M];
			BCInfo = new BC[A];
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < M; i++) {
				AmoveInfo[i] = Integer.parseInt(s[i]);
			}
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < M; i++) {
				BmoveInfo[i] = Integer.parseInt(s[i]);
			}
			for(int i = 0; i < A; i++) {
				s = br.readLine().trim().split(" ");
				BCInfo[i] = new BC(Integer.parseInt(s[1]), Integer.parseInt(s[0]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
			}
			int Arow = 1;
			int Acol = 1;
			int Brow = 10;
			int Bcol = 10;
			for(int time = 0; time < M+1; time++) {
			
				AinBC = new boolean[A];
				AinBCcnt = 0;
				if(Arow >= 1 && Arow < 11 && Acol >= 1 && Acol < 11) {
					for(int goBC = 0; goBC < A; goBC++) {
						int distance = Math.abs(BCInfo[goBC].row-Arow) + Math.abs(BCInfo[goBC].col-Acol);
						if(distance <= BCInfo[goBC].C) {
							AinBC[goBC] = true;
							AinBCcnt++;
						}
					}
				}
				BinBC = new boolean[A];
				BinBCcnt = 0;
				// B가 속해있을 수 있는 곳 찾기
				if(Brow >= 1 && Brow < 11 && Bcol >= 1 && Bcol < 11) {
					for(int goBC = 0; goBC < A; goBC++) {
						int distance = Math.abs(BCInfo[goBC].row-Brow) + Math.abs(BCInfo[goBC].col-Bcol);
						if(distance <= BCInfo[goBC].C) {
							BinBC[goBC] = true;
							BinBCcnt++;
						}
					}
				}
				
				max += calculate();
				
				if(time < M) {
					// A, B다음꺼로 넘기기
					Arow = Arow+moveR[AmoveInfo[time]];
					Acol = Acol+moveC[AmoveInfo[time]];
					Brow = Brow+moveR[BmoveInfo[time]];
					Bcol = Bcol+moveC[BmoveInfo[time]];
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	
	class BC {
		int row;
		int col;
		int C;
		int P;
		public BC(int row, int col, int C, int P) {
			this.row = row;
			this.col = col;
			this.C = C;
			this.P = P;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution s5644 = new Solution();
		s5644.solve();
	}
}

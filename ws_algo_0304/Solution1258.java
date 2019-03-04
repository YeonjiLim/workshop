package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution1258 {
	
	public int N;
	public int[][] arr;
	public boolean[][] visited;
	
	ArrayList<Matrix> arrMtx;
	
	public void search(int row, int col) {
		int rSize = 1;
		int cSize = 1;
		for(int r = row+1; r < N; r++) {
			if(arr[r][col] != 0 && !visited[r][col]) {
				visited[r][col] = true;
				rSize = r-row+1;
			} else {
				break;
			}
		}
		for(int c = col+1; c < N; c++) {
			if(arr[row][c] != 0 && !visited[row][c]) {
				visited[row][c] = true;
				cSize = c-col+1;
			} else {
				break;
			}
		}
		
		for(int r = row; r < row+rSize; r++) {
			for(int c = col; c < col+cSize; c++) {
				if(!visited[r][c]) {
					visited[r][c] = true;
				}
			}
		}
		
		arrMtx.add(new Matrix(rSize, cSize, rSize*cSize));
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			N = Integer.parseInt(str);
			arr = new int[N][N];
			visited = new boolean[N][N];
			arrMtx = new ArrayList<>();
			for(int row = 0; row < N; row++) {
				String[] s = br.readLine().split(" ");
				for(int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(s[col]);
				}
			}
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					if(arr[row][col] != 0 && !visited[row][col]) {
						visited[row][col] = true;
						search(row, col);
					}
				}
			}
			
			Collections.sort(arrMtx, new CompareMtx());
			
			System.out.print("#" + tc + " " + arrMtx.size() + " ");
			for(int i = 0; i < arrMtx.size(); i++) {
				System.out.print(arrMtx.get(i).rCnt + " " + arrMtx.get(i).cCnt + " ");
			}
			System.out.println();
		}
	}
	
	class CompareMtx implements Comparator<Matrix> {

		@Override
		public int compare(Matrix o1, Matrix o2) {
			if(o1.size > o2.size) {
				return 1;
			} else if(o1.size < o2.size) {
				return -1;
			} else {
				if(o1.rCnt > o2.rCnt) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		
	}
	
	class Matrix {
		int rCnt;
		int cCnt;
		int size;
		public Matrix(int rCnt, int cCnt, int size) {
			this.rCnt = rCnt;
			this.cCnt = cCnt;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1258 s1258 = new Solution1258();
		s1258.solve();
	}
}

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1080 {
	static int N,M;
	static int A[][],B[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		if(N<3 || M<3) {
			System.out.println("-1");
			return ;
		}
		A= new int[N][M];
		B= new int[N][M];
		for(int i=0;i<N;i++) {
			String str2=br.readLine();
			for(int j=0;j<M;j++) {
				int a=str2.charAt(j)-'0';
				A[i][j]=a;
			}
		}

		for(int i=0;i<N;i++) {
			String str3=br.readLine();
			for(int j=0;j<M;j++) {
				B[i][j]=str3.charAt(j)-'0';
			}
		}


		int cnt=0;
		for(int j=0;j<N;j++) {
			for(int i=0;i<M;i++) {
				if(A[j][i] != B[j][i]) {
					if(change(j,i)) {
						cnt++;
					}else {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	static boolean change(int y,int x) {
		if(y+2>=N || x+2>=M)
			return false;

		for(int i=y;i<=y+2;i++) {
			for(int j=x;j<=x+2;j++) {
				A[i][j]=1-A[i][j];
			}
		}


		return true;
	}

	static void print(int map[][]) {
		for(int a=0;a<N;a++) {
			for(int b=0;b<M;b++) {
				System.out.print(map[a][b]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

package BAEKJOON;

import java.util.Scanner;

public class Main18248 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int M=s.nextInt();
		int map[][] =new int[N][M];

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=s.nextInt();
			}
		}
		
		for(int i=0;i<N;i++) {
			int count=0;
			for(int j=i+1;j<N;j++) {
				boolean c1=false,c2=false;
				for(int k=0;k<M;k++) {
					if(map[i][k]==1 && map[j][k]==0)
						c1=true;
					if(map[i][k]==0 && map[j][k]==1)
						c2=true;
					if(c1 && c2) {
						System.out.println("NO");
							return ;
					}
				}
			}
		}
		System.out.println("YES");

	}

}

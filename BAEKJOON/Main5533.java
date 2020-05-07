package BAEKJOON;

import java.util.Scanner;

public class Main5533 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int map[][] = new int[N][3];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				map[i][j]=s.nextInt();
			}
		}
		
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<3;j++) {
				int check=map[i][j];
				for(int k=0;k<N;k++) {
					if(k == i)
						continue;
					if(check == map[k][j]) {
						check=0;
						break;
					}
				}
				sum+=check;
			}
			System.out.println(sum);
		}
		
		
	}

}

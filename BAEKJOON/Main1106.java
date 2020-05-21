package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int C=s.nextInt();
		int Arr[][] = new int[C][2];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<C;i++) {
			for(int j=0;j<2;j++) {
				Arr[i][j]=s.nextInt();
			}
		}
		int cnt=1;
		int money=0;
		int people=0;
		boolean check=true;
		while(true) {
			
			for(int i=0;i<C;i++) {
				money+=(Arr[i][0]*cnt);
				people+=(Arr[i][1]*cnt);
				if(people==N) {
					check=false;
					break;
				}
			}
			if(!check)
				break;
		}
		System.out.println(money);
	}

}

package BAEKJOON;

import java.util.Scanner;

public class Main3036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int circle[] =new int[N];
		for(int i=0;i<N;i++) {
			circle[i]=s.nextInt()*2;
		}
		for(int i=1;i<N;i++) {
			System.out.println(circle[0]/circle[i]+"/"+circle[i]/circle[0]);
		}
	}

}

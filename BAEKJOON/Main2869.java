package BAEKJOON;

import java.util.Scanner;

//달팽이는 올라가고 싶다(이분탐색 기준은 날짜)
public class Main2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A=s.nextInt();
		int B=s.nextInt();
		int V=s.nextInt();
		int right=V;
		int left=1;
		int run=A-B;
		int result=V-A;
		int res=0;
		boolean check=false;
		while(left<=right) {
			int mid=(left+right)/2;
			if(result - (mid*run) <0) {
				right=mid-1;
			}else {
				
				res=mid;
				if(result - (mid*run) == 0)
					check= true;
				left=mid+1;
			}
		}
	
		System.out.println(res+1);
		
		
	}

}

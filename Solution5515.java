import java.util.Scanner;

public class Solution5515 {
	static int month[]={31,29,31,30,31,30,31,31,30,31,30,31};
	static int day[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int t=1;t<=T;t++) {
			int m=s.nextInt();
			int d=s.nextInt();
			day = new int[367];
			int da=4;
			for(int i=1;i<367;i++) {
				day[i]=(da)%7;
				da++;
			}
			int sum=0;
			for(int i=0;i<m-1;i++){
				sum+=month[i];
			}
			sum+=d;
			System.out.println("#"+t+" "+day[sum]);
			
			

		}
	}

}

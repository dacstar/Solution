package SWEA;
import java.util.Scanner;
public class Solution1209 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int T=s.nextInt();
			int arr[][] = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j]=s.nextInt();
				}
			}
			int max=0;
			for(int i=0;i<100;i++) {
				int sum1=0;
				int sum=0;
				for(int j=0;j<100;j++) {
					sum+=arr[i][j];
				}
				for(int j=0;j<100;j++) {
					sum1+=arr[j][i];
				}
				max=Math.max(max, Math.max(sum1, sum));
			}
			System.out.println("#"+t+" "+max);
		}
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Solution1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			int max=-1;
			int min=100000;
			int arr[] =new int[10];
			for(int i=0;i<10;i++) {
				int num=s.nextInt();
				arr[i]=num;
			}
			double sum=0;
			Arrays.sort(arr);
			for(int i=1;i<9;i++) {
					sum+=arr[i];
			}
			
			System.out.println("#"+test_case+" "+(int)Math.round(sum/8));
		}

	}

}

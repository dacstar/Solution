import java.util.Arrays;
import java.util.Scanner;

public class Solution1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			int N=s.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i]=s.nextInt();
			
			Arrays.sort(arr);
			System.out.print("#"+t+" ");
			for(int i=0;i<N;i++)
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}

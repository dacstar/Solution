import java.util.Arrays;
import java.util.Scanner;

public class Solution9940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=s.nextInt();
			int arr[] = new int[N];
			Arrays.sort(arr);
			
			for(int i=0;i<N;i++) {
				arr[i]=s.nextInt();
			}
			boolean check=false;
			for(int i=0;i<N;i++) {
				if(arr[i] != i+1) {
					check=true;
					break;
				}
			}
			if(check) {
				System.out.println("#"+t+" "+"No");
			}else {
				System.out.println("#"+t+" "+"Yes");
			}
		}
	}

}

import java.util.Scanner;

public class Solution1976 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int arr[]=new int[4];
			for(int i=0;i<4;i++) {
				arr[i]=s.nextInt();
			}
			int hour=0;
			if(arr[0]+arr[2]>=13) {
				hour=(arr[0]+arr[2])%13+1;
			}else {
				hour=(arr[0]+arr[2])%13;
			}
			if(arr[1]+arr[3]>59)
				hour++;
			int min=(arr[1]+arr[3])%60;
			System.out.println("#"+test_case+" "+hour+" "+min);
		}
	}

}

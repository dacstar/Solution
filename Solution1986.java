import java.util.Scanner;

public class Solution1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=s.nextInt();
			int sum=0;
			for(int i=1;i<=N;i++) {
				int number=i;
				if(number%2==0) {
					sum-=number;
				}else {
					sum+=number;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

}

import java.util.Scanner;

public class Solution1970 {
	static int units[] = {50000,10000,5000,1000,500,100,50,10};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=s.nextInt();
			System.out.println("#"+test_case+" ");
			for(int u: units) {
				System.out.print(N/u+" ");
				N%=u;
			}
			System.out.println();
			
		}

	}

}

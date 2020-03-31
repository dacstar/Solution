import java.util.Scanner;

public class Solution2007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T  = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			String str=s.next();
			int result=0;
			for(int i=1;i<str.length();i++) {
				if(str.charAt(i) == str.charAt(result)) {
					result++;
				}
			}
			int sum=str.length()-result;
			System.out.println("#"+test_case+" "+sum);
		}

	}

}

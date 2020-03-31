import java.util.Scanner;

public class Solution8821 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int T =s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			String str=s.next();
			boolean check[] = new boolean[str.length()];
			int sum=0;
			for(int i=0;i<str.length();i++) {
				int a=str.charAt(i)-'0';
				if(!check[a]) {
					check[a]=true;
					sum++;
				}else {
					check[a]=false;
					sum--;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

}

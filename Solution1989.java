import java.io.BufferedReader;
import java.util.Scanner;

public class Solution1989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T  = s.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) {
			String str=s.next();
			char []ch=str.toCharArray();
			if(ch[0] == ch[ch.length-1]) {
				System.out.println("#"+test_case+" "+1);
			}else {
					System.out.println("#"+test_case+" "+0);
			}
		}
	}
}

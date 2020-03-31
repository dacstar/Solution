import java.util.Scanner;
import java.util.Stack;

public class Solution8500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int K=s.nextInt();
			Stack<Integer> st = new Stack<Integer>();
			for(int i=0;i<K;i++) {
				int num=s.nextInt();
				if(num==0) {
					st.pop();
				}else {
					st.add(num);
				}
			}
			int sum=0;
			while(!st.isEmpty()) {
				sum+=st.pop();
			}
			System.out.println("#"+test_case+" "+sum);
			
			
			
		}
	}

}

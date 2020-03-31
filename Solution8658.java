import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			String []str=br.readLine().split(" ");
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			for(int i=0;i<str.length;i++) {
				int sum=0;
				for(int j=0;j<str[i].length();j++) {
					sum+=str[i].charAt(j)-'0';
				}
				max=Math.max(sum, max);
				min=Math.min(sum, min);
			}
			
			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}

}

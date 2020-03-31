import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9317 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {

			int N=Integer.parseInt(br.readLine());
			String str[] = new String[2];
			str[0]=br.readLine();
			str[1]=br.readLine();
			int count=0;
			for(int i=0;i<N;i++) {
				if(str[0].charAt(i) ==str[1].charAt(i))
					count++;
			}
			System.out.println("#"+test_case+" "+count);


		}


	}

}

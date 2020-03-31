import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution8741 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			String str[]=br.readLine().split(" ");
			char answer[] = new char[str.length];
			for(int k=0;k<str.length;k++) {
				for(int j=0;j<1;j++) {
					 answer[k]=(char) (str[k].charAt(j)-32);
					
				}
			}
			System.out.print("#"+i+" ");
			for(int j=0;j<answer.length;j++) {
				System.out.print(answer[j]);
			}
		}


	}

}

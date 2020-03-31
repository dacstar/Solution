import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution5577 {

	static int N;
	static int RBY[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		RBY = new int[N];
		for(int i=0;i<N;i++) {
			RBY[i]=Integer.parseInt(br.readLine());
		}
		int cnt=0;
		int MIN=Integer.MAX_VALUE;
		for(int i=0;i<N;i++){
			int origin=RBY[i];
			for(int j=1;j<4;j++){
				if(RBY[i]!=j){
					RBY[i]=j;
				}
				
				
			}
			
		}
		System.out.println(MIN);

	}

}

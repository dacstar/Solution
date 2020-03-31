import java.util.Arrays;
import java.util.Scanner;

public class Solution5576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int K[] =new int[10];
		int W[] =new int[10];
		for(int i=0;i<10;i++) {
			K[i]=s.nextInt();
		}
		
		for(int i=0;i<10;i++) {
			W[i]=s.nextInt();
		}
		Arrays.sort(K);
		
		Arrays.sort(W);
		int S=W[9]+W[8]+W[7];
		System.out.println(K[9]+K[8]+K[7]+" "+S);

	}

}

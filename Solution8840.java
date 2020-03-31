import java.math.BigInteger;
import java.util.Scanner;

public class Solution8840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			BigInteger i = s.nextBigInteger();
			System.out.println("#"+test_case+" "+i.divide(BigInteger.valueOf(2)).pow(2));
		}

	}

}

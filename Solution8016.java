import java.math.BigInteger;
import java.util.Scanner;

public class Solution8016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int T =s.nextInt();
		for(int i=1;i<=T;i++) {
			BigInteger n = new BigInteger(s.next());
	
			BigInteger left=n.pow(2).multiply(BigInteger.valueOf(2)).subtract(n.multiply(BigInteger.valueOf(4))).add(BigInteger.valueOf(3));
			BigInteger right=n.pow(2).multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(1));
			
			System.out.println("#"+i+" "+left+" "+right);
		}

	}

}

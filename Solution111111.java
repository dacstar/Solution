import java.math.BigInteger;

public class Solution111111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		BigInteger big = new BigInteger("1");
		for(int i=n;i>=1;i--) {
			big=big.multiply(BigInteger.valueOf(i));
		}
		System.out.println(big);
		String str=big+"";
		int answer=0;
		big = big.divide(BigInteger.valueOf(5));
		System.out.println(big);
		answer=big.intValue();
		System.out.println(answer);
	}

}

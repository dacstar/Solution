
public class Solution_greedy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="JEROEN";
		int result=0;
		char na[]=name.toCharArray();
		char alpabet[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int start;
		for(int i=0;i<name.length();i++) {
			start=0;
			int sum=10000;
			int index=findindex(alpabet, name.charAt(i));
			sum=Math.min(sum, startvalue(start, index));
			sum=Math.min(sum, endvalue(start, index)+1);
			System.out.println(sum);
			result+=sum;
			start=index;
		}
		System.out.println(result);
	}

	static int findindex(char alpabet[],char al) {

		for(int i=0;i<alpabet.length;i++) {

			if(alpabet[i]==al)
				return i;

		}
		return -1;
	}

	static int startvalue(int start,int index) {
		
		if(index==start)
			return 0;
		
		int num=Math.abs(start-index);
	


		return num;
	}
	
	

	static int endvalue(int start,int index) {
		int move=0;
		
		
		int value=25;
	


		return Math.abs(value-index);
	}


}

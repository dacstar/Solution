package Programmers;

public class Solution_주식가격 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[]= {1,2,3,2,3};
		int answer[] = new int[prices.length];
		
		for(int i=0;i<prices.length-1;i++) {
			for(int j=i;j<prices.length;j++) {
					answer[i]=j-i;
					if(prices[i]>prices[j]) break;
			}
		}
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
			
		}
	}

}

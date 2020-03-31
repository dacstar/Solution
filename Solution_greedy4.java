import java.util.Arrays;

public class Solution_greedy4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []people= {70,50,80,50};
		int limit=100;
		 Arrays.sort(people);
		 int answer = 0;
	        int index = people.length - 1;
	        for(int i = 0; i <= index; i++, answer++) 
	            while(index > i && people[i] + people[index--] > limit) 
	                answer++;
		
	

	}

}

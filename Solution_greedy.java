
public class Solution_greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int lost[] = {2,4};
		int reserve[] = {1,3,5};
		int people[] = new int[5];
		int answer=5-lost.length;
		for(int i=0;i<lost.length;i++) {
			people[lost[i]-1]--;
		}
		for(int i=0;i<reserve.length;i++) {
			people[reserve[i]-1]++;
		}
		
		for(int i=0;i<people.length;i++) {
			if(people[i]==-1) {
				if(i-1>=0 && people[i-1]==1) {
					people[i]++;
					people[i-1]--;
					answer++;
				}else if(i+1<people.length && people[i+1]==1) {
					people[i]++;
					people[i+1]++;
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
		
		

	}

}

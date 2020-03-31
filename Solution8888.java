import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution8888 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tt= Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=Tt;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int T=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());

			int score[] =new int[T];
			int arr[][] = new int[N][T];
			int man[] = new int[N];
			int total[]=new int[N];
			PriorityQueue<People> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int sum=0;
				for(int j=0;j<T;j++) {
					int value=Integer.parseInt(st.nextToken());
					if(value ==0)
						score[j]++;
					else {
						sum++;
					}
					arr[i][j]=value;
				}
				man[i]=sum;
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<T;j++) {
					if(arr[i][j]==1)
						total[i]+=score[j];
				}
			}

			for(int i=0;i<N;i++) {
				int val=total[i];
				int count=0;
				int minnumber=0;
				int highscore=0;
				for(int j=0;j<N;j++) {
					if(i==j)
						continue;
					if(val==total[j]) {
						if(man[j]>man[i])
							count++;
						else if(man[j]==man[i]) {
							if(i>j)
								minnumber++;
						}
					}else if(total[j]>val) {
						highscore++;
					}

				}
				pq.add(new People(i+1,count+minnumber+highscore));
			}
			int grade=1;
			while(!pq.isEmpty()) {
				People people=pq.poll();
				if(people.number==P) {
					System.out.println("#"+test_case+" "+total[people.number-1]+" "+grade);
					break ;
				}else {
					grade++;
				}
			}
		}
	}

	static class People implements Comparable<People>{
		int number;
		int score;
		People(int number,int score){
			this.number=number;
			this.score=score;
		}
		@Override
		public int compareTo(People o) {
			// TODO Auto-generated method stub
			return this.score > o.score ? 1 : -1;
		}
	}

}

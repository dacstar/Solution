import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class 실패율 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int stages[] = { 4,4,4,4,4 };
		int result[] = new int[N];
		double people=stages.length;
		
		PriorityQueue<XY> pq = new PriorityQueue<>();
		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
		for(int i=1;i<=N;i++) {
			double clear=0.0;
			double lose=0.0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j] == i) {
					lose++;
				}else {
					clear++;
				}
			}
			double sum=0;
			if(lose == 0.0) {
				sum=0;
			}else {
			sum=(lose/people);
			}
			people-=lose;
			pq.add(new XY(i,sum));
			
		}
		int cnt=0;
		while(!pq.isEmpty()) {
			XY xy=pq.poll();
			result[cnt++]=xy.number;
		}
		
	}
	
	public static class XY implements Comparable<XY>{
		int number;
		double lose;
			XY(int number,double lose){
				this.number=number;
				this.lose=lose;
			}
			@Override
			public int compareTo(XY o) {
				// TODO Auto-generated method stub
				if(this.lose == o.lose) {
					return this.number > o.number ? 1 : -1;
				}
				
				return this.lose > o.lose ? -1 : 1;
			}
	}

}

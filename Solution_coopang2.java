
public class Solution_coopang2 {
	static int N,M,T,K;
	static int result=0;
	static int arr[];
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=4;
		M=7;
		T=2;
		K=4;
		arr =new int[N];
		check = new boolean[N];

		DFS(0,0,0);
		System.out.println(result);
	}

	static void DFS(int start,int sum,int time) {
		
		
		if(start==N) {
			if(sum==M) {
				result++;
				return ;
			}
			return ;
		}
		if(time <= T) {
			if(sum>K) {
				return;
			}
			if(time ==T) {
				time=0;
			}
		}

	


		for(int i=0;i<=M;i++) {
			if(i<=K) {
			DFS(start+1,sum+i,time+1);
			}
		}


	}

}

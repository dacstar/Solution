import java.util.Scanner;

public class Solution16987 {
	static int N,result;
	static Egg[] egg;
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		result=0;
		egg = new Egg[N];
		check = new boolean[N];
		for(int i=0;i<N;i++) {
			egg[i] = new Egg(s.nextInt(),s.nextInt());
		}
		DFS(0,0);
		System.out.println(result);

	}

	static void DFS(int depth,int res) {
		boolean visit=false;
		if(depth == N) {
			result=Math.max(res, result);
			return ;
			
		}
		
		if(egg[depth].s<=0)
			DFS(depth+1,res);
		
		
		for(int i=0;i<N;i++) {
			int eggcount=0;
			
			if(!check[i] && i !=depth && egg[depth].s>0) {
				egg[i].s-=egg[depth].w;
				egg[depth].s-=egg[i].w;
				visit=true;
				if(egg[i].s<=0) {
					check[i]=true;
					eggcount++;
				}
				if(egg[depth].s<=0) {
					check[depth]=true;
					eggcount++;
				}
				
				DFS(depth+1,res+eggcount);
				
				if(egg[i].s<=0)
					check[i]=false;
				if(egg[depth].s<=0)
					check[depth]=false;
				
				egg[i].s+=egg[depth].w;
				egg[depth].s+=egg[i].w;
				
				
					
				
				
			}
		}
		if(!visit) {
			DFS(N,res);
		}


	}

	static class Egg{
		int s;
		int w;
		Egg(int s,int w){
			this.s=s;
			this.w=w;
		}
	}

}

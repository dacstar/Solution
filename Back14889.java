import java.util.Scanner;

public class Back14889 {
	static int N;
	static int team[];
	static boolean visit[];
	static int map[][];
	static int res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		res=100000;
		visit = new boolean[N];
		team = new int[N];
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=s.nextInt();
			}
		}
		
		DFS(0);
		System.out.println(res);
	}

	static void DFS(int depth) {
		if(depth == N) {
			if(check()) {
				int start=sum(0);
				int link=sum(1);
//				System.out.println();
				res = Math.min(res, Math.abs(start-link));
			}
			
			return ;

		}




		for(int i=0;i<N;i++) {
			
			team[depth]=i;
			DFS(depth+1);
		}

	}

	static int sum(int name) {
		int result=0;
		boolean check[] = new boolean[N];
//		System.out.print(name+":"+" ");
		for(int i=0;i<N;i++) {
			if(team[i]==name) {
				check[i]=true;
//				System.out.print(i+" ");	
			}
		}

		for(int i=0;i<N;i++) {
			if(check[i]) {
				for(int j=0;j<N;j++) {
					if(check[j])
						result+=map[i][j];
				}
			}
		}
		
		return result;

	}

	static boolean check() {
		int start;
		int link;
		start=0;
		link=0;

		for(int i=0;i<N;i++) {
			if(team[i]==0)
				start++;
			else {
				link++;
			}
		}

		if(start != N/2)
			return false;

		return true;
	}

}

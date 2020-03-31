import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution16235 {
	static int dy[]= {1,-1,0,0,1,-1,1,-1};
	static int dx[]= {0,0,1,-1,1,-1,-1,1};
	static int N,M,K,food;
	static int A[][],Food[][];
	static ArrayList<Tree> livetree;
	static ArrayList<Tree> deadtree;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		Food = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				Food[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				A[i][j]=5;
			}
		}
		livetree = new ArrayList<>();
		deadtree = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			livetree.add(new Tree(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		PriorityQueue<Tree> tree = new PriorityQueue<>();
		while(K>0) {
			for(int i=0;i<livetree.size();i++) {
				Tree tr=livetree.get(i);
				tree.add(tr);
			}
			livetree = new ArrayList<>();
			while(!tree.isEmpty()) {
				Tree tr=tree.poll();
				if(A[tr.r][tr.c]>=tr.age) {
					A[tr.r][tr.c]-=tr.age;
					livetree.add(new Tree(tr.r,tr.c,tr.age+1));
				}else {
					deadtree.add(tr);
				}
			}
			for(int i=0;i<deadtree.size();i++) {
				Tree tr=deadtree.get(i);
				A[tr.r][tr.c]+=(tr.age/2);
			}
			deadtree = new ArrayList<>();
			int livesize=livetree.size();
			for(int i=0;i<livesize;i++) {
				Tree tr = livetree.get(i);
				if(tr.age%5 == 0) {
					for(int d=0;d<dy.length;d++) {
						int tmpr=tr.r+dy[d];
						int tmpc=tr.c+dx[d];
						if(checkedge(tmpr,tmpc)) {
							livetree.add(new Tree(tmpr,tmpc,1));
						}
					}
				}
			}

			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					A[i][j]+=Food[i][j];
				}
			}
			K--;
		}

		System.out.println(livetree.size());




	}

	static boolean checkedge(int r,int c) {
		if(r<1 || r>N || c<1 || c>N) {
			return false;
		}
		return true;
	}


	static class Tree implements Comparable<Tree>{
		int r;
		int c;
		int age;
		Tree(int r,int c,int age) {
			this.r=r;
			this.c=c;
			this.age=age;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return o.age > this.age ? -1 : 1;
		}
	}

}

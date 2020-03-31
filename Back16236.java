import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Back16236 {
	static int N,age,res,count;
	static int [][]sea;
	static int dy[]= {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static boolean check[][];
	static int shark[];
	static PriorityQueue<Pish> pq;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		N=s.nextInt();
		pq = new PriorityQueue<>();
		age=2;
		res=0;
		count=0;
		shark = new int[2];
		sea = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int a = s.nextInt();
				if(a==9) {
					shark[0]=i;
					shark[1]=j;
				}
				sea[i][j]=a;
			}
		}

		while(true) {
			check = new boolean[N][N];
			BFS(shark[0],shark[1]);
			if(pq.size()==0) {
				break;
			}else {
				Eat();
			}
		}
		System.out.println(res);


	}

	static void BFS(int y,int x) {
		Queue<Pish> q = new LinkedList<>();
		check[y][x]=true;
		q.add(new Pish(y,x,0));
		while(!q.isEmpty()) {
			Pish pish=q.poll();
			for(int d=0;d<4;d++) {
				int tmpy=dy[d]+pish.y;
				int tmpx=dx[d]+pish.x;
				if(check(tmpy, tmpx) && sea[tmpy][tmpx]<=age) {
					if(sea[tmpy][tmpx] !=0 && sea[tmpy][tmpx] < age) {
						check[tmpy][tmpx]=true;
						pq.add(new Pish(tmpy,tmpx,pish.cnt+1));
						continue;
					}
					check[tmpy][tmpx]=true;
					q.add(new Pish(tmpy,tmpx,pish.cnt+1));
				}

			}
		}

	}

	static boolean check(int y,int x) {
		if(y <0 || y>=N || x<0 || x>=N || check[y][x])
			return false;


		return true;
	}

	static void Eat() {
		Pish pish=null;
		while(!pq.isEmpty()) {
			pish=pq.poll();
			if(sea[pish.y][pish.x] < age)
				break;
		}
		sea[pish.y][pish.x]=0;
		sea[shark[0]][shark[1]]=0;
		count++;
		res+=pish.cnt;
		if(count==age) {
			count=0;
			age++;
		}
		shark[0]=pish.y;
		shark[1]=pish.x;
		while(!pq.isEmpty())
			pq.poll();
	}



	static class Pish implements Comparable<Pish>{
		int y;
		int x;
		int cnt;
		Pish(int y,int x,int cnt){
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Pish o) {
			// TODO Auto-generated method stub
			if(this.cnt==o.cnt) {
				if(this.y > o.y) {
					return this.y > o.y ? 1 : -1;
				}else if(this.y == o.y) {
					return this.x > o.x ? 1 : -1;
				}
			}

			return this.cnt > o.cnt ? 1 : -1 ;
		}
	}

}

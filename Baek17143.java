import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek17143 {
	static int map[][];
	static int R,C,M;
	static int sum;
	static Shark[] shark;
	static int dir[]= {0,-1,1,1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[R][C];
		sum=0;
		shark = new Shark[10001];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int speed=Integer.parseInt(st.nextToken());
			int dir=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			map[r-1][c-1]=value;
			shark[value]=new Shark(r-1,c-1,speed,dir,value);
		}

		for(int k=0;k<C;k++) {
			for(int r=0;r<R;r++) {
				if(map[r][k]>0) {
					shark[map[r][k]]=null;
					sum+=map[r][k];
					map[r][k]=0;
					break;
				}
			}
			move();
		}




		System.out.println(sum);
	}

	static void move() {

		for(int i=0;i<shark.length;i++) {
			if(shark[i]==null)
				continue;
			Shark sh=shark[i];
			int r=sh.r;
			int c=sh.c;
			int d=sh.dir;
			int value=sh.value;
			int speed=sh.speed;
			map[r][c]=0;
			if(d==1 || d==2) {
				while(speed>0) {
					r+=dir[d];
					if(r <0  || r>=R) {
						r-=dir[d];
						if(d==1)
							d=2;
						else
							d=1;
						continue;
					}
					speed--;
				}
				shark[value]=null;
				shark[value]=new Shark(r,c,sh.speed,d,value);
			}else {
				while(speed>0) {
					c+=dir[d];
					if(c <0  || c>=C) {
						c-=dir[d];
						if(d==3)
							d=4;
						else
							d=3;
						continue;
					}
					speed--;
				}
				shark[value]=null;
				shark[value]=new Shark(r,c,sh.speed,d,value);
			}
		}


		for(int i=0;i<shark.length;i++) {
			if(shark[i]==null)
				continue;
			Shark sh=shark[i];
			if(map[sh.r][sh.c]==0)
				map[sh.r][sh.c]=sh.value;
			else if(map[sh.r][sh.c]<sh.value) {
				shark[map[sh.r][sh.c]]=null;
				map[sh.r][sh.c]=sh.value;
			}else if(map[sh.r][sh.c]>sh.value) {
				shark[sh.value]=null;
			}
		}


	}




	static class Shark implements Comparable<Shark>{
		int r;
		int c;
		int dir;
		int value;
		int speed;
		Shark(int r,int c,int speed,int dir,int value){
			this.r=r;
			this.c=c;
			this.dir=dir;
			this.value=value;
			this.speed=speed;
		}
		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return this.value > o.value ? -1 : 1;
		}
	}
}

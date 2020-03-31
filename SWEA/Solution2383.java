package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution2383 {
	static int map[][];
	static int N,res;
	static ArrayList<XY> people;
	static ArrayList<XY> stair;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int t=1;t<=T;t++) {
			N=s.nextInt();
			res=1000000;
			people = new ArrayList<>();
			stair = new ArrayList<>();
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int persion=s.nextInt();
					if(persion==1) {
						people.add(new XY(i,j,0));
					}else if(persion>1) {
						stair.add(new XY(i,j,persion));
					}
					map[i][j]=persion;
				}
			}
			DFS(0);
			System.out.println("#"+t+" "+res);
		}
	}

	static void DFS(int depth) {

		if(depth == people.size()) {
			distance();
			PriorityQueue<XY> Z_queue =new PriorityQueue<>();
			PriorityQueue<XY> O_queue =new PriorityQueue<>();
			for(int i=0;i<people.size();i++) {
				if(people.get(i).team==0)
				Z_queue.add(people.get(i));
				else
					O_queue.add(people.get(i));
			}
			int time=play(Z_queue,map[stair.get(0).y][stair.get(0).x]);
			int time1=play(O_queue,map[stair.get(1).y][stair.get(1).x]);
			res=Math.min(res, Math.max(time, time1));
			return ;
		}


		for(int i=0;i<2;i++) {
			people.get(depth).team=i;
			DFS(depth+1);
		}
	}

	static int play(PriorityQueue<XY> pq,int DISTANCE) {
		if(pq.size()==0)
			return 0;
		
		Queue<XY> Wait_list =new LinkedList<>();
		Queue<XY> Run_list =new LinkedList<>();
		
		for(int t=0;t<Integer.MAX_VALUE;t++) {
			if(pq.isEmpty() && Wait_list.isEmpty() && Run_list.isEmpty()) {
				
				return t-1;
			}
			
			while(!pq.isEmpty() && pq.peek().dir==t) {
				Wait_list.add(pq.remove());
			}
			int Run_size=Run_list.size();
			while(Run_size-->0) {
				XY xy=Run_list.poll();
				xy.k+=1;
				if(xy.k==DISTANCE) {
					xy.k=0;
					xy.dir=0;
					continue;
				}
				Run_list.add(xy);
			}
			
			while(Run_list.size()<3 && !Wait_list.isEmpty()) {
				Run_list.add(Wait_list.remove());
			}
		}
		return 0;
	}

	static void distance() {
		for(int i=0;i<people.size();i++) {
			if(people.get(i).team==0) {
				int dist=Math.abs(stair.get(0).y-people.get(i).y)+Math.abs(stair.get(0).x-people.get(i).x)+1;
				people.get(i).dir=dist;
			}else {
				int dist=Math.abs(stair.get(1).y-people.get(i).y)+Math.abs(stair.get(1).x-people.get(i).x)+1;
				people.get(i).dir=dist;
			}
		}
	}

	static class XY implements Comparable<XY>{
		int y;
		int x;
		int dir;
		int team;
		int k=0;
		XY(int y,int x,int dir){
			this.y=y;
			this.x=x;
			this.dir=dir;
		}
		@Override
		public int compareTo(XY o) {
			// TODO Auto-generated method stub
			return this.dir > o.dir ? 1 : -1;
		}
	}

}

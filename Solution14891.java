import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution14891 {
	static int K;
	static int gear[][];
	static int dy[] = {1,-1};
	static int dx[] = {6,2};
	static boolean check[];
	static ArrayList<Dir> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++){
			K=s.nextInt();
			gear = new int[4][8];
			
			check = new boolean[4];
			list = new ArrayList<>();
			for(int i=0;i<4;i++) {
				for(int j=0;j<8;j++) {
					gear[i][j]=s.nextInt();
				}
			}
			

			for(int i=0;i<K;i++) {
				list = new ArrayList<>();
				check = new boolean[4];
				spin(s.nextInt()-1,s.nextInt());
				rotate();
			}
			int sum=0;
			if(gear[0][0]==0) {
				sum+=0;
			}
			if(gear[0][0]==1) {
				sum+=1;
			}
			if(gear[1][0]==0) {
				sum+=0;
			}
			if(gear[1][0]==1) {
				sum+=2;
			}
			if(gear[2][0]==0) {
				sum+=0;
			}
			if(gear[2][0]==1) {
				sum+=4;
			}
			if(gear[3][0]==0) {
				sum+=0;
			}
			if(gear[3][0]==1) {
				sum+=8;
			}

			System.out.println("#"+test_case+" "+sum);
		}
	}

	static void spin(int i,int j) {
		Queue<Dir> q = new LinkedList<>();
		q.add(new Dir(i,j));
		check[i]=true;
		while(!q.isEmpty()) {
			Dir dir = q.poll();
			list.add(new Dir(dir.i,dir.dir));
			for(int d=0;d<2;d++){
				int tmpy=dy[d]+dir.i;
				int tmpx=dx[d];
				if(checkmap(tmpy,tmpx)) {
					check[tmpy]=true;
					if(d==0) {
						if(gear[dir.i][2]==gear[tmpy][tmpx]) {
							q.add(new Dir(tmpy,0));
						}else {
							if(dir.dir==1) {
								q.add(new Dir(tmpy,-1));
							}else if(dir.dir==0){
								q.add(new Dir(tmpy,0));
							}else {
								q.add(new Dir(tmpy,1));
							}
						}
					}else {
						if(gear[dir.i][6]==gear[tmpy][tmpx]) {
							q.add(new Dir(tmpy,0));
						}else {
							if(dir.dir==1) {
								q.add(new Dir(tmpy,-1));
							}else if(dir.dir==0){
								q.add(new Dir(tmpy,0));
							}else {
								q.add(new Dir(tmpy,1));
							}
						}

					}
				}
			}
		}
	}
	static void rotate() {
		for(int i=0;i<list.size();i++) {
			Dir dir=list.get(i);
			int rotategear[] =new int[8];
			for(int j=0;j<8;j++) {
				int index=findindex(j,dir.dir);
				rotategear[index]=gear[dir.i][j];
			}
			gear[dir.i]=rotategear;
		}
	}

	static int findindex(int index,int dir) {
		if(dir==0) {
			return index;
		}else if(dir==1) {
			return (index+1)%8;
		}else {
			if(index-1<0) {
				return 8+(index-1);
			}
			return index-1;
		}
	}


	static boolean checkmap(int y,int x) {

		if(y<0 || y>=4 || x<0 || x>=8 || check[y]) {
			return false;
		}

		return true;
	}

	static class Dir{
		int i;
		int dir;
		Dir(int i,int dir){
			this.i=i;
			this.dir=dir;
		}
	}


}

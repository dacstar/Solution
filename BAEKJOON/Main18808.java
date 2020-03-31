package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18808 {
	static int rotate[]= {3,3,3,3};
	static int map[][];
	static int paper[][];
	static int R,C,K,r,c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			paper = new int[Math.max(r, c)][Math.max(r, c)];
			for(int i=0;i<r;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<c;j++) {
					paper[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int rr=0;rr<4;rr++) {
				boolean flag=false;
				for(int i=0;i<=R-r;i++) {
					if(flag)
						break;
					for(int j=0;j<=C-c;j++) {
						if(check(i,j)) {
							flag=true;
							break;
						}
					}
				}
				
				if(flag)
					break;
				rotate();
			}
			
		}
		int cnt=0;
	//	print();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void rotate() {
		int temp[][] =new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				temp[i][j]=paper[i][j];
			}
		}
		
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				paper[i][j]=temp[r-j-1][i];
			}
		}
		
		
		int t=r;
		r=c;
		c=t;
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.print(paper[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	
	
	
	static boolean check(int y,int x) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i+y][j+x]==1 && paper[i][j]==1) {
					return false;
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(paper[i][j]==1)
				map[i+y][j+x]=paper[i][j];
			}
		}
		return true;
	}


}

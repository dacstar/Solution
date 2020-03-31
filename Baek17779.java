import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17779 {

	static int N,MAX,MIN;
	static int d[];
	static int map[][],cmap[][];
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cmap= new int[N][N];
		MAX=Integer.MIN_VALUE;
		MIN=Integer.MAX_VALUE;
		d = new int[2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		/*d1,d2는 d1>=0 && d2>=0     이며
		 * (d1, d2 ≥ 0, 0 ≤ x < x+d1+d2 < N, 0 ≤ y-d1 < y < y+d2 < N)
		 *   이조건을 만족시키면 선거구 그리기
		 *   
		 *   
		 *   */
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						if(check(r,c,i,j))
						make(r,c,i,j);
					}
				}
			}
		}
		System.out.println(MIN);
	}
	

	
	static void calc() {
		int sum[] =new int[5];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cmap[i][j]==1) {
					sum[0]+=map[i][j];
				}else if(cmap[i][j]==2) {
					sum[1]+=map[i][j];
				}else if(cmap[i][j]==3) {
					sum[2]+=map[i][j];
				}else if(cmap[i][j]==4) {
					sum[3]+=map[i][j];
				}else {
					sum[4]+=map[i][j];
				}
			}
		}
		Arrays.sort(sum);
		MIN=Math.min(MIN, Math.abs(sum[0]-sum[4]));
	}
	

	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(cmap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("**********");
	}
	
	
	static void make(int r,int c,int d1,int d2) {
		//1번 선거구
		for(int i=0;i<r+d1;i++) {
			for(int j=0;j<=c;j++) {
				cmap[i][j]=1;
			}
		}
		//2번선거구
		for(int i=0;i<=r+d2;i++) {
			for(int j=c+1;j<N;j++) {
				cmap[i][j]=2;
			}
		}
		//3번선거구
		for(int i=r+d1;i<N;i++) {
			for(int j=0;j<c-d1+d2;j++) {
				cmap[i][j]=3;
			}
		}
		//4번선거구
		for(int i=r+d2+1;i<N;i++) {
			for(int j=c-d1+d2;j<N;j++) {
				cmap[i][j]=4;
			}
		}
		//5번선거구
		setBoundary(r,c,d1,d2);
		//인구수계산
		calc();
		
		
		
	}
	
	static boolean check(int r,int c,int d1,int d2) {
		if(r >= r+d1+d2 ||r+d1+d2 >=N || c-d1<0 || c+d2>=N || c >= c+d2 ) {
			return false;
		}
		
		return true;
	}
	
	
	 static void setBoundary(int x, int y, int d1, int d2) {
//		1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
//		2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
//		3. (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
//		4. (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		// 변화값 
		cmap[x][y] = 5;
		int adder1 = 0, adder2 = 0;

		while(++adder1 <= d1) cmap[x + adder1][y - adder1] = 5;
		while(++adder2 <= d2) cmap[x + adder2][y + adder2] = 5;
		
		adder1 = 0; adder2 = 0;
		while(++adder2 <= d2) cmap[x + d1 + adder2][y - d1 + adder2] = 5;
		while(++adder1 <= d1) cmap[x + d2 + adder1][y + d2 - adder1] = 5;
		
		// 5구역 채우기 
		for(int r = 0 ; r < N ; ++r) {
			int left = 0;
			int right = 0;
			
			int idx = 1;
			while(idx < N) {
				if(cmap[r][idx] == 5) {
					left = idx;
					break;
				}
				idx++;
			}
			
			idx = N-1;
			while(idx >= 0) {
				if(cmap[r][idx] == 5) {
					right = idx;
					break;
				}
				idx--;
			}
			
			if(left != right) {
				for(int i = left ; i < right ; ++i) cmap[r][i] = 5;
			}
		}
	}

}

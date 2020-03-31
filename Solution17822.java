import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17822 {

	static int N,M,T,x,d,k;
	static int circle[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static boolean check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int j=1;j<=N;j++) {
				if( j%x ==0) {
					rotate(j-1,d,k);
				}
			}
			checkplate();
		}
		int sum=0;
		for(int a=0;a<N;a++) {
			for(int b=0;b<M;b++) {
				sum+=circle[a][b];
			}
		}
		System.out.println(sum);
	}

	static void rotate(int x,int d,int k){
		int []rotatePlate = new int[M];
		for(int i=0;i<M;i++) {
			int index=circleindex(d,i,k);
			rotatePlate[index] = circle[x][i];
		}
		circle[x]=rotatePlate;
	}

	static void DFS(int y,int x,int num) {
		for(int i=0;i<4;i++) {
			int tmpy=dy[i]+y;
			int tmpx=(dx[i]+x)%M;
			if(tmpx<0)
				tmpx=M-1;
			if(check(tmpy,tmpx)){
				if(circle[tmpy][tmpx] == num) {
					circle[tmpy][tmpx]=0;
					DFS(tmpy,tmpx,num);
					check=true;
				}

			}
		}
	}

	static boolean check(int y,int x) {
		if(y < 0 || x< 0 || x>=M || y>=N) {

			return false;
		}
		return true;
	}

	static void checkplate() {
		boolean ischeck=false;
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				check=false;
				if(circle[i][j] !=0){
					DFS(i,j,circle[i][j]);
				}
				if(check) {
					circle[i][j]=0;
					ischeck=true;
				}

			}
		}
		if(!ischeck) {
			avgplate();
		}
	}

	//Æò±ÕÀ» ±¸ÇØ¼­ Æò±Õº¸´Ù ³ôÀ¸¸é -1 ³·À¸¸é +1
	static void avgplate() {
		double sum=0;
		double count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(circle[i][j]!=0) {
				sum+=circle[i][j];
				count++;
				}
			}
		}
		double avg=sum/(count);
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(circle[i][j]!=0 && circle[i][j]>avg) {
					circle[i][j]--;
				}else if(circle[i][j]!=0 && circle[i][j]<avg) {
					circle[i][j]++;
				}
			}
		}

	}

	static int circleindex(int d,int i,int k) {
		if(d==0) {
			return (i+k)%M;
		}
		if(i-k<0) {
			return M+(i-k);
		}

		return i-k;
	}







}

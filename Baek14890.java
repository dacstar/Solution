import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14890 {
	static int map[][];
	static boolean check[][];
	static int N,L;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new boolean[N][N];
		count=0;
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			if(Cango(i,0,0))
				count++;
			if(Cango(0,i,1))
				count++;
		}
		
		System.out.println(count);

		

	}
	
	static boolean Cango(int r,int c,int d) {
		int height[] = new int[N];
		boolean visit[] = new boolean[N];
		//d == 0 행
		//d == 1 열
		for(int i=0;i<N;i++) {
			if(d==0)
				height[i]=map[r][c+i];
			else
				height[i]=map[r+i][c];
		}
		
		
		for(int i=0;i<N-1;i++) {
			
			if(height[i] == height[i+1])
				continue;
			
			if(Math.abs(height[i] - height[i+1]) > 1)
				return false;
			//올라간다
			if(height[i]+1== height[i+1]) {
				for(int j=i;j>i-L;j--) {
					if( j<0 || height[i] != height[j] || visit[j])
						return false;
					visit[j]=true;
				}//내려간다
			}else if(height[i]-1 == height[i+1]) {
				for(int j=i+1;j<=i+L;j++) {
					if(  j>=N || height[i+1] !=height[j] || visit[j])
						return false;
					visit[j]=true;
					
				}
				
			}
			
		}
		return true;
	}














}

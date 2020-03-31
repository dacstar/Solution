import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dr {
	static int map[][],paper[][];
	static int N,M,R,C;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		paper = new int[Math.max(R, C)][Math.max(R, C)];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<4;i++) {
			rotate();
			print();
		}
		
		

	}
	static void rotate() {
		int temp[][] = new int[R][C];
		for(int i = 0; i < R; i++)
		      for(int j = 0; j < C; j++)
		        temp[i][j] = paper[i][j];

		    for(int i = 0; i < C; i++)
		      for(int j = 0; j < R; j++)
		        paper[i][j] = temp[R-1-j][i];

		    int t = R;
		    R = C;
		    C = t;
		
	}
	static void print() {
		for(int i=0;i<paper.length;i++) {
			for(int j=0;j<paper[i].length;j++) {
				System.out.print(paper[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}

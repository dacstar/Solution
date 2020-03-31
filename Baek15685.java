import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek15685 {
	static boolean [][]map;
	static int [][]dir;
	static int N,x,y,d,g,cnt;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dir = new int[N][4];
		cnt=0;
		map = new boolean[101][101];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				dir[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<N;i++) {
			drawing(dir[i][1],dir[i][0],dir[i][2],dir[i][3]);
		}
		find();
		System.out.println(cnt);

	}

	static void find() {
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					cnt++;
			}
		}
	}

	static void drawing(int y,int x,int d,int g) {
		ArrayList<Integer> diretion = new ArrayList<>();
		diretion.add(d);
		map[y][x]=true;
		while(g>0) {
			for(int i=diretion.size()-1;i>=0;i--){
				int dir=(diretion.get(i)+1)%4;
				diretion.add(dir);
			}
			g--;
		}

		for(int i=0;i<diretion.size();i++) {
			if(diretion.get(i) == 0) {
				map[y][++x]=true;
			}else if(diretion.get(i) == 1) {
				map[--y][x]=true;
			}else if(diretion.get(i) == 2) {
				map[y][--x]=true;
			}else if(diretion.get(i) == 3) {
				map[++y][x]=true;
			}
		}
	}

}

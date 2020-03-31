import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back15655 {
	static int N,M;
	static int arr[];
	static int num[];
	static boolean check[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		check = new boolean[N];
		Arrays.sort(arr);
		DFS(0,-1);
	}
	
	static void DFS(int depth,int idx) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=idx+1;i<N;i++) {
			if(check[i])
				continue;
			check[i]=true;
			num[depth]=arr[i];
			DFS(depth+1,i);
			check[i]=false;
		}
		
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back15656 {
	static int N,M;
	static int arr[],num[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		DFS(0,"");
	}
	
	static void DFS(int depth,String str) {
		if(depth == M) {
			System.out.println(str);
			return ;
		}
		
		
		for(int i=0;i<N;i++) {
			
			DFS(depth+1,str+arr[i]+" ");
		}
		
		
	}

}

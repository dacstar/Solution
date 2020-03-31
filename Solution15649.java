import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution15649 {
	static boolean check[];
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[M];
		check = new boolean[N+1];
		DFS(0,N,arr,1);

	}
	
	static void DFS(int start,int N,int arr[],int cnt) {
		
		if(start == M) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			return ;
		}
		
		for(int i=cnt;i<=N;i++) {
	
			arr[start]=i;
			DFS(start+1,N,arr,i);

		}
	}

}

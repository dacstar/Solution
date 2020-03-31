import java.util.Arrays;
import java.util.Scanner;

public class Back15657 {
	static int[] arr,num;
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		arr = new int[N];
		num = new int[M];
		for(int i=0;i<N;i++) {
			arr[i]=s.nextInt();
		}
		Arrays.sort(arr);
		DFS(0,"",0);
	}
	
	static void DFS(int start,String str,int value) {
		if(start == M) {
			System.out.println(str);
			return ;
		}
			
		
		
		for(int i=start;i<N;i++) {
			if(value <=arr[i])
			DFS(start+1,str+arr[i]+" ",arr[i]);
		}
		
	}

}

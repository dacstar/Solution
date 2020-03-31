import java.util.Scanner;

public class Solution8338 {
	static int arr[];
	static int N;
	static int max;

	public static void main(String[] args) throws ArithmeticException  {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			N=s.nextInt();
			arr = new int[N];
			max=Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				arr[i]=s.nextInt();
			}
			
			DFS(1,arr[0]);
			System.out.println(max);
			
		}
		
		

	}
	
	
	static void DFS(int depth,int sum) {
		
		if(depth == N) {
			max=Math.max(max, sum);
			return;
		}
		
		DFS(depth+1,sum+=arr[depth]);
		sum-=arr[depth];
		int before=sum;
		DFS(depth+1,sum*=arr[depth]);
		sum=before;
	}

}

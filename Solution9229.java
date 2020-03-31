import java.util.Scanner;

public class Solution9229 {
	static int MAX;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=s.nextInt();
			int M=s.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=s.nextInt();
			}
			int list[] = new int[2];
			boolean check[] = new boolean[N];
			MAX=-1;
			DFS(arr,list,0,check,N,M);
			
			System.out.println(MAX);
		}
	}
	
	static void DFS(int arr[],int list[],int start,boolean check[],int N,int M){
		if(start ==2) {
			int sum=0;
			for(int i=0;i<2;i++) {
				sum+=list[i];
				if(sum>M) {
					return ;
				}
			}
			MAX=Math.max(sum, MAX);
			return ;
		}
		
		
	
		for(int i=0;i<N;i++) {
			if(check[i])
				continue;
			check[i]=true;
			list[start]=arr[i];
			DFS(arr,list,start+1,check,N,M);
			check[i]=false;
		}
	}

}

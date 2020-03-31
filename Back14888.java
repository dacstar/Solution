import java.util.Scanner;

public class Back14888 {
	static int N;
	static int arr[];
	static int operater[];
	static int max,min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		arr = new int[N];
		operater =new int[4];
		for(int i=0;i<N;i++) {
		arr[i]=s.nextInt();	
		}
		for(int i=0;i<4;i++) {
			operater[i]=s.nextInt();
		}
		DFS(0,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void DFS(int depth,int sum) {
		if(depth ==N-1) {
			max=Math.max(max, sum);
			min=Math.min(min,sum);
			return ;
		}
		
		for(int i=0;i<4;i++) {
			if(operater[i]>0) {
				if(i==0) {
					operater[i]--;
				    DFS(depth+1,sum+arr[depth+1]);
				    operater[i]++;
				}else if(i==1) {
					operater[i]--;
				    DFS(depth+1,sum-arr[depth+1]);
				    operater[i]++;
					
				}else if(i==2) {
					operater[i]--;
				    DFS(depth+1,sum*arr[depth+1]);
				    operater[i]++;
					
				}else if(i==3) {
					operater[i]--;
				    DFS(depth+1,sum/arr[depth+1]);
				    operater[i]++;
				}
			}
			
		}
	}

}

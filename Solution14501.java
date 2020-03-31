import java.util.Scanner;

public class Solution14501 {
	static int N;
	static int sum;
	static boolean check[];
	static Table table[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		table = new Table[N];
		check = new boolean[N];

		for(int i=0;i<N;i++) {
			table[i] =new Table(s.nextInt(),s.nextInt());
		}
		sum=Integer.MIN_VALUE;
		DFS(0,0);

		System.out.println(sum);




	}

	static void DFS(int start,int num) {
			if(start==N) {
				sum=Math.max(num, sum);
				return ;
			}
			
			if(num>sum)
				sum=Math.max(num, sum);
		

		for(int i=start;i<N;i++) {
			if(check[i])
				continue;
			if(table[i].t<=N-i){
				check[i]=true;
				DFS(i+table[i].t,table[i].p+num);
				check[i]=false;
			}
		}



	}


	static class Table{
		int t;
		int p;
		Table(int t,int p){
			this.t=t;
			this.p=p;
		}


	}

}

import java.util.Scanner;

public class Baek16922 {
	static boolean check[];
	static int number[]= {1,5,10,50};
	static int N;
	static int count;
	static boolean num[]=new boolean[1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		check = new boolean[N];
		DFS(0,0,0,"");
		System.out.println(count);
	}
	
	static void DFS(int depth,int res,int idx,String str){
		if(N==depth) {
			System.out.println(str);
			if(!num[res]) {
				count++;
			}
			return ;
		}
		
		for(int i=idx;i<4;i++) {
			DFS(depth+1,res+number[i],i,str+i+" ");
		}
	}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution5949 {
	static int N;
	static int arr[];
	static boolean check[];
	static boolean visit[];
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			N=3;
			check =new boolean[300];
			list = new ArrayList<>();
			arr = new int[7];
			visit = new boolean[7];
			for(int i=0;i<7;i++) {
				arr[i]=s.nextInt();
			}
			DFS(0,0,0);
			Collections.sort(list);
			System.out.println("#"+t+" "+list.get(list.size()-5));
		}
	}
	
	static void DFS(int depth,int idx,int res) {
		if(depth==N) {
			if(!check[res]) {
				list.add(res);
				check[res]=true;
			}
			return ;
		}
		
		
		for(int i=idx;i<7;i++) {
			if(visit[i])
				continue;
			visit[i]=true;
			DFS(depth+1,i,res+arr[i]);
			visit[i]=false;
		}
		
		
	}

}

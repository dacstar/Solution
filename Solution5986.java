import java.util.ArrayList;
import java.util.Scanner;

public class Solution5986 {
	static ArrayList<Integer> list;
	static int N,count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T =s.nextInt();
		for(int t=1;t<=T;t++) {
			N=s.nextInt();
			count=0;
			list = new ArrayList<Integer>();
			for(int i=2;i<N;i++) {
				boolean check=false;
				for(int j=2;j<i;j++) {
					if(i%j==0)
						check=true;
				}
				if(!check)
					list.add(i);
			}
			DFS(0,0,0);
			System.out.println("#"+t+" "+count);
		}
	}
	static void DFS(int depth,int res,int idx) {
		if(depth==3) {
			if(res==N)
				count++;
			return ;
		}
		
		for(int i=idx;i<list.size();i++) {
			DFS(depth+1,res+list.get(i),i);
		}
	}

}

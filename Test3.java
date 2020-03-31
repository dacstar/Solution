import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
	static boolean check[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=4;
		int firecraker[]= {10, 7, 5, 2, 1, 6, 0, 1, 3, 1,10, 7, 5, 2, 1, 6, 0, 1, 3, 1};
		System.out.println(firecraker.length);
		check = new boolean[firecraker.length];
		for(int i=0;i<firecraker.length;i++) {
			if(firecraker[i]==0)
				
				continue;
			BFS(firecraker[i],i);
		}
		int res=0;
		for(int i=0;i<check.length;i++) {
			if(!check[i])
				res++;
			System.out.print(check[i]+" ");
		}
		System.out.println(res);
	}
	
	static boolean check(int fire,int index,int N) {
		if(index-fire<0)
			return false;
		
		return true;
	}
	
	static void BFS(int fire,int index) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(fire);
		
		while(!q.isEmpty()) {
			int f=q.poll();
			index--;
			if(index>=0) {
				check[index]=true;
				f--;
				if(f>0)
				q.add(f);
			}
		}
	}

}

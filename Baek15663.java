import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Baek15663 {
	static int arr[];
	static int N,M;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		M=s.nextInt();
		arr= new int[10001];
		int max=0;
		Set<Integer> tree= new TreeSet<Integer>(); 
		for(int i=0;i<N;i++) {
			int a = s.nextInt();
			tree.add(a);
			arr[a]++;
		}
		
		list = new ArrayList<Integer>(tree);
		DFS(0,"",0);
	}
	static void DFS(int depth,String str,int idx) {
		if(depth == M) {
			System.out.println(str);
			
			return ;
		}
		
		
		for(int i=idx;i<list.size();i++) {

			DFS(depth+1,str+list.get(i)+" ",i);
		}
		
		
	}
	
	

}

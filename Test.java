import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		Node node[] = new Node[N+1];
		for(int i=0;i<=N;i++) {
			node[i]=new Node();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int j=Integer.parseInt(st.nextToken());
			node[i].parent=j;
			node[j].child.add(i);
		}
		long res=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int root=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			ArrayList<Integer> test=BFS(root,node);
			ArrayList<Integer> test2=BFS(child,node);
			res+=(test.size()-test2.size());
		}
		System.out.println(res);
		
	}
	
	
	static ArrayList<Integer> BFS(int idx,Node[] node) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(idx);
		while(!q.isEmpty()) {
			int index=q.poll();
			for(int i=0;i<node[index].child.size();i++) {
				q.add(node[index].child.get(i));
				list.add(node[index].child.get(i));
			}
		}
		
		return list;
	}
	
	static class Node{
		int parent;
		ArrayList<Integer> child;
		public Node() {
			super();
			this.child=new ArrayList<Integer>();
		}
	}

}

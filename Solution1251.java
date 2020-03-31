import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1251 {
	private static Node[] nodes, lines;
	private static int[] parents;
	
	private static class Node implements Comparable<Node>{
		int x,y;
		long p;
		
			private Node(int x,int y) {
				this.x=x;
				this.y=y;
			}

			@Override
			public int compareTo(Node o) {
				// TODO Auto-generated method stub
				return Long.compare(this.p, o.p);
			}
		
	}
	
	private static int find(int x) {
		if(parents[x]<0)
			return x;
		
		return parents[x]=find(parents[x]);
	}
	
	
	private static boolean union(int a,int b) {
		int aroot=find(a);
		int broot=find(b);
		
		if(aroot != broot) {
			parents[broot]=aroot;
			return true;
		}
		
		return false;
		
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			double ans=0;
			int N= Integer.parseInt(br.readLine());
			String []X = br.readLine().split(" ");
			String []Y = br.readLine().split(" ");
		nodes  = new Node[N];
		parents = new int[N];
			for(int i=0;i<N;i++) {
				nodes[i] = new Node(Integer.parseInt(X[i]),Integer.parseInt(Y[i]));
			}
			 double e = Double.parseDouble(br.readLine());
		lines = new Node[(N*(N-1))/2];
		int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                lines[cnt] = new Node(i, j);
                lines[cnt++].p = (long)(nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x)
                        + (long)(nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y);
            }
        }


			
			Arrays.sort(lines);
			Arrays.fill(parents,-1);
			for(int i=0;i<lines.length;i++) {
				Node node=lines[i];
				if(node.p==0)
					continue;
				if(union(node.x,node.y)) {
					ans+=node.p;
				}
			}
			ans*=e;
			System.out.println("#"+t+" "+Math.round(ans));
			
			
		}
	}

}

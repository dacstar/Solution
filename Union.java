
public class Union {
	static int parent[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent = new int[8];
		
		for(int i=1;i<=7;i++) {
			parent[i]=-1;
		}
		if(union(1,2))
				System.out.println("성공");
		if(union(1,3))
			System.out.println("성공");
		if(union(2,3))
			System.out.println("성공");
		else {
			System.out.println("실패");
		}
		

	}
	
	private static int find(int a) {
		if(parent[a] <0) return a;
		return parent[a] =find(parent[a]);
	}
	 private static boolean union(int a, int b) {
	        int aRoot = find(a);
	        int bRoot = find(b);
	        if (aRoot != bRoot) {
	        	parent[bRoot] = aRoot;
	            return true;
	        }
	        return false;
	    }

}

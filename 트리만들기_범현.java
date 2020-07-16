
public class 트리만들기_범현 {
	static String answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String input = "ABCDEF";
	      String output = "DEBFCA";
		Node [] root = new Node[input.length()];
		Node tree = new Node("A");
		for(int i=0;i<input.length();i++) {
			root[i] = new Node(input.charAt(i)+"");
		}
		for(int i=1;i<root.length;i++) {
			addNode(tree,root,root[i],0);
		}
		answer="";
		postorder(tree);
		  if (answer.equals(output)) {
		         System.out.println("정답");
		      } else {
		         System.out.println("오답");
		         System.out.println(answer);
		      }
	}
	
	public static void addNode(Node root,Node []parent,Node child,int idx) {
		if(root.left == null && root.right == null) {
			root.left=child;
		}else if(root.left !=null && root.right == null) {
			root.right=child;
		}else {
			addNode(parent[idx+1],parent,child,idx+1);
		}
		
	}
	
	public static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			answer+=root.str;
			
		}
	}
	
	
	public static class Node{
		Node left;
		Node right;
		String str;
			Node(String str){
				this.str=str;
			}
	}

}

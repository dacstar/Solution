import java.util.ArrayList;
import java.util.Collections;

public class 길찾기게임 {
	static int idx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodeinfo[][] = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };

		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}
		Collections.sort(list);
		Node root = list.get(0);
		int result[][] = new int[2][list.size()];
		for(int i=1;i<list.size();i++) {
			addNode(root,list.get(i));
		}
		idx=0;
		preorder(result,root);
		idx=0;
		afterorder(result,root);
		System.out.println("-1");
	}

	public static class Node implements Comparable<Node> {
		int x;
		int y;
		int num;
		Node left;
		Node right;

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.y == o.y) {
				return this.x > o.x ? 1 : -1;
			}
			return this.y > o.y ? -1 : 1;
		}
	}

	public static void addNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null) {
				parent.left = child;
			} else {
				addNode(parent.left, child);
			}
		} else {
			if (parent.right == null) {
				parent.right = child;
			} else {
				addNode(parent.right, child);
			}
		}

	}

	public static void preorder(int[][] arr,Node root) {

			if(root != null) {
				arr[0][idx++]=root.num;
				preorder(arr,root.left);
				preorder(arr,root.right);
			}
	}

	public static void afterorder(int[][] arr,Node root) {
		if(root != null) {
			afterorder(arr,root.left);
			afterorder(arr,root.right);
			arr[1][idx++]=root.num;
			
		}
	}

}

package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233 {
	static Node[] tree;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new Node[N + 1];
			boolean check = false;
			for (int i = 1; i <= N; i++) {
				String st[] = br.readLine().split(" ");
				int no = Integer.parseInt(st[0]);
				String item = st[1];

				if (st.length == 4) {
					tree[no] = new Node(item, st[2], st[3]);
				} else if (st.length == 3) {
					tree[no] = new Node(item, st[2], "0");
				} else
					tree[no] = new Node(item, "0", "0");
			}

			for (int i = N; i >= 1; i--) {
				if (Integer.parseInt(tree[i].left) == 0) {
					String str = tree[i].item;
					if (str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/")) {
						check = true;
						break;
					}
				} else if (Integer.parseInt(tree[i].left) != 0) {
					String str = tree[i].item;
					if (!str.equals("*") && !str.equals("+") && !str.equals("-") && !str.equals("/")) {
						String l = tree[i].left;
						String r = tree[i].right;
						if (l.equals("*") || l.equals("+") || l.equals("-") || l.equals("/") || r.equals("/")
								|| r.equals("*") || r.equals("+") || r.equals("-")) {
							check = true;
							break;
						}
					}
				}
			}
			if (check)
				System.out.println("#" + t + " " + "0");
			else
				System.out.println("#" + t + " " + "1");
		}

	}

	public static class Node {
		String item;
		String left;
		String right;

		public Node(String item, String left, String right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}

}

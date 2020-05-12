package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1232 {
	static Node[] tree;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int no = Integer.parseInt(st.nextToken());
				String item = st.nextToken();
				if (st.hasMoreTokens()) {
					tree[no] = new Node(item, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else {
					tree[no] = new Node(item, 0, 0);
				}
			}

			for (int i = N; i >= 1; i--) {
				if (tree[i].left != 0) {
					int var1 = Integer.parseInt(tree[tree[i].left].item);
					int var2 = Integer.parseInt(tree[tree[i].right].item);
					switch (tree[i].item) {

					case "+":
						tree[i].item = String.valueOf((var1 + var2));
						break;

					case "-":

						tree[i].item = String.valueOf((var1 - var2));
						break;

					case "*":

						tree[i].item = String.valueOf((var1 * var2));
						break;

					case "/":

						tree[i].item = String.valueOf((var1 / var2));
						break;
					}

				}
			}

			System.out.println("#"+t+" "+tree[1].item);
		}

	}

	public static class Node {
		String item;
		int left;
		int right;

		public Node(String item, int left, int right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}

}

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZumaGame {
	static int balls[] = new int[100];
	static int max = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String board = "RBYYBBRRB";
		String hand = "YRBGB";
		for (char word : hand.toCharArray()) {
			balls[word]++;
		}

		DFS(board, 0);
		if (max == 1000) {
			System.out.println("-1");
		} else
			System.out.println(max);
	}

	public static void DFS(String board, int cnt) {
		int len = board.length();
		if (len == 0) {
			max = Math.min(max, cnt);
			return;
		}

		for (int i = 0; i < len; i++) {
			char color = board.charAt(i);
			int j = i;
			while (j < len && board.charAt(i) == board.charAt(j)) {
				j++;
			}

			int need = 2 - (j - i) < 0 ? 0 : 2 - (j - i);
			if (balls[color] >= need) {
				balls[color] -= need;
				DFS(board.substring(0, i) + board.substring(j, len), cnt + need);
				balls[color] += need;
			}

		}

	}

}

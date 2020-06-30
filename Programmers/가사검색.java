package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 가사검색 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = { "frodoa", "frontaa", "frostaaa", "f", "f", "ka" };
		String queries[] = { "fro??", "????o", "fr???", "fro???", "pro?" };

		for (int i = 0; i < queries.length; i++) {
			int len = queries[i].length();
			int left = queries[i].indexOf("?");
			int right = queries[i].lastIndexOf("?");
			String str = "";
			XY xy;
			if (right != queries[i].length() - 1) {
				xy = new XY(right + 1, queries[i].length());
				str = queries[i].substring(right + 1, queries[i].length());
			} else if (left == 0 && right == queries[i].length() - 1) {
				str = "";
				xy = new XY(0, queries[i].length());
			} else {
				xy = new XY(0, left);
				str = queries[i].substring(0, left);
			}
			int num=0;
			for (int j = 0; j < words.length; j++) {
				int len2 = words[j].length();
				if(len<len2) {
					break;
				}else if(len>len2) {
					continue;
				}
				String s = words[j].substring(xy.start, xy.end);
				if (str.equals(s) || str.equals("")) {
					num++;
				}
			}
			System.out.print(num+" ");
			
		}

	

	}

	public static int find(String str, int d) {
		if (d == 0) {
			return str.indexOf("?");
		} else {
			return str.lastIndexOf("?");
		}
	}

	public static class XY {
		int start;
		int end;

		XY(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}

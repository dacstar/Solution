package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1991 {
	static int tree[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		tree= new int[26][2];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			int r=str.charAt(0)-'A';
			char l=str.charAt(2);
			char R=str.charAt(4);
			if(l == '.') {
				tree[r][0]=-1;
			}else {
				tree[r][0]=l-'A';
			}
			if(R == '.') {
				tree[r][1]=-1;
			}else {
				tree[r][1]=R-'A';
			}
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
	
	public static void preorder(int root) {
		if(root == -1)
			return ;
		System.out.print((char)(root+'A'));
		preorder(tree[root][0]);
		preorder(tree[root][1]);
	}
	
	public static void inorder(int root) {
		if(root == -1)
			return ;
		inorder(tree[root][0]);
		System.out.print((char)(root+'A'));
		inorder(tree[root][1]);
	}
	
	public static void postorder(int root) {
		if(root == -1)
			return ;
		postorder(tree[root][0]);
		postorder(tree[root][1]);
		System.out.print((char)(root+'A'));
		
		
	}

}

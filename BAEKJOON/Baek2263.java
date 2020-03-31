package BAEKJOON;

import java.util.Scanner;

public class Baek2263 {
	static int N,cnt;
	static int inorder[],in_index[],postorder[];
	static int tree[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		N=s.nextInt();
		inorder = new int[100000];
		postorder = new int[100000];
		in_index = new int[100000];
		for(int i=0;i<N;i++) {
			inorder[i]=s.nextInt();
		}
		for(int i=0;i<N;i++) {
			postorder[i]=s.nextInt();
		}
		for(int i=0;i<N;i++){
			in_index[inorder[i]]=i;
		}
		preorder(0,N-1,0,N-1);
		
	}
	
	static void preorder(int lf,int ls,int rf,int rs) {
		if(lf >ls || rf >rs)
			return ;
		int root=postorder[rs];
		System.out.print(root+" ");
		int lsecond=in_index[root];
		preorder(lf,lsecond-1,rf,rf+lsecond-1);
		preorder(lsecond+1,ls,rf+lsecond,rs-1);
		
	}
	
	
	


}

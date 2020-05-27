package Programmers;

import java.util.Stack;

public class Programmers_카카오인턴 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		int moves[] = {1,5,3,5,1,2,1,4};
		int board[][] = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		
		int sum=0;
		for(int i=0;i<moves.length;i++) {
			int c=moves[i]-1;
			for(int j=0;j<board.length;j++) {
				if(board[j][c] != 0) {
					if(st.size() !=0 && st.peek() == board[j][c]) {
						st.pop();
						sum+=2;
						board[j][c]=0;
						break;
					}else {
						st.add(board[j][c]);
						board[j][c]=0;
						break;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

}

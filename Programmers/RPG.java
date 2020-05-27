package Programmers;

import java.util.ArrayList;

public class RPG {

	static ArrayList<Integer> []list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int skills[][]= {{1,2},{1,3},{3,6},{3,4},{3,5}};
		int total_sp=121;
		int top=-1;
		list = new ArrayList[skills.length+2];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<skills.length;i++) {
				list[skills[i][0]].add(skills[i][1]);

		}
		int result[] =new int[list.length-1];
		double sum=0;
		for(int i=0;i<result.length;i++) {
			result[i]=DFS(i+1);
			sum+=result[i];
		}
		
		for(int i=0;i<result.length;i++) {
			double res=result[i]/sum;
			result[i]=(int)(total_sp*res);
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	public static int DFS(int depth) {
		if(list[depth].size() ==0) {
			return 1;
		}else {
			int sum=0;
			for(int i=0;i<list[depth].size();i++) {
				sum+=DFS(list[depth].get(i));
			}
			return sum;
		}
	}

}

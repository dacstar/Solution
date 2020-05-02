package Programmers;

import java.util.Arrays;

public class K¹øÂ°¼ö {
	public static void main(String[] args) {
		int array[] = {1,5,2,6,3,7,4};
		int commands[][]= {
				{2,5,3},
				{4,4,1},
				{1,7,3}
				
		};
		int []answer= new int[commands.length];
		for(int k=0;k<commands.length;k++) {
			int A[] =  new int[3];
			for(int d=0;d<3;d++) {
				A[d]=commands[k][d]-1;
			}
			
			int arr[] = new int[Math.abs(A[0]-A[1])+1];
			for(int a=0;a<=Math.abs(A[0]-A[1]);a++) {
				arr[a]=array[a+A[0]];
			}
			Arrays.sort(arr);
			answer[k]=arr[A[2]];
		}
		
	}
}

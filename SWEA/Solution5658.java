package SWEA;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution5658 {

	public static void main(String[] args) {


		Scanner s = new Scanner(System.in);
		int T =s.nextInt();
		for(int t=1;t<=T;t++) {
			int N=s.nextInt();
			 Set<Integer> number2 = new HashSet<>();
			 ArrayList<Integer> number = new ArrayList<>();
			int K=s.nextInt();
			int N2=N/4;
			int cnt=N2+1;
			String arr[] = new String[N];
			arr = s.next().split("");
			String arr2[] = new String[N];
			while(cnt-->0) {
				for(int i=0;i<arr.length-(N2-1);i+=N2) {
					StringBuilder str = new StringBuilder();
					for(int j=i;j<N2+i;j++) {
						str.append(arr[j]);
					}
					//System.out.print(str+" ");
					int hexInt=Integer.parseInt(str+"", 16);
					number2.add(hexInt);
				}
				//System.out.println();
					for(int i=0;i<arr2.length;i++) {
						arr2[i]=arr[((N-1)+i)%N];
					}
					for(int i=0;i<arr2.length;i++) {
						arr[i]=arr2[i];
					}
			}
			 for(int spell: number2){
				 number.add(spell);
		        }
			Collections.sort(number,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 > o2 ? -1 : 1;
				}
			});
			System.out.println("#"+t+" "+number.get(K-1));
		}
	}

}

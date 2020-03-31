import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution_greedy5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int min=-5;
		int max=3;
		int d=0;
		int positions[]= {-1,-3,3};
		TreeSet<Integer> list = new TreeSet<>();
		Arrays.sort(positions);
		d=Math.abs(positions[0]-positions[1]);
		for(int i=0;i<n;i++) {
			boolean check=false;
			for(int j=0;j<positions.length;j++) {
				if(positions[j]==min) {
					check=true;
				}
			}
			if(!check)
				list.add(min);
			min+=d;
		}
		for(int val : list) {
			System.out.println(val);
		}
	}

}

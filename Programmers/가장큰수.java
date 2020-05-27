package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 가장큰수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]= {6,10,2};
		PriorityQueue<XY> pq = new PriorityQueue<>();
		for(int i=0;i<numbers.length;i++) {
			pq.add(new XY(numbers[i]));
		}
		String str="";
		while(!pq.isEmpty()){
			str+=pq.poll().value+"";
		}
		if(str.charAt(0)=='0')
			str="0";
		
		
		
	}
	
	
	public static class XY implements Comparable<XY>{
		int value;
			XY(int value){
				this.value=value;
			}
			@Override
			public int compareTo(XY o) {
				// TODO Auto-generated method stub
				String str=o.value+"";
				String str2=this.value+"";
				str+=this.value;
				str2+=o.value;
				long a=Long.parseLong(str);
				long b=Long.parseLong(str2);
				return b > a ? -1 : 1;
			}
		
		
	}
	
	

}

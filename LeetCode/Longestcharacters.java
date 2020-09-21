package LeetCode;

import java.util.ArrayList;

public class Longestcharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="pwwkew";
		ArrayList<String> list = new ArrayList<String>();
		int end=0;
		int answer=-1;
		for(int start=0;start<s.length();start++) {
			while(end<s.length()) {
				if(list.contains(s.charAt(end)+""))
					break;
				
				list.add(s.charAt(end)+"");
				end++;
			}
			answer=Math.max(list.size(), answer);
			list.remove(0);
		}
		System.out.println(answer);
	}
	
	

}

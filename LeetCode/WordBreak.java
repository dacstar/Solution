package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WordBreak {
	static boolean visit;
	static TreeMap<String,Boolean> map;
	static ArrayList<String> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a";
		list = new ArrayList<String>();
		 ArrayList<String>wordDict = new ArrayList<String>();
		 wordDict.add("a");
		 visit=false;
		 map = new TreeMap<String, Boolean>();
		 TopDown(wordDict,s);
		 for(int i=0;i<list.size();i++) {
			 System.out.print(list.get(i)+" ");
		 }
	}
	
	public static boolean TopDown(List<String> word,String s) {
		
		if(word.contains(s)) {
			list.add(s);
			return true;
		}
		if(s.length() == 1)
			return false;
		if(map.containsKey(s))
			return map.get(s);
			
		
		boolean ans=false;
		for(int i=0;i<s.length()-1;i++) {
			String s1=s.substring(0,i+1);
			String s2=s.substring(i+1,s.length());
			
			boolean b1 = TopDown(word,s1);
			boolean b2 = TopDown(word,s2);
			
			if(b1 && b2) {
				ans=true;
				break;
			}
		}
		map.put(s, ans);
		return ans;
		
		
	}
	
//	public static void DFS(ArrayList<String>word,String str,String s) {
//		if(visit)
//			return ;
//		if(str.length() > s.length())
//			return ;
//		if(str.equals(s)) {
//			visit=true;
//			return ;
//		}
//		
//		for(int i=0;i<word.size();i++) {
//			DFS(word,str+word.get(i),s);
//		}
//	}

}

package SWEA;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class East01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]= {5,5,5,5,5};
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i=0;i<A.length;i++) {
			map.put(A[i],0);
		}
		for(int i=0;i<A.length;i++) {
			if(map.containsKey(A[i])) {
				int getkey=map.get(A[i]);
				getkey++;
				map.put(A[i],getkey);
			}
		}
		int max=-1;
		int idx=0;
		Iterator<Integer> it= map.keySet().iterator();
		while(it.hasNext()) {
			int key=it.next();
			int cnt=map.get(key);
			if(max<cnt) {
				max=cnt;
				idx=key;
			}
		}
		if(max%idx==0)
			System.out.println(idx);
		else
			System.out.println(0);
		
		
	}
	


}

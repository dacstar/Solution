package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,Integer> tree = new TreeMap<>();
		TreeSet<Integer> set =new TreeSet<Integer>();
		int nums1[] = {1,2};
		int nums2[] = {3,4};
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums1.length;i++) {
			list.add(nums1[i]);
		}
		for(int i=0;i<nums2.length;i++) {
			list.add(nums2[i]);
		}
		double answer=0.0;
		Collections.sort(list);
		if(list.size()%2 == 0) {
			answer=(list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
		}else {
			System.out.println(list.size()/2);
			answer=list.get(list.size()/2);
		}
		
		
		System.out.println(answer);
		
		
	}

}

package LeetCode;

import java.util.Arrays;
import java.util.TreeMap;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = {2,7,11,15};
		int target = 9;
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++) {
		  map.put(nums[i], i);
		}
		int answer[] = new int[2];
		for(int i=0;i<nums.length;i++) {
			int value=Math.abs(target-nums[i]);
			if(map.containsKey(value)) {
			    if(map.get(value) == i)
                    continue;
				answer[0]=i;
				answer[1]=map.get(value);
				break;
			}
		}
		System.out.println(answer[0]+" "+answer[1]);
	}
}

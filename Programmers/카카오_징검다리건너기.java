package Programmers;

import java.util.Arrays;

public class 카카오_징검다리건너기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = {2,4,5,3,2,1,4,2,5,1};
		int max[] = stones.clone();
		Arrays.sort(max);
		int k=3;
		int right=max[max.length-1];
		int left=1;
		int res=0;
		while(left<=right) {
			int mid=(left+right)/2;
			if(people(stones,k,mid-1)) {
				left=mid+1;
				res=mid;
			}else {
				right=mid-1;
			}
		}
		System.out.println(res);
	}


	public static boolean people(int stones[],int k,int people) {


		int K=0;
		for(int i=0;i<stones.length;i++) {
			if(K==k)
				return false;
			if(stones[i]-(people) <=0) {
				K++;
			}else {
				K=0;
			}
		}
		if(K==k)
			return false;
		
		return true; 	
	}

}

import java.util.Arrays;

public class test05_3 {
    public static int solution(int[] stones, int k) {
    	int[] sorted = stones.clone();
    	Arrays.sort(sorted);
    	
        int answer = Integer.MAX_VALUE;
        int low = 0;
        int mid = 0;
        int high = sorted.length - 1;
        
        while(low<=high) {
        	mid = (low+high)/2;
        	int count =0;
    		for(int j=0; j< stones.length; j++) {
    			if(stones[j] - sorted[mid] <=0) {
    				count++;
    				if(count == k) {
    					break;
    				}
    			}else {
    				count = 0;
    			}
    		}
    		if(count < k) {
    			low = mid+1;
    		}else {
    			if(answer > sorted[mid]) {
    				answer = sorted[mid];
    			}
    			high = mid-1;
    		}
        }
        return answer;
    }
    public static void main(String[] args) {
		int k = 3;
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, k));
	}
}

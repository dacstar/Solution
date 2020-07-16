import java.util.HashMap;

public class 중복당첨 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {1,2,3};
		long result=Integer.MAX_VALUE;
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				long day=Math.abs(map.get(arr[i]) - i);
				result=Math.min(day, result);
				map.put(arr[i], (long)i);
			}else {
				map.put(arr[i], (long)i);
			}
		}
		
		
		
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
		System.out.println(result);
		}
	}

}

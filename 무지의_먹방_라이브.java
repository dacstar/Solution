
public class 무지의_먹방_라이브 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int food_times[]= {3,1,1,1,2,4,3};
		int k=12;
		int sum=0;
		for(int i=0;i<food_times.length;i++) {
			sum+=food_times[i];
		}
		if(k >= sum) {
			System.out.println(-1);
			return ;
		}
		   int cnt=0;
			for(long i=0;i<k;i++) {
				if(food_times[cnt] !=0) {
					food_times[cnt++]--;
					cnt=cnt%food_times.length;
				}else {
	                int count=0;
					while(true) {
	                    if(count == food_times.length) {
	                       System.out.println(-1);
	                    	return ;
	                    }
						if(food_times[cnt] !=0) {
							break;
						}else {
							cnt++;
							cnt=cnt%food_times.length;
	                        count++;
						}
					}
					food_times[cnt++]--;
					cnt=cnt%food_times.length;
				}
			}
	        if(food_times[cnt] ==0){
	            boolean check=true;
	        for(int i=cnt;i<food_times.length;i++) {
				if(food_times[i]!=0) {
					cnt=i;
	                check=false;
					break;
				}
			}
	            if(check){
	            	   System.out.println(-1);
                   	return ;
	            }
	        }
		System.out.println(cnt+1);
	}
	/*
	 * 4, 3, 5, 6, 2 / k=7일때 결과값3
4,1,1,5 / k=4 > 결=1, 5>4, 6>1, 7>4
	 * 
	 */

}
